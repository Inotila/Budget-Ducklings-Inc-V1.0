package servlets;

import dao.ProfileDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        System.out.println("It works " + username);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Process the form submission here
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ProfileDao profileDao = new ProfileDao();
        boolean isAuthenticated = profileDao.authenticateUser(username, password);

        if (isAuthenticated) {
            // Set the session attribute for the authenticated user
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Redirect to the home page
            response.sendRedirect("index.jsp");
        } else {
            // Forward back to the login page with an error message
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }
}