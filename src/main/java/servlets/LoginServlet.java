package servlets;

import dao.ProfileDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ProfileDao profileDao = new ProfileDao();
        boolean isAuthenticated = profileDao.authenticateUser(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Redirect to the home page
            response.sendRedirect("/index.jsp");
        } else {
            // Redirect back to the login page with an error message
            response.sendRedirect("/login?error=1");
        }
    }
}