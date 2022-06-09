package com.controller;

import com.dao.SubjectDao;
import com.entity.SubjectsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SubjectServlet", value = "/SubjectServlet")
public class SubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String user_name = (String) request.getSession().getAttribute("user_name");
            if (user_name == null || !user_name.equals("admin")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            SubjectsEntity se = SubjectDao.getSubject(Integer.parseInt(request.getParameter("subject_id")));
            System.out.println(se);
            if (se.getClasses().isEmpty()) {
                if (SubjectDao.deleteSubject(se)) {
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    response.getWriter().println("<font style=\"color:red;\">Error removing subject.</font><br/>");
                    request.getRequestDispatcher("admin.jsp").include(request, response);
                }
            } else {
                response.getWriter().println("<font style=\"color:red;\">Courses are assigned to this subject. If you wish to delete the subject you must first delete the courses.</font><br/>");
                request.getRequestDispatcher("subjectReport.jsp").include(request, response);
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
            SubjectsEntity subject = new SubjectsEntity();
            subject.setName(request.getParameter("subject_name"));
            SubjectDao.persistSubject(subject);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
