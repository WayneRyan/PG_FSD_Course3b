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
    <td><%= ce.getName() %>
    </td>
    <td><%= ce.getSubject().getName() %>
    </td>
    <td><%= ce.getTeacher().getName() %>
    </td>
  </tr>
  <% } %>
</table>

</body>
</html>
