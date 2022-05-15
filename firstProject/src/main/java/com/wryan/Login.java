package com.wryan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession hs = request.getSession();
        PrintWriter pw = response.getWriter();
        if (hs.isNew()) {
            pw.println("New Client");
        } else {
            pw.println("Old Client");
        }
        pw.println("<br>Session id is "+hs.getId());
        pw.println("<br>Session Creation time "+ new Date(hs.getCreationTime()));
        pw.println("<br>Session Last Action time "+ new Date(hs.getLastAccessedTime()));
        pw.println("<br>Session default time "+ new Date(hs.getMaxInactiveInterval()));
        pw.println("<br>Count "+ count);
        hs.setAttribute("userName", "bla");
        hs.getAttribute("userName");
        if(count++%5==0) {hs.invalidate();};
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd1 = request.getRequestDispatcher("Home");
        RequestDispatcher rd2 = request.getRequestDispatcher("LoginHTML.html");
        if (email.equals("wryan@gmail.com") && password.equals("123")) {
            rd1.include(request, response);
        } else {
            pw.println(" <br>failure try once again.");
            rd2.include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
