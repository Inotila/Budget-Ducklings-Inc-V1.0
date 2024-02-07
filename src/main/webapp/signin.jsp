<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>
<body>
    <div class="row">
        <div class="col text-center">
            <h1 class="text-center mt-3">Budget Ducklings</h1>
              <a href="./index.jsp" >click here to return to home page</a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="text-center mt-3">
                <h2>Sign In or Create an Account</h2>
            </div>
            <div class="text-center mt-3">
                <!-- Add your sign-in or create account form here -->
                <form action="/budget-ducklings-inc/signin" method="post">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                    <br>
                    <button class="btn btn-success" type="submit">Sign In</button>
                </form>
                <p class="mt-3">Don't have an account? <a href="./signup.jsp">Create a new account</a> </p>
            </div>
        </div>
    </div>
</body>
</html>
