
package servlets;

import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");

        System.out.println("this is the username" + username);
    }
}
