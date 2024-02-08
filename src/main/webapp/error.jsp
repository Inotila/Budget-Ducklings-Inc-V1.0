<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>
<body>
   <%@ include file="/partials/homerow.jsp" %>
     <div class="row">
            <div class="col text-center ">
              <h1>Oops! Something went wrong.</h1>
              <p>${requestScope.errorMessage}</p>
            </div>
     </div>
</body>
</html>