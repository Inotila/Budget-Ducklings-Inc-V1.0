package dao;

import connectors.DbConnector;
import profiledb.Invoices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoicesDao {

    public boolean addInvoice(Invoices invoice) {
        String sql = "INSERT INTO Invoices (title, payment_date, expense_description, price, profile_id, category_id, category_title,username) " +
                "VALUES (?, ?, ?, ?, ?, ?,?,?)";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, invoice.getTitle());
            preparedStatement.setDate(2, new java.sql.Date(invoice.getPaymentDate().getTime()));
            preparedStatement.setString(3, invoice.getExpenseDescription());
            preparedStatement.setDouble(4, invoice.getPrice());
            preparedStatement.setInt(5, invoice.getProfileId());
            preparedStatement.setInt(6, invoice.getCategoryId());
            preparedStatement.setString(7, invoice.getCategoryTitle());
            preparedStatement.setString(8, invoice.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoices> getAllInvoices() {
        List<Invoices> invoices = new ArrayList<>();
        String sql =  "SELECT i.id, i.title, i.payment_date, i.expense_description, i.price, i.profile_id, i.category_id, " +
                "c.title AS category_title, p.username " +
                "FROM Invoices i " +
                "JOIN Category c ON i.category_id = c.id " +
                "JOIN Profile p ON i.profile_id = p.id";
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
                invoice.setUsername(resultSet.getString("username"));
                invoice.setCategoryTitle(resultSet.getString("category_title"));

                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    public boolean deleteInvoice(int invoiceId) {
        String sql = "DELETE FROM Invoices WHERE id = ?";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, invoiceId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Invoices getInvoiceById(int invoiceId) {
        Invoices invoice = null;
        String sql = "SELECT * FROM Invoices WHERE id = ?";

        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, invoiceId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    invoice = new Invoices();
                    invoice.setId(resultSet.getInt("id"));
                    invoice.setTitle(resultSet.getString("title"));
                    invoice.setPaymentDate(resultSet.getDate("payment_date"));
                    invoice.setExpenseDescription(resultSet.getString("expense_description"));
                    invoice.setPrice(resultSet.getDouble("price"));
                    invoice.setProfileId(resultSet.getInt("profile_id"));
                    invoice.setCategoryId(resultSet.getInt("category_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public boolean updateInvoice(int invoiceId, String updatedTitle, Date updatedPaymentDate, String updatedExpenseDescription,
                                 double updatedPrice) {
        String sql = "UPDATE Invoices SET title = ?, payment_date = ?, expense_description = ?, " +
                "price = ? WHERE id = ?";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedTitle);
            preparedStatement.setDate(2, new java.sql.Date(updatedPaymentDate.getTime()));
            preparedStatement.setString(3, updatedExpenseDescription);
            preparedStatement.setDouble(4, updatedPrice);
            preparedStatement.setInt(5, invoiceId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


