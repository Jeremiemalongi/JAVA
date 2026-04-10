package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("StudentServlet called: action=" + request.getParameter("action"));
        

        String action = request.getParameter("action");
        if (action == null || action.trim().isEmpty()) action = "list";

        try {
            switch (action) {
                case "list":
                    listStudents(request, response);
                    break;

                case "edit":
                    showEditForm(request, response);
                    break;

                case "delete":
                    deleteStudent(request, response);
                    break;

                default:
                    // si action inconnue -> list
                    response.sendRedirect("StudentServlet?action=list");
                    break;
            }
        } catch (SQLException e) {
            // afficher l'erreur dans la page
            request.setAttribute("error", "Erreur SQL : " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID incorrect.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // On lit l'action envoyée par le formulaire
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "insert":
                    insertStudent(request, response);
                    break;

                case "update":
                    updateStudent(request, response);
                    break;

                default:
                    response.sendRedirect("StudentServlet?action=list");
                    break;
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Erreur SQL : " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Fee ou ID incorrect.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // ----------------- METHODS -----------------

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {

    List<Student> students = dao.getAll();

    System.out.println("Students loaded = " + students.size()); // DEBUG

    request.setAttribute("students", students);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
}


    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String feeStr = request.getParameter("fee");

        // Validation simple
        if (name == null || name.trim().isEmpty()
                || course == null || course.trim().isEmpty()
                || feeStr == null || feeStr.trim().isEmpty()) {
            response.sendRedirect("StudentServlet?action=list");
            return;
        }

        BigDecimal fee = new BigDecimal(feeStr);

        Student s = new Student(name.trim(), course.trim(), fee);
        dao.insert(s);

        // Message optionnel
        // request.getSession().setAttribute("success", "Student added successfully!");

        response.sendRedirect("StudentServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = dao.getById(id);

        if (student == null) {
            response.sendRedirect("StudentServlet?action=list");
            return;
        }

        request.setAttribute("student", student);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        BigDecimal fee = new BigDecimal(request.getParameter("fee"));

        Student s = new Student(id, name.trim(), course.trim(), fee);
        dao.update(s);

        response.sendRedirect("StudentServlet?action=list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);

        response.sendRedirect("StudentServlet?action=list");
    }
}


