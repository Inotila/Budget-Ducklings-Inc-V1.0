<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/partials/head.jsp" %>
<body>
    <div class="row">
        <div class="col text-center">
            <h1 class="text-center mt-3">Budget Ducklings Inc| Sign-up</h1>
            <a href="./index.jsp" >click here to return to home page</a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="text-center mt-3">
                <h2>Create a New Account</h2>
            </div>
            <div class="text-center mt-3">
                <form action="/budget-ducklings-inc/signup" method="post">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
                    <br>
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>
                    <br>
                    <label for="surname">Surname:</label>
                    <input type="text" id="surname" name="surname" required>
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                    <br>
                    <label for="re-enter-password">Re-enter Password:</label>
                    <input type="password" id="re-enter-password" name="re-enter-password" required>
                    <br>
                    <button class="btn btn-success" type="submit">Create Account</button>
                </form>
                <p class="mt-3">Already have an account? <a href="./signin.jsp">Sign In</a></p>
            </div>
        </div>
    </div>
</body>
</html>
