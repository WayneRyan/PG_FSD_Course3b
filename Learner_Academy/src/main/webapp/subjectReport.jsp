<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 6/7/2022
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
%>
<h3>Subject Report</h3><br>
<%= subject_id %>
</body>
</html>
