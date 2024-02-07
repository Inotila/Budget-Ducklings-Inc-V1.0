<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>
<body>
<%@ include file="/partials/homerow.jsp" %>
<div class="row">
    <div class="col">
        <h2 class="text-center mt-1">Add Expense</h2>
    </div>
</div>
<div class="row">
    <div class="col">
        <div class="text-center mt-3">
            <form action="/budget-ducklings-inc/addinvoices" method="post">
                <label for="title">title:</label>
                <input type="text" id="title " name="title" required>
                <br>
                <label for="payment_date">Date:</label>
                <input type="date" id="payment_date" name="payment_date" required>
                <br>
                <label for="expense_description">Description</label>
                <input type="text" id="expense_description" name="expense_description" required
                  <br>
                  <label for="category">Category:</label>
                  <select id="category" name="category" required>
                      <option value="1">Travel</option>
                      <option value="2">Food and Entertainment</option>
                      <option value="3">Stationery</option>
                      <option value="4">Sundry</option>
                  </select>
                <br>
                <label for="price">Price:</label>
                <input type="price" id="price" name="price" required>
                <br>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
