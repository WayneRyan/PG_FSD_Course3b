<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% session.invalidate();%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="CSS/main.css">
</head>
<body class="center">
<h2>Please Log In</h2>
<form action="LoginServlet" method="post">
    <label>User Name</label><input type="text" name="user_name"/>
    <label>Password</label><input type="password" name="password"/>
    <input type="submit" name="submit" value="submit"/>
    <input type="reset" name="reset" value="reset"/>
</form>
</body>
</html>