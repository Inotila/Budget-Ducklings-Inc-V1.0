<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<html>
<%@ include file="/partials/head.jsp" %>

<body>
    <div class="row">
        <div class="col">
            <h1 class="text-center mt-3">Budget Ducklings Inc</h1>
            <br>
            <% if (session.getAttribute("username") != null) { %>
                <p id="user-profile-link" class="text-center mt-1">Logged in: <a href="#"> <%= session.getAttribute("username") %> </a></p>
            <% } %>
        </div>
    </div>
    <div class="row">
        <div class="col text-center"  >
            <div id="invoice-table-container" class="mx-auto" style="width: 50%;">
                <table class="table text-white">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Payment Date</th>
                            <th>Expense Description</th>
                            <th>Price</th>
                            <th>Profile ID</th>
                            <th>Category ID</th>
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
                                        <td><%= invoice.getProfileId() %></td>
                                        <td><%= invoice.getCategoryId() %></td>
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
            if ($('#invoice-table-container tbody').is(':empty')) {
                $.get('/budget-ducklings-inc/viewinvoices', function (data) {
                    $('#invoice-table-container tbody').html(data);
                }).fail(function (xhr, status, error) {
                    console.error('Error fetching invoices: ' + error);
                });
            }
        });
    </script>
</body>
</html>
