<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>

<body>
<div class="row">
        <div class="col text-center">
            <h1 class="mt-3">Budget Ducklings Inc</h1>
                <a href="./index.jsp" >click here to return to home page</a>
            <br>
             <% if (session.getAttribute("username") != null) { %>
                <p id="user-profile-link" class="text-center mt-1">Logged in: <a href="#"> <%= session.getAttribute("username") %> </a></p>
             <% } %>
        </div>
    </div>
    <div class="row">
        <div class="col mt-3">
            <div class="text-center">
                <form action="/budget-ducklings-inc/logout" method="post">
                    <p>would you like to logout?</p>
                    <button class="btn btn-danger" type="submit">Logout</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
