package servlets;

import connectors.DbConnector;
import profiledb.Profile;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        // Insert the new profile into the database
        if (saveProfile(newProfile)) {
            // Set the session attribute for username
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("signupsuccess.jsp");
        } else {
            response.getWriter().println("Failed to create a profile for username: " + username);
        }
    }

    private boolean saveProfile(Profile profile) {
        // Implement the logic to save the profile into the database
        String sql = "INSERT INTO profile (name, surname, username, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setString(3, profile.getUsername());
            preparedStatement.setString(4, profile.getPassword());

            // Execute the SQL query
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Returns true if the profile is successfully inserted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}