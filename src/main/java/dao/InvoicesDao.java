package dao;

import connectors.DbConnector;
import profiledb.Invoices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoicesDao {

    public boolean addInvoice(Invoices invoice) {
        String sql = "INSERT INTO Invoices (title, payment_date, expense_description, price, profile_id, category_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, invoice.getTitle());
            preparedStatement.setDate(2, new java.sql.Date(invoice.getPaymentDate().getTime()));
            preparedStatement.setString(3, invoice.getExpenseDescription());
            preparedStatement.setDouble(4, invoice.getPrice());
            preparedStatement.setInt(5, invoice.getProfileId());
            preparedStatement.setInt(6, invoice.getCategoryId());
            System.out.println("test add");
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoices> getAllInvoices() {
        System.out.println("test get all");
        List<Invoices> invoices = new ArrayList<>();
        String sql = "SELECT * FROM Invoices";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Invoices invoice = new Invoices();
                invoice.setId(resultSet.getInt("id"));
                invoice.setTitle(resultSet.getString("title"));
                invoice.setPaymentDate(resultSet.getDate("payment_date"));
                invoice.setExpenseDescription(resultSet.getString("expense_description"));
                invoice.setPrice(resultSet.getDouble("price"));
                invoice.setProfileId(resultSet.getInt("profile_id"));
                invoice.setCategoryId(resultSet.getInt("category_id"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }
}


