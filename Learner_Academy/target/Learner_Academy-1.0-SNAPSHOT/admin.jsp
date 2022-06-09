<%@ page import="java.util.List" %>
<%@ page import="com.dao.ClassDao" %>
<%@ page import="com.dao.StudentDao" %>
<%@ page import="com.entity.*" %>
<%@ page import="com.dao.TeacherDao" %>
<%@ page import="com.dao.SubjectDao" %><%--
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
    <link rel="stylesheet" href="CSS/main.css">
    <script src="https://kit.fontawesome.com/4164eda486.js" crossorigin="anonymous"></script>
</head>
<body class="center">
<%
    String user_name = (String) session.getAttribute("user_name");
    if (user_name == null || !user_name.equals("admin")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    List<SubjectsEntity> allSubjects = SubjectDao.getAllSubjects();
    List<ClassesEntity> allClasses = ClassDao.getAllClasses();
    List<StudentsEntity> allStudents = StudentDao.getAllStudents();
    List<com.entity.TeachersEntity> allTeachers = TeacherDao.getAllTeachers();
%>
<h2 class="center">Admin Page</h2>
<div>
    <h3>Add new subject</h3>
    <form action="SubjectServlet" method="post">
        <label>Subject Name:</label>
        <input type="text" name="subject_name"/><br/>
        <input type="submit" name="submit" value="submit">
        <input type="reset" name="reset" value="reset">
    </form>
    <h3>All Subjects</h3>
    <%@include file="subjectList.jsp" %>
</div>
<div>
    <h3>Add new teacher</h3>
    <form action="TeacherServlet" method="post">
        <label>Teacher Name:</label>
        <input type="text" name="teacher_name"/><br/>
        <input type="submit" name="submit" value="submit">
        <input type="reset" name="reset" value="reset">
    </form>
    <h3>All Teachers</h3>
    <%@include file="teacherList.jsp" %>
</div>
<div>
    <h3>Add new Class</h3>
    <form action="ClassServlet" method="post">
        <label>Class Name:</label>
        <input type="text" name="class_name"/><br/>
        <label>Subject:</label>
        <select name="subject_id">
            <% for (SubjectsEntity se : allSubjects) { %>
            <option value="<%= se.getId() %>"><%= se.getName() %>
            </option>
            <% } %>
        </select><br/>
        <label>Teacher:</label>
        <select name="teacher_id">
            <% for (TeachersEntity te : allTeachers) {%>
            <option value="<%= te.getId() %>"><%= te.getName() %>
            </option>
            <% } %>
        </select><br/>
        <input type="submit" name="submit" value="submit">
        <input type="reset" name="reset" value="reset">
    </form>
    <h3>All Classes</h3>
    <%@include file="classTable.jsp" %>
</div>
<div>
    <h3>Add new student</h3>
    <form action="StudentServlet" method="post">
        <label>Student Name:</label>
        <input type="text" name="student_name"/><br/>
        <label>Course:</label>
        <select name="course_id">
            <% for (ClassesEntity ce : allClasses) { %>
            <option value="<%= ce.getId() %>"><%= ce.getName() %>
            </option>
            <% } %>
        </select><br/>
        <input type="submit" name="submit" value="submit">
        <input type="reset" name="reset" value="reset">
    </form>
    <h3>All Students</h3>
    <%@include file="studentTable.jsp" %>
</div>
</body>
</html>
