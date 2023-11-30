package com.example.Asm_Java04.controller;


import com.example.Asm_Java04.model.NhanVien;
import com.example.Asm_Java04.services.NhanVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login", value = {"/login"})
public class Login extends HttpServlet {

    NhanVienService nhanVienService = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");

            System.out.println(userName);
            System.out.println(password);
//            System.out.println(userName);

            NhanVien nhanVien = nhanVienService.getNhanVien(userName, password);

            if (nhanVien == null) {
                request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
            } else {
                if (nhanVien.getUserName().equals(userName) && nhanVien.getMatKhau().equals(password)) {
//                    if (remember != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", nhanVien);
                    response.sendRedirect("/home");
//                    }
                }

            }

        }
    }
}
