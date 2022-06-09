package com.controller;

import com.dao.ClassDao;
import com.dao.SubjectDao;
import com.dao.TeacherDao;
import com.entity.ClassesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassServlet", value = "/ClassServlet")
public class ClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String user_name = (String) request.getSession().getAttribute("user_name");
            if (user_name == null || !user_name.equals("admin")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            ClassesEntity ce = ClassDao.getCourse(Integer.parseInt(request.getParameter("class_id")));
            if (ce.getStudents().isEmpty()) {
                if (ClassDao.delete_Class(ce)) {
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    response.getWriter().println("<font style=\"color:red;\">Error removing course.</font><br/>");
                    request.getRequestDispatcher("admin.jsp").include(request, response);
                }
            } else {
                response.getWriter().println("<font style=\"color:red;\">Students are assigned to this course. If you wish to delete the course you must first delete the students</font><br/>");
                request.getRequestDispatcher("classReport.jsp").include(request, response);
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
            ClassesEntity course = new ClassesEntity();
            course.setName(request.getParameter("class_name"));
            course.setSubject_id(Integer.parseInt(request.getParameter("subject_id")));
            course.setTeacher_id(Integer.parseInt(request.getParameter("teacher_id")));
            course.setTeacher(TeacherDao.getTeacher(course.getTeacher_id()));
            course.setSubject(SubjectDao.getSubject(course.getSubject_id()));
            if (ClassDao.persist_Class(course)) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                response.getWriter().println("<font style=\"color:red;\">Error adding class. A teacher can only be assigned to different classes for different subjects. Each class must have a unique name.</font><br/>");
                request.getRequestDispatcher("admin.jsp").include(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
