package com.controller;

import com.bean.Product;
import com.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {

    ProductService ps = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        HttpSession hs = request.getSession();
        List<Product> listOfProduct = ps.getAllProductDetails();
        hs.setAttribute("products", listOfProduct);
        response.sendRedirect("displayProduct.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String pname = request.getParameter("pname");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = new Product();
        product.setPid(pid);
        product.setPname(pname);
        product.setPrice(price);
        String result = ps.storeProduct(product);
        pw.println(result);
        RequestDispatcher rd1 = request.getRequestDispatcher("storeProduct.jsp");
        rd1.include(request,response);
    }
}
