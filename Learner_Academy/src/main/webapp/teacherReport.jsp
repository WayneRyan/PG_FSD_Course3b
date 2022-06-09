<%@ page import="com.entity.TeachersEntity" %>
<%@ page import="com.dao.TeacherDao" %>
<%@ page import="com.entity.ClassesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/7/2022
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Report</title>
    <link rel="stylesheet" href="CSS/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
</head>
<body class="center">
<%
    int teacher_id = -1;
    String user_name = (String) session.getAttribute("user_name");
    if (user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    try {
        teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
    } catch (Exception e) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    if (teacher_id == -1 || user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    TeachersEntity teachent = TeacherDao.getTeacher(teacher_id);
    List<ClassesEntity> allClasses = new ArrayList<>(teachent.getClasses());
%>
<h3><a href="admin.jsp"><i class="fa-solid fa-house"></i></a>Teacher Report For: <%=teachent.getName()%>
</h3>
<%@include file="classTable.jsp" %>
</body>
</html>
