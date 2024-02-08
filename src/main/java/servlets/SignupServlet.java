package servlets;

import connectors.DbConnector;
import profiledb.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String password = request.getParameter("password");

            // Create a Profile object with the user details
            Profile newProfile = new Profile();
            newProfile.setName(name);
            newProfile.setUsername(username);
            newProfile.setSurname(surname);
            newProfile.setPassword(password);

            // Add new profile into the database
            if (saveProfile(newProfile)) {
                // Set the session attribute for username
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("signupsuccess.jsp");
            } else {
                request.setAttribute("error", "Failed to create a profile for username: " + username);
                request.setAttribute("errorMessage", "Error details: Failed to create a profile for username: " + username);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            request.setAttribute("error", "An unexpected error occurred during signup.");
            request.setAttribute("errorMessage", "Error details: An unexpected error occurred during signup.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);

        }
    }

    private boolean saveProfile(Profile profile) {
        String sql = "INSERT INTO profile (name, surname, username, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setString(3, profile.getUsername());
            preparedStatement.setString(4, profile.getPassword());

            // Execute the SQL query
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
