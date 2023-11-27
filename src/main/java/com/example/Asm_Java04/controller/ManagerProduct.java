package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.MauSac;
import com.example.Asm_Java04.model.NSX;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.DongSanPhamService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "/ManagerProduct", value = {"/manager-product"
        , "/product/add", "/product/update", "/product/delete", "/product/detail"
})

public class ManagerProduct extends HttpServlet {

    SanPhamService sanPhamService = new SanPhamService();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/manager-product")) {
            ArrayList<SanPham> list =  sanPhamService.getAll();
            request.setAttribute("listP", list);
            request.getRequestDispatcher("/views/ManagerProduct.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    sanPhamService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-product");
        } else if (uri.contains("/detail")) {
            String productID = request.getParameter("id");
            if (productID != null && !productID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(productID);
                    SanPham sp = sanPhamService.findSanPhamByID(uuid);
                    request.setAttribute("spDetail", sp);
                    request.getRequestDispatcher("/views/DetailProduct.jsp").forward(request, response);

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            System.out.println(ma);
            System.out.println(ten);
            SanPham sanPham = new SanPham(ma,ten);
            sanPhamService.insert(sanPham);
            response.sendRedirect("/manager-product");
        }
    }
}
