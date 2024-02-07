<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/partials/head.jsp" %>

<body>
   <%@ include file="/partials/homerow.jsp" %>
     <div class="row">
            <div class="col text-center ">
                <h2>Hi <%= session.getAttribute("username") %>! Your sign-up was successful!</h2>
                <br>
                <a href="./signin.jsp" class="mt-3">proceed to sign-in</a>
            </div>
     </div>
</body>
</html>