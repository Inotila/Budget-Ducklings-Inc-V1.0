<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
        <div class="col">
            <div class="text-center">
                <h1 class="text-center my-3">Budget Ducklings Inc</h1>
                <a href="./index.jsp" >click here to return to home page</a>
                <% if (session.getAttribute("username") != null) { %>
                    <p id="user-profile-link" class="text-center mt-3">Logged in: <a href="#"> <%= session.getAttribute("username") %> </a></p>
                <% } %>
            </div>
        </div>
 </div>