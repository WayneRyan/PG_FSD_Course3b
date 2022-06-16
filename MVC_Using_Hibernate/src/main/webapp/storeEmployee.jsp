<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/11/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store Employee</title>
</head>
<body>
<form action="EmployeeController" method="post">
  <label>ID</label>
  <input type="number" name="id"><br>
  <label>Name</label>
  <input type="text" name="name"><br>
  <label>Salary</label>
  <input type="number" name="salary"><br>
  <input type="submit" value="store employee">
  <input type="reset" value="reset">
</form><br>
<a href="EmployeeController">Display Employee</a>
</body>
</html>
