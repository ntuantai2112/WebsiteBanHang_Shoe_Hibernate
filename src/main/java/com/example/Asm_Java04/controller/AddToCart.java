package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.HoaDonChiTiet;
import com.example.Asm_Java04.model.KhachHang;
import com.example.Asm_Java04.services.ChiTietSPService;
import com.example.Asm_Java04.services.HoaDonChiTietService;
import com.example.Asm_Java04.services.HoaDonService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AddToCart", value = {"/AddToCart"})
public class AddToCart extends HttpServlet {

        ChiTietSPService chiTietSPService = new ChiTietSPService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String pId = request.getParameter("pid");
            UUID idProduct = UUID.fromString(pId);
            ChiTietSanPham product = chiTietSPService.getChiTietSanPhamByIDSP(idProduct);

            Double totalMoney = 0.0;
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("cart");// luu tam vao session
            if (obj == null) {// tao moi
                // Tao mat hang
                HoaDonChiTiet billProduct = new HoaDonChiTiet();
                billProduct.setChiTietSanPham(product);
                billProduct.setSoLuong(1);
                billProduct.setDonGia(BigDecimal.valueOf(product.getGiaBan()));
                // gio hang co nhieu mat hang
                Map<String, HoaDonChiTiet> map = new HashMap<>();
                map.put(pId, billProduct);// them mat hang vao ds

                session.setAttribute("cart", map);// luu tam vao session
                int oneDayInSeconds = 86400; // 24 giờ * 60 phút * 60 giây = 86,400 giây
                session.setMaxInactiveInterval(oneDayInSeconds);
            } else {
                Map<String, HoaDonChiTiet> map = (Map<String, HoaDonChiTiet>) obj;

                HoaDonChiTiet billProduct = map.get(pId);

                if (billProduct == null) {
                    billProduct = new HoaDonChiTiet();
                    billProduct.setChiTietSanPham(product);
                    billProduct.setSoLuong(1);
                    billProduct.setDonGia(BigDecimal.valueOf(product.getGiaBan()));

                    map.put(pId, billProduct);
                } else {

                    billProduct.setDonGia(BigDecimal.valueOf(product.getGiaBan() + 1));
                }

                session.setAttribute("cart", map);// luu tam vao session
                int oneDayInSeconds = 86400; // 24 giờ * 60 phút * 60 giây = 86,400 giây
                session.setMaxInactiveInterval(oneDayInSeconds);

            }
            response.sendRedirect(request.getContextPath() + "/cart");

        }

//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
