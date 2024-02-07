<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="profiledb.Invoices" %>
<%@ include file="/partials/head.jsp" %>

<body>
<%@ include file="/partials/homerow.jsp" %>
<div class="row">
    <div class="col text-center">
        <h2>Edit Invoice</h2>
    </div>
</div>
<div class="row">
    <div class="col text-center">
        <form action="/budget-ducklings-inc/updateinvoice" method="post">
            <input type="hidden" name="invoiceId" value="<%= request.getParameter("invoiceId") %>">
            <% if (request.getAttribute("invoice") != null) {
                Invoices invoice = (Invoices) request.getAttribute("invoice"); %>
                <label for="title">Title:</label>
                <input type="text" name="title" value="<%= invoice.getTitle() %>">
                <br>
                <label for="payment_date">Date:</label>
                <input type="date" name="payment_date" value="<%= invoice.getPaymentDate() %>">
                <br>
                <label for="expense_description">Description</label>
                <input type="text" id="expense_description" name="expense_description"  value="<%= invoice.getExpenseDescription() %>">
                  <br>
                  <label for="category">Category:</label>
                  <select id="category" name="category_id">
                      <option value="1" <%= invoice.getCategoryId() == 1 ? "selected" : "" %>>Travel</option>
                      <option value="2" <%= invoice.getCategoryId() == 2 ? "selected" : "" %>>Food and Entertainment</option>
                      <option value="3" <%= invoice.getCategoryId() == 3 ? "selected" : "" %>>Stationery</option>
                      <option value="4" <%= invoice.getCategoryId() == 4 ? "selected" : "" %>>Sundry</option>
                  </select>
                <br>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="<%= invoice.getPrice() %>">
                <br>
                <label for="profile_id">Profile ID:</label>
                <input type="text" id="profile_id" name="profile_id" value="<%= invoice.getProfileId() %>" readonly>
                <br>
                <label for="category_id">Category ID:</label>
                <input type="text" id="category_id" name="category_id" value="<%= invoice.getCategoryId() %>" readonly>
                <br>
                <button class="btn btn-primary" type="submit">Update</button>
            <% } else { %>
                <p>Error: Unable to retrieve invoice details.</p>
            <% } %>
        </form>
    </div>
</div>
</body>
</html>
