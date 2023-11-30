package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.ChiTietSPService;
import com.example.Asm_Java04.services.DongSanPhamService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ManagerStore", value = {"/ManagerStore", "/store/hien-thi", "/store/detail", "/store/store-category"})
public class ManagerStore extends HttpServlet {

    SanPhamService sanPhamService = new SanPhamService();
    DongSanPhamService dongSanPhamService = new DongSanPhamService();
    ChiTietSPService chiTietSPService = new ChiTietSPService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/store/hien-thi")) {

            String indexStr = request.getParameter("index");
            if (indexStr == null) {
                indexStr = "1";
            }
            Integer index = Integer.parseInt(indexStr);
            if (index == null) {
                index = 1;
            }
            ArrayList<SanPham> listP = sanPhamService.getPaging(index);
//            request.setAttribute("products", listP);
            ArrayList<DongSP> listC = (ArrayList<DongSP>) dongSanPhamService.getAll();
            request.setAttribute("products", listP);
            request.setAttribute("categorys", listC);
            int countPage = chiTietSPService.getCountPageOfChiTietSP();
            request.setAttribute("countPage", countPage);
            request.setAttribute("index", index);
            request.getRequestDispatcher("/views/shop.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            String productIDStr = request.getParameter("pid");
            UUID productDetailID = UUID.fromString(productIDStr);
            ChiTietSanPham chiTietSanPham = chiTietSPService.findChiTietSanPhamByID(productDetailID);
            request.setAttribute("detailProduct", chiTietSanPham);
            request.getRequestDispatcher("/views/ShowDetailProduct.jsp").forward(request, response);
        } else if (uri.contains("/store-category")) {
            String categoryIDStr = request.getParameter("cid");
            System.out.println(categoryIDStr);
            UUID categoryID = UUID.fromString(categoryIDStr);
            System.out.println(categoryID);
            ArrayList<ChiTietSanPham> listChiTietSP = chiTietSPService.getChiTietSanPhamByCategoryID(categoryID);
            ArrayList<DongSP> listC = (ArrayList<DongSP>) dongSanPhamService.getAll();
            request.setAttribute("categorys", listC);
            request.setAttribute("products", listChiTietSP);
            request.setAttribute("tag", categoryID);
            request.getRequestDispatcher("/views/shop.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
