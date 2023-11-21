//package com.example.Assignment.controller;
//
//import com.example.Assignment.model.Product;
//import com.example.Assignment.service.ProductService;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet(name = "LoadMoreController", value = "/load-more")
//public class LoadMoreController extends HttpServlet {
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html");
//        PrintWriter printWriter = response.getWriter();
//
//        String total = request.getParameter("exits");
//        int amount = Integer.parseInt(total);
//
//
//        ProductService productService = new ProductService();
//        List<Product> listProduct = productService.getNext3Product(amount);
//        for (Product p : listProduct) {
//            printWriter.println("  <div class=\"product col-12 col-md-4 mb-4\">\n" +
//                    "                <div class=\"card h-100 card_title\">\n" +
//                    "                    <a href=\"/detail?pid=" + p.getId() + "\" class=\"\">\n" +
//                    "                        <img src=\"" + p.getImage() + "\" class=\"card-img-top image_link\" alt=\"...\" >\n" +
//                    "                    </a>\n" +
//                    "                    <div class=\"card-body\">\n" +
//                    "                        <ul class=\"list-unstyled d-flex justify-content-between\">\n" +
//                    "                            <li>\n" +
//                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
//                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
//                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
//                    "                                <i class=\"text-muted fa fa-star\"></i>\n" +
//                    "                                <i class=\"text-muted fa fa-star\"></i>\n" +
//                    "                            </li>\n" +
//                    "                            <li class=\"text-muted text-right fw-bold text-danger\"> " + p.getPrice() + " $</li>\n" +
//                    "                        </ul>\n" +
//                    "                        <a href=\"/detail?pid=" + p.getId() + "\" class=\"product_name  fs-3  \">" + p.getName() + "</a>\n" +
//                    "                        <div class=\"row d-flex justify-content-between align-items-center\">\n" +
//                    "                            <div class=\"col-7\">\n" +
//                    "                                <p class=\"text-muted\">Reviews (24)</p>\n" +
//                    "                            </div>\n" +
//                    "                            <div class=\"col-5\">\n" +
//                    "                                <a href=\"#\">\n" +
//                    "                                    <button type=\"submit\" class=\"btn btn-success btn-lg\" name=\"submit\" value=\"addtocard\">Add To Cart</button>\n" +
//                    "                                </a>\n" +
//                    "                            </div>\n" +
//                    "                        </div>\n" +
//                    "\n" +
//                    "                    </div>\n" +
//                    "                </div>\n" +
//                    "            </div>");
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
