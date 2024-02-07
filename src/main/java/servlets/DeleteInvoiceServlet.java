package servlets;

import dao.InvoicesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteinvoice")
public class DeleteInvoiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the invoice ID
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

        // Delete invoice using InvoicesDao
        InvoicesDao invoicesDao = new InvoicesDao();
        boolean success = invoicesDao.deleteInvoice(invoiceId);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/viewinvoices");
        } else {
            response.getWriter().println("Failed to delete the invoice.");
        }
    }
}