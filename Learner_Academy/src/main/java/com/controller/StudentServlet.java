package com.controller;

import com.dao.ClassDao;
import com.dao.StudentDao;
import com.entity.StudentsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user_name = (String) request.getSession().getAttribute("user_name");
        if (user_name == null || !user_name.equals("admin")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        StudentsEntity student = new StudentsEntity();
        student.setName(request.getParameter("student_name"));
        student.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        student.setCourse(ClassDao.getCourse(student.getCourse_id()));
        if (StudentDao.persist_Student(student)) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            response.getWriter().println("<font style=\"color:red;\">Error adding student.</font><br/>");
            request.getRequestDispatcher("admin.jsp").include(request, response);
        }
    }
}
