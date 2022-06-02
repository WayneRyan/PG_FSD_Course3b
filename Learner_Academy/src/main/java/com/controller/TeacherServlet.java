package com.controller;

import com.dao.SubjectDao;
import com.dao.TeacherDao;
import com.entity.Subjects_entity;
import com.entity.Teachers_entity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeacherServlet", value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user_name = (String) request.getSession().getAttribute("user_name");
        if ( user_name == null || !user_name.equals("admin")) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        Teachers_entity teacher = new Teachers_entity();
        teacher.setName(request.getParameter("teacher_name"));
        TeacherDao.persist_Teacher(teacher);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
