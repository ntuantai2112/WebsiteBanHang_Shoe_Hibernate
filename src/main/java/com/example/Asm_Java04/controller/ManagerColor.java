package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.MauSac;
import com.example.Asm_Java04.services.ChucVuService;
import com.example.Asm_Java04.services.MauSacService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerColor", value = {"/manager-color"
        , "/color/add", "/color/update", "/color/delete", "/color/detail"
})
public class ManagerColor extends HttpServlet {
    MauSacService mauSacService = new MauSacService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/manager-color")) {
//            HttpSession session = request.getSession();
            ArrayList<MauSac> listMS = (ArrayList<MauSac>) mauSacService.getAll();
            request.setAttribute("listMS", listMS);

            request.getRequestDispatcher("/views/ManagerColor.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    mauSacService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-color");
        } else if (uri.contains("/detail")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    MauSac mauSacDetail = mauSacService.findMauSactByID(uuid);
                    request.setAttribute("MSDetial", mauSacDetail);
                    request.getRequestDispatcher("/views/DetailColor.jsp").forward(request, response);

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
            System.out.println(ma);
            System.out.println(ten);
            MauSac mauSac = new MauSac(ma, ten);
            mauSacService.insertMauSac(mauSac);
            response.sendRedirect("/manager-color");
        }

    }

}
