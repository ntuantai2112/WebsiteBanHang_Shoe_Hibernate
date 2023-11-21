//package com.example.Assignment.controller;
//
//import com.example.Assignment.model.Account;
//import com.example.Assignment.model.Category;
//import com.example.Assignment.model.Product;
//import com.example.Assignment.service.CategoryService;
//import com.example.Assignment.service.ProductService;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "ManagerProduct", value = {"/manager-product"
//        , "/product/add", "/product/update", "/product/delete"
//})
//public class ManagerProduct extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        ProductService productService = new ProductService();
//        CategoryService categoryService = new CategoryService();
//
//        if (uri.contains("/manager-product")) {
//            HttpSession session = request.getSession();
//            Account account = (Account) session.getAttribute("acc");
//            if (account == null) {
//                response.sendRedirect("/login");
//            }
//
//            int id = account.getId();
//            if (account.getId() == null) {
//                response.sendRedirect("/login");
//            }
//            List<Product> list = productService.getProductBySellID(id);
//
//            request.setAttribute("listP", list);
//
//
//            request.getRequestDispatcher("/views/ManagerProduct.jsp").forward(request, response);
//        } else if (uri.contains("/delete")) {
//            String productID = request.getParameter("id");
//            Integer id = Integer.parseInt(productID);
//            productService.delete(id);
//            response.sendRedirect("/manager-product");
//        } else if (uri.contains("/add")) {
//            List<Category> listC = categoryService.getAllCategory();
//            request.setAttribute("listC", listC);
//            request.getRequestDispatcher("/views/AddProduct.jsp").forward(request, response);
//
//        }
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
