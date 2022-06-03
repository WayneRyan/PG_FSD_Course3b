package com.controller;

import com.dao.StudentDao;
import com.entity.StudentsEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user_name = (String) request.getSession().getAttribute("user_name");
        if ( user_name == null || !user_name.equals("admin")) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        StudentsEntity student = new StudentsEntity();
        student.setName(request.getParameter("student_name"));
        StudentDao.persist_Student(student);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
