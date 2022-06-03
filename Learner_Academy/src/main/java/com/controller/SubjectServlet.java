package com.controller;

import com.dao.SubjectDao;
import com.entity.SubjectsEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SubjectServlet", value = "/SubjectServlet")
public class SubjectServlet extends HttpServlet {
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
        SubjectsEntity subject = new SubjectsEntity();
        subject.setName(request.getParameter("subject_name"));
        SubjectDao.persistSubject(subject);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
