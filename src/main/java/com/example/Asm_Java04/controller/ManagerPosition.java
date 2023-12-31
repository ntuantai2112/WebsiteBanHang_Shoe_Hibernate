package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.services.ChucVuService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerPosition", value = {"/manager-position"
        , "/position/add", "/position/update", "/position/delete", "/position/detail"
})
public class ManagerPosition extends HttpServlet {
    ChucVuService chucVuService = new ChucVuService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/manager-position")) {
            HttpSession session = request.getSession();
            ArrayList<ChucVu> listCV = (ArrayList<ChucVu>) chucVuService.getAll();
            request.setAttribute("listCV", listCV);

            request.getRequestDispatcher("/views/ManagerPosition.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String chucVuID = request.getParameter("id");
            if (chucVuID != null && !chucVuID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(chucVuID);
                    chucVuService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-position");
        } else if (uri.contains("/detail")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    ChucVu chucVuDetail = chucVuService.findChucVutByID(uuid);
                    request.setAttribute("chucVuDetail", chucVuDetail);
                    request.getRequestDispatcher("/views/DetailPosition.jsp").forward(request, response);

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
            ChucVu chucVu = new ChucVu(ma, ten);
            chucVuService.insert(chucVu);
            response.sendRedirect("/manager-position");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            UUID chucVuID = UUID.fromString(id);
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu(chucVuID, ma, ten);
            chucVuService.update(chucVu);
            response.sendRedirect("/manager-position");
        }

    }
}
