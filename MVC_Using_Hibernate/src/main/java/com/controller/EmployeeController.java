package com.controller;

import com.bean.Employee;
import com.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        HttpSession hs = request.getSession();
        EmployeeService es = new EmployeeService();
        List<Employee> listOfEmp = es.getAllEmployeeDetails();
        hs.setAttribute("listOfEmp" , listOfEmp);
        response.sendRedirect("displayEmployee.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        Employee emp = new Employee();
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setSalary(Float.parseFloat(request.getParameter("salary")));

        EmployeeService es = new EmployeeService();
        String result = es.storeEmployee(emp);
        pw.println(result);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request, response);

    }
}
