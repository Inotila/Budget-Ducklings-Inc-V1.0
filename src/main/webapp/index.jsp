<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <% if (session.getAttribute("username") != null) { %>
            <div class="col text-center ">
                <a href="./viewinvoices.jsp" class="btn btn-primary mt-3">View Invoices</a>
            </div>
             <% } %>
            <div class="col text-center ">
              <% if (session.getAttribute("username") == null) { %>
                    <a id="signin-link" href="./signin.jsp" class="btn btn-primary mt-3">Sign-in</a>
              <% } else { %>
                    <a id="signout-link" href="./logout.jsp" class="btn btn-warning mt-3">Sign-out</a>
              <% } %>
            </div>
     </div>
</body>
</html>