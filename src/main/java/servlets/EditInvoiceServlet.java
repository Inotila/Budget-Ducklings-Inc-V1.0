package servlets;

import dao.InvoicesDao;
import profiledb.Invoices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editinvoice")
public class EditInvoiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the invoice ID
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

        // Retrieving the Invoices object associated with the invoiceId
        InvoicesDao invoicesDao = new InvoicesDao();
        Invoices invoice = invoicesDao.getInvoiceById(invoiceId);

        request.setAttribute("invoice", invoice);

        request.getRequestDispatcher("/editinvoice.jsp").forward(request, response);
    }
}

