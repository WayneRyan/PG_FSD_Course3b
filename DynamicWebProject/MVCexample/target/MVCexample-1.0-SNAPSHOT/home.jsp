<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/28/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String user = (String)session.getAttribute("user");
    out.println("Welcome to Home Page " + user);
%>
</body>
</html>
