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
        <td><a href="StudentServlet?student_id=<%= se.getId() %>"><i
                class="fa-solid fa-trash-can"></i></a><%= se.getName() %>
        </td>
        <td><a href="classReport.jsp?class_id=<%= se.getCourse().getId() %>"><%= se.getCourse().getName() %>
        </a></td>
    </tr>
    <% } %>
</table>

</body>
</html>
