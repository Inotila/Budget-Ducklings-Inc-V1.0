package servlets;

import dao.InvoicesDao;
import dao.ProfileDao;
import profiledb.Invoices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addinvoices")
public class AddInvoicesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String paymentDateString = request.getParameter("payment_date");
        String expenseDescription = request.getParameter("expense_description");
        String priceString = request.getParameter("price");
        int categoryId = Integer.parseInt(request.getParameter("category")); //

        // Additional user authentication
        String username = (String) request.getSession().getAttribute("username");
        ProfileDao profileDao = new ProfileDao();
        int profileId = profileDao.getUserIdByUsername(username);

        // Validate and parse date
        Date paymentDate = null;
        try {
            paymentDate = new SimpleDateFormat("yyyy-MM-dd").parse(paymentDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle date parsing error
            response.sendRedirect("/budget-ducklings-inc/error-page"); // Redirect to an error page
            return; // Exit the method to avoid further processing
        }

        // Validate and parse price
        double price = 0.0;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle price parsing error
            response.sendRedirect("/budget-ducklings-inc/error-page"); // Redirect to an error page
            return; // Exit the method to avoid further processing
        }

        // Create Invoices object
        Invoices invoice = new Invoices();
        invoice.setTitle(title);
        invoice.setPaymentDate(paymentDate);
        invoice.setExpenseDescription(expenseDescription);
        invoice.setPrice(price);
        invoice.setProfileId(profileId);
        invoice.setCategoryId(categoryId); // Set the category_id

        // Add the invoice using invoicesDao
        InvoicesDao invoicesDao = new InvoicesDao();
        if (invoicesDao.addInvoice(invoice)) {
            // Invoice added successfully
            response.sendRedirect("/budget-ducklings-inc/viewinvoices.jsp"); // Redirect to viewinvoices.jsp page
        } else {
            response.sendRedirect("/budget-ducklings-inc/error-page"); // Redirect to an error page
        }
    }
}
