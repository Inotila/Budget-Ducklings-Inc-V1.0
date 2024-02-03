
package servlets;

import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.getWriter().println("this is the username " + username);

        response.sendRedirect("signin");

    }
}
