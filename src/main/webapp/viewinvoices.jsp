<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ include file="/partials/head.jsp" %>

<body>
<%@ include file="/partials/homerow.jsp" %>
 <div class="row">
        <div class="col text-center">
            <a href="./addinvoices.jsp" class="btn btn-primary mb-3">Add Invoices</a>
        </div>
    </div>
    <div class="row">
        <div class="col text-center">
            <div id="invoice-table-container" class="mx-auto" style="width: 70%;">
                <table class="table text-white">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Payment Date</th>
                            <th>Expense Description</th>
                            <th>Price</th>
                            <th>Logged by:</th>
                            <th>Category</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<profiledb.Invoices> invoicesList = (List<profiledb.Invoices>) request.getAttribute("invoices");
                            if (invoicesList != null) {
                                for (profiledb.Invoices invoice : invoicesList) { %>
                                    <tr>
                                        <td><%= invoice.getId() %></td>
                                        <td><%= invoice.getTitle() %></td>
                                        <td><%= invoice.getPaymentDate() %></td>
                                        <td><%= invoice.getExpenseDescription() %></td>
                                        <td><%= invoice.getPrice() %></td>
                                        <td><%= invoice.getUsername() %></td>
                                        <td><%= invoice.getCategoryTitle() %></td>
                                       <% if (session.getAttribute("username") != null && session.getAttribute("username").equals(invoice.getUsername())) { %>
                                        <td id="delete-row">
                                            <form action="/budget-ducklings-inc/deleteinvoice" method="post">
                                              <input type="hidden" name="invoiceId" value="<%= invoice.getId() %>">
                                              <button class="btn btn-warning" type="submit">Delete</button>
                                            </form>
                                        </td>
                                        <td id="delete-row">
                                            <form action="/budget-ducklings-inc/editinvoice" method="post">
                                              <input type="hidden" name="invoiceId" value="<%= invoice.getId() %>">
                                              <button class="btn btn-info" type="submit">Edit</button>
                                            </form>
                                        </td>
                                       <% } %>
                                    </tr>
                                <% }
                            } else { %>
                                <tr>
                                    <td colspan="7">No invoices available</td>
                                </tr>
                            <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function () {
            function fetchInvoices() {
                $.get('/budget-ducklings-inc/viewinvoices', function (data) {
                    // Temporary div to hold the HTML data cause old code was duplicating entire html tags
                    var tempDiv = $('<div>').html(data);

                    // Extract the tbody content
                    var tbodyContent = tempDiv.find('#invoice-table-container tbody').html();

                    // Update the tbody with the extracted content
                    $('#invoice-table-container tbody').html(tbodyContent);
                }).fail(function (xhr, status, error) {
                    console.error('Error fetching invoices: ' + error);
                });
            }
            // Fetch when the page loads
            fetchInvoices();
        });
    </script>
</body>
</html>
