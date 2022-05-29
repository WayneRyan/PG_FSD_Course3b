<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 5/29/2022
  Time: 10:34 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store Product</title>
</head>
<body>
  <h2>Store Product</h2>
  <form action="ProductController" method="post">
    <label>Pid</label><input type="number" name="pid" /><br />
    <label>Product Name</label><input type="text" name="pname" /><br />
    <label>Price</label><input type="number" name="price" /><br />
    <input type="submit" value="Store Product">
    <input type="reset" value="reset">
  </form>
</body>
</html>
