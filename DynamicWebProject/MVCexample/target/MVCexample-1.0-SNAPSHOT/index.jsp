<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/28/2022
  Time: 10:26 AM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Welcome to MVC Application</h2>
<%! int a=6; %>
<% int b=8; %>
<%= a*b %>
<%@include file="signIn.jsp"%>
</body>
</html>