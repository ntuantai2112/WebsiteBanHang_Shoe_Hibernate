//package com.example.Assignment.controller;
//
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
//@WebServlet(name = "SearchController", value = "/search")
//public class SearchController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//
//        String keyword = request.getParameter("keyword");
//        ProductService productService = new ProductService();
//        CategoryService categoryService = new CategoryService();
//
//        List<Product> listProduct = productService.searchProductByName(keyword);
//        List<Category> listCategory = categoryService.getAllCategory();
//        request.setAttribute("products", listProduct);
//        request.setAttribute("categorys", listCategory);
//        request.setAttribute("valueSearch", keyword);
//        request.getRequestDispatcher("/views/shop.jsp").forward(request, response);
//
//
//    }
//}
