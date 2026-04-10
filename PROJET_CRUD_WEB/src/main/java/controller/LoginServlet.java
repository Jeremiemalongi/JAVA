package controller;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String role = userDAO.login(username, password);

        if (role != null) {
            // ✅ OK
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
            session.setAttribute("role", role);

            response.sendRedirect("StudentServlet?action=list");
        } else {
            // ❌ KO
            request.setAttribute("error", "Mot de passe ou nom d'utilisateur incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // si on tape /LoginServlet dans l'URL
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

