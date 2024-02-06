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
            <div class="col text-center ">
              <h1>Oops! Something went wrong.</h1>
              <p>Error details: ${pageContext.errorData}</p>
            </div>
     </div>
</body>
</html>