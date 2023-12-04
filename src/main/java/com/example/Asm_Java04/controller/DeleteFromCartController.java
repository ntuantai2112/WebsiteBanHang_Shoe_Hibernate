package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.HoaDonChiTiet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DeleteFromCartController", value = {"/DeleteFromCartController","/remove-cart"})
public class DeleteFromCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");

        // gio hang co nhieu mat hang
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("cart");// luu tam vao session

        if (obj != null) {
            Map<String, HoaDonChiTiet> map = (Map<String, HoaDonChiTiet>) obj;
            map.remove(key);
            // update lai vao session
            session.setAttribute("cart", map);
        }
        // chuyen ve trang gio hang
        double totalMoney = calculateTotalMoney(session);
        request.setAttribute("totalMoney", totalMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/GioHang.jsp");
        dispatcher.forward(request, response);
    }

    private double calculateTotalMoney(HttpSession session) {
        double totalMoney = 0.0;

        Map<String, HoaDonChiTiet> map = (Map<String, HoaDonChiTiet>) session.getAttribute("cart");
        if (map != null) {
            for (HoaDonChiTiet billProduct : map.values()) {
                double productPrice = billProduct.getDonGia().doubleValue();
                int quantity = billProduct.getSoLuong();
                totalMoney += productPrice * quantity;
            }
        }

        return totalMoney;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
