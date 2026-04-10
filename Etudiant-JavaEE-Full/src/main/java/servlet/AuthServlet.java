package servlet;

import dao.UserDAO;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Please enter username and password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        User u = userDAO.findByUsername(username.trim());
        if (u == null || !BCrypt.checkpw(password, u.getPasswordHash())) {
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", u.getUsername());
        session.setAttribute("role", u.getRole());

        response.sendRedirect("student?action=list");
    }
}
