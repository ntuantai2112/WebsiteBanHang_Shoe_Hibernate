package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.DongSP;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.DongSanPhamService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManagerStore", value = {"/ManagerStore","/store"})
public class ManagerStore extends HttpServlet {

    SanPhamService sanPhamService = new SanPhamService();
    DongSanPhamService dongSanPhamService = new DongSanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SanPham> listP = sanPhamService.getAll();
        request.setAttribute("products", listP);
        ArrayList<DongSP> listC = (ArrayList<DongSP>) dongSanPhamService.getAll();
        request.setAttribute("products", listP);
        request.setAttribute("categorys", listC);
        request.getRequestDispatcher("/views/shop.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
