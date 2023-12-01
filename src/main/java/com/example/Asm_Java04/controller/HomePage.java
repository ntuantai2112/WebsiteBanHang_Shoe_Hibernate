package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.services.ChiTietSPService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "HomePage", value = {"/home", "/search"})
public class HomePage extends HttpServlet {


    private SanPhamService sanPhamService = new SanPhamService();
    private ChiTietSPService chiTietSPService = new ChiTietSPService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();

        if (uri.contains("/home")) {
//            List<SanPham> listProduct = sanPhamService.getAll();
//            String total = request.getParameter("exits");
//            int amount = Integer.parseInt(total);
//            String idSPStr = request.getParameter("pid");
//            System.out.println(idSPStr);
//            UUID idSP = UUID.fromString(idSPStr);
//            System.out.println(idSP);

            List<ChiTietSanPham> listDetailProduct = chiTietSPService.getThreeItems();
            request.setAttribute("listDetailProduct", listDetailProduct);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/search")) {
            String keyword = request.getParameter("keyword");
            ArrayList<ChiTietSanPham> lispCTSP = chiTietSPService.searchChiTietSanPhamByName(keyword);
            request.setAttribute("listDetailProduct", lispCTSP);
            request.setAttribute("keyword", keyword);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            request.getRequestDispatcher("/views/shop.jsp").include(request, response);

        }
    }
}
