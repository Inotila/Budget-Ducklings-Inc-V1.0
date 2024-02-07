package servlets;

import dao.InvoicesDao;
import profiledb.Invoices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewinvoices")
public class ViewInvoicesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all invoices using the invoicesDao
        InvoicesDao invoicesDao = new InvoicesDao();
        List<Invoices> invoices = invoicesDao.getAllInvoices();

        if (!invoices.isEmpty()) {
            request.setAttribute("invoices", invoices);
        }
        request.setAttribute("invoices", invoices);
        request.getRequestDispatcher("/viewinvoices.jsp").forward(request, response);
    }
}
