<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.ClassesEntity" %>
<%@ page import="com.dao.ClassDao" %>
<%@ page import="com.entity.StudentsEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/7/2022
  Time: 6:46 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class Report</title>
    <link rel="stylesheet" href="CSS/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
</head>
<body class="center">
<%
    int class_id = -1;
    String user_name = (String) session.getAttribute("user_name");
    if (user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    try {
        class_id = Integer.parseInt(request.getParameter("class_id"));
    } catch (Exception e) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    if (class_id == -1 || user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    ClassesEntity courseEnt = ClassDao.getCourse(class_id);
    List<StudentsEntity> allStudents = new ArrayList<>(courseEnt.getStudents());
%>
<h3><a href="admin.jsp"><i class="fa-solid fa-house"></i></a>Class Report for: <%=courseEnt.getName()%>
</h3>
<%@include file="studentTable.jsp" %>
</body>
</html>
