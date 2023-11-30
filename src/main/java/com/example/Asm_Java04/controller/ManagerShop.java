package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.CuaHangService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerShop", value = {"/manager-shop"
        , "/shop/add", "/shop/update", "/shop/delete", "/shop/detail"
})

public class ManagerShop extends HttpServlet {

    CuaHangService cuaHangService = new CuaHangService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/manager-shop")) {
            ArrayList<CuaHang> list = (ArrayList<CuaHang>) cuaHangService.getAll();
            request.setAttribute("listCH", list);
            request.getRequestDispatcher("/views/ManagerShop.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    cuaHangService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-shop");
        } else if (uri.contains("/detail")) {
            String shopID = request.getParameter("id");
            if (shopID != null && !shopID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(shopID);
                    CuaHang cuaHang = cuaHangService.findCuaHangByID(uuid);
                    request.setAttribute("cuaHangDetail", cuaHang);
                    request.getRequestDispatcher("/views/DetailShop.jsp").forward(request, response);

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang cuaHang = new CuaHang(ma, ten, diaChi, thanhPho, quocGia);
            cuaHangService.insert(cuaHang);
            response.sendRedirect("/manager-shop");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            UUID shopID = UUID.fromString(id);
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang cuaHang = new CuaHang(shopID, ma, ten, diaChi, thanhPho, quocGia);
            cuaHangService.update(cuaHang);
            response.sendRedirect("/manager-shop");
        }
    }
}
