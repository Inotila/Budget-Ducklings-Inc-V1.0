package servlets;

import dao.InvoicesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/updateinvoice")
public class UpdateInvoiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
            String updatedTitle = request.getParameter("title");
            Date updatedPaymentDate = Date.valueOf(request.getParameter("payment_date"));
            String updatedExpenseDescription = request.getParameter("expense_description");
            double updatedPrice = Double.parseDouble(request.getParameter("price"));

            InvoicesDao invoicesDao = new InvoicesDao();
            boolean success = invoicesDao.updateInvoice(invoiceId, updatedTitle, updatedPaymentDate, updatedExpenseDescription,
                    updatedPrice);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/viewinvoices");
            } else {
                response.getWriter().println("Failed to update the invoice.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format. Please provide valid numeric data.");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Invalid input. Please provide valid data.");
        }
    }
}
