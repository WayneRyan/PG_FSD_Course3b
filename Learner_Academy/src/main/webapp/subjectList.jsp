<%@ page import="com.entity.SubjectsEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/8/2022
  Time: 6:38 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <% for (SubjectsEntity se : allSubjects) { %>
    <li><a href="SubjectServlet?subject_id=<%= se.getId() %>"><i class="fa-solid fa-trash-can"></i></a><a
            href="subjectReport.jsp?subject_id=<%= se.getId() %>"><%= se.getName() %>
    </a>
    </li>
    <% } %>
</ul>

</body>
</html>
