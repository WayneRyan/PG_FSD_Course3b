package com.controller;

import com.dao.TeacherDao;
import com.entity.TeachersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeacherServlet", value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String user_name = (String) request.getSession().getAttribute("user_name");
            if (user_name == null || !user_name.equals("admin")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if (TeacherDao.delete_Teacher(TeacherDao.getTeacher(Integer.parseInt(request.getParameter("teacher_id"))))) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                response.getWriter().println("<font style=\"color:red;\">Error removing teacher.</font><br/>");
                request.getRequestDispatcher("admin.jsp").include(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String user_name = (String) request.getSession().getAttribute("user_name");
            if (user_name == null || !user_name.equals("admin")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            TeachersEntity teacher = new TeachersEntity();
            teacher.setName(request.getParameter("teacher_name"));
            TeacherDao.persist_Teacher(teacher);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
