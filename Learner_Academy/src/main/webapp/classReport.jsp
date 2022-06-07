<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/7/2022
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        String user_name = (String) session.getAttribute("user_name");
        if (user_name == null || !user_name.equals("admin")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>
<h3>Class Report</h3>
</body>
</html>
