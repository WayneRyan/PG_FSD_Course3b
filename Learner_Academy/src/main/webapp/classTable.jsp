<%@ page import="com.entity.ClassesEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/8/2022
  Time: 7:19 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <thead>
  <th>Class</th>
  <th>Subject</th>
  <th>Teacher</th>
  </thead>
  <% for (ClassesEntity ce : allClasses) { %>
  <tr>
    <td><a href="ClassServlet?class_id=<%= ce.getId() %>"><i class="fa-solid fa-trash-can"></i></a><a href="classReport.jsp?class_id=<%= ce.getId() %>"><%= ce.getName() %></a></td>
    <td><a href="subjectReport.jsp?subject_id=<%= ce.getSubject().getId() %>"><%= ce.getSubject().getName() %></a></td>
    <td><a href="teacherReport.jsp?teacher_id=<%= ce.getTeacher().getId() %>"><%= ce.getTeacher().getName() %></a></td>
  </tr>
  <% } %>
</table>

</body>
</html>
