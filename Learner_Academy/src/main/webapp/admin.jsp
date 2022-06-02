<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/2/2022
  Time: 5:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<%
    String user_name = (String) session.getAttribute("user_name");
    if ( user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>
<h2>Admin Page</h2>
<h3>Add new student</h3>
<form action="StudentServlet" method="post">
    <label>Student Name</label>
    <input type="text" name="student_name" /><br/>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
<br/><br/>
<h3>Add new subject</h3>
<form action="SubjectServlet" method="post">
    <label>Subject Name</label>
    <input type="text" name="subject_name" /><br/>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
<br/><br/>
<h3>Add new teacher</h3>
<form action="TeacherServlet" method="post">
    <label>Teacher Name</label>
    <input type="text" name="teacher_name" /><br/>
    <input type="submit" name="submit" value="submit">
    <input type="reset" name="reset" value="reset">
</form>
</body>
</html>
