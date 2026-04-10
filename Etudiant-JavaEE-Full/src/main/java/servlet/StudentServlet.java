package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@WebServlet("/student")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class StudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    private String ensureUploadsFolder(HttpServletRequest request) throws IOException {
        String appPath = request.getServletContext().getRealPath("");
        String uploadPath = appPath + File.separator + "uploads";
        Files.createDirectories(Paths.get(uploadPath));
        return uploadPath;
    }

    private String savePhoto(HttpServletRequest request, Part photoPart) throws IOException {
        if (photoPart == null || photoPart.getSize() == 0) return null;

        String contentType = photoPart.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) return null;

        String uploadPath = ensureUploadsFolder(request);

        String ext = ".jpg";
        String submitted = photoPart.getSubmittedFileName();
        if (submitted != null) {
            String lower = submitted.toLowerCase();
            if (lower.endsWith(".png")) ext = ".png";
            else if (lower.endsWith(".jpeg")) ext = ".jpeg";
            else if (lower.endsWith(".webp")) ext = ".webp";
        }

        String fileName = UUID.randomUUID().toString() + ext;
        String fullPath = uploadPath + File.separator + fileName;

        photoPart.write(fullPath);
        return "uploads/" + fileName;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                response.sendRedirect("student?action=list");
                return;
            }

            if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student edit = dao.findById(id);
                request.setAttribute("editStudent", edit);
            }

            List<Student> list = dao.getAll();
            request.setAttribute("students", list);

            // ✅ ton JSP design
            request.getRequestDispatcher("students.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "add";

        try {
            if ("add".equals(action)) {
                Student s = new Student();
                s.setName(request.getParameter("name"));
                s.setEmail(request.getParameter("email"));     // ✅ nouveau
                s.setCourse(request.getParameter("course"));
                s.setFee(new BigDecimal(request.getParameter("fee")));

                Part photoPart = request.getPart("photo");
                s.setPhotoPath(savePhoto(request, photoPart));

                dao.insert(s);
                response.sendRedirect("student?action=list");
                return;
            }

            if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student existing = dao.findById(id);

                Student s = new Student();
                s.setId(id);
                s.setName(request.getParameter("name"));
                s.setEmail(request.getParameter("email"));     // ✅ nouveau
                s.setCourse(request.getParameter("course"));
                s.setFee(new BigDecimal(request.getParameter("fee")));

                Part photoPart = request.getPart("photo");
                String newPhoto = savePhoto(request, photoPart);

                if (newPhoto != null) s.setPhotoPath(newPhoto);
                else s.setPhotoPath(existing != null ? existing.getPhotoPath() : null);

                dao.update(s);
                response.sendRedirect("student?action=list");
                return;
            }

            response.sendRedirect("student?action=list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
