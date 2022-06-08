<%@ page import="com.entity.StudentsEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/8/2022
  Time: 7:23 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>Student</th>
    <th>Course</th>
    </thead>
    <% for (StudentsEntity se : allStudents) { %>
    <tr>
        <td><%= se.getName() %>
        </td>
        <td><%= se.getCourse().getName() %>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
