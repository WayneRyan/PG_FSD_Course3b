<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/28/2022
  Time: 10:26 AM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create Account</h2>
<form action="LoginController" method="post">
    <label>Email</label>
    <input type="email" name="email" /><br>
    <label>Password</label>
    <input type="password" name="password" /><br>
    <input type="submit" value="SignUp">
    <input type="reset" value="reset">
</form><br/>
<a href="index.jsp">Login Page!</a>
</body>
</html>
