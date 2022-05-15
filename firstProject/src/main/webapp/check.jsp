<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/15/2022
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!String email,password; %>
<%
  email = request.getParameter("email");
  password = request.getParameter("password");
%>
<%= email%><br>
<%= password%>
</body>sadfasdf
</html>
