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
    <title>Class Report</title>
    <link rel="stylesheet" href="CSS/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
</head>
<body>
<%
        String user_name = (String) session.getAttribute("user_name");
        if (user_name == null || !user_name.equals("admin")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>
<h3><a href="admin.jsp"><i class="fa-solid fa-house"></i></a>Class Report</h3>
</body>
</html>
