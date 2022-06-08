<%@ page import="com.entity.TeachersEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/8/2022
  Time: 6:43 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <% for (TeachersEntity te : allTeachers) { %>
    <li><a href="teacherReport.jsp?teacher_id=<%= te.getId() %>"><%= te.getName() %></a>
    </li>
    <% } %>
</ul>
</body>
</html>
