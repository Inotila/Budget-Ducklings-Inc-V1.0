package connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection getConnection() throws SQLException {
        try {
            // Attempt to load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/budget_ducklings_inc";
        String username = "root";
        String password = "Chicken1sDaB3st@1010";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("connected now");
        return connection;
    }
}
