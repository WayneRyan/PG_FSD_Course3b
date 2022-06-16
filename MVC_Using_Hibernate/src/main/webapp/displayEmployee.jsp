<%@ page import="java.util.List" %>
<%@ page import="com.bean.Employee" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/11/2022
  Time: 11:57 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Diaplay Employee</title>
</head>
<body>
<select>
    <%
        session.setAttribute("hello", "world");
        Object obj = session.getAttribute("listOfEmp");
        if (obj != null) {
            List<Employee> listOfEmp = (List<Employee>) obj;
            Iterator<Employee> li = listOfEmp.listIterator();
            while (li.hasNext()) {
                Employee emp = li.next();
    %>
    <option><%=emp.getId() + " " + emp.getName() + " " + emp.getSalary() %></option>
    <%
            }
        }
    %>
</select>
<h2>Employee Details using jstl tag</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Salary</th>
    </tr>
    <core:forEach items="${sessionScope.listOfEmp}" var="emp">
        <tr>
            <td><core:out value="${emp.id}"></core:out></td>
            <td><core:out value="${emp.name}"></core:out></td>
            <td><core:out value="${emp.salary}"></core:out></td>
        </tr>
    </core:forEach>
</table>
</body>
</html>
