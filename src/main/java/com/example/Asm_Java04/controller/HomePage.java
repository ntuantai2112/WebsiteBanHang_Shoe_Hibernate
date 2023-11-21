package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePage", value = {"/home"})
public class HomePage extends HttpServlet {


    private SanPhamService sanPhamService = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();

        if (uri.contains("/home")) {
//            List<SanPham> listProduct = sanPhamService.getTop3Product();
//            request.setAttribute("listProduct", listProduct);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
//            String productID = request.getParameter("pid");
//            Product productDetail = productService.getProductByID(productID);
//            request.setAttribute("detail", productDetail);
//            request.getRequestDispatcher("/views/ShowDetailProduct.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
