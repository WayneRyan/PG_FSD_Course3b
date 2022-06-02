<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>Please Log In</h2>
<form action="LoginServlet" method="post">
    <label>User Name</label><input type="text" name="user_name" /><br/>
    <label>Password</label><input type="password" name="password" /><br/>
    <input type="submit" name="submit" value="submit"/><br/>
    <input type="reset" name="reset" value="reset"/>
</form>
</body>
</html>