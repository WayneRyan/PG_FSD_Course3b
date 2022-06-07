package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("user_name").equals("admin") && request.getParameter("password").equals("admin")) {
            request.getSession().setAttribute("user_name", "admin");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getSession().invalidate();
            response.getWriter().println("Incorrect User name or password");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
