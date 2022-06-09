<%@ page import="com.entity.SubjectsEntity" %>
<%@ page import="com.dao.SubjectDao" %>
<%@ page import="com.entity.ClassesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/7/2022
  Time: 6:45 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject Report</title>
    <link rel="stylesheet" href="CSS/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
</head>
<body class="center">
<%
    int subject_id = -1;
    String user_name = (String) session.getAttribute("user_name");
    try {
        subject_id = Integer.parseInt(request.getParameter("subject_id"));
    } catch (Exception e){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    if (subject_id == -1 || user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    SubjectsEntity subent = SubjectDao.getSubject(subject_id);
    List<ClassesEntity> allClasses = new ArrayList<>(subent.getClasses());
%>
<h3><a href="admin.jsp"><i class="fa-solid fa-house"></i></a>Subject Report For: <%=subent.getName()%></h3>
<%@include file="classTable.jsp"%>
</body>
</html>
