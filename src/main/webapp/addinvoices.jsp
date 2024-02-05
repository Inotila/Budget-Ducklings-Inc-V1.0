<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>

<body>
<div class="row">
        <div class="col">
            <h1 class="text-center mt-3">Budget Ducklings Inc</h1>
            <h2 class="text-center mt-3">Add Expense</h2>
            <br>
             <% if (session.getAttribute("username") != null) { %>
                <p id="user-profile-link" class="text-center mt-1">Logged in: <a href="#"> <%= session.getAttribute("username") %> </a></p>
             <% } %>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="text-center mt-3">
                <form action="/budget-ducklings-inc/addinvoices" method="post">
                    <label for="title">title:</label>
                    <input type="text" id="title " name="title " required>
                    <br>
                    <label for="payment_date">Date:</label>
                    <input type="text" id="payment_date" name="payment_date" required>
                    <br>
                    <label for="expense_description">Description</label>
                    <input type="text" id="expense_description" name="expense_description" required>
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
