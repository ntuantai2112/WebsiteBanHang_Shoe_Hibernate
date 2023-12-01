package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.DongSP;
import com.example.Asm_Java04.services.DongSanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerCategory", value = {"/manager-category"
        , "/category/add", "/category/update", "/category/delete", "/category/detail", "/category/show"
})
public class ManagerCategory extends HttpServlet {
    DongSanPhamService dongSanPhamService = new DongSanPhamService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/manager-category")) {
//            HttpSession session = request.getSession();
            ArrayList<DongSP> listDM = (ArrayList<DongSP>) dongSanPhamService.getAll();
            request.setAttribute("listDM", listDM);

            request.getRequestDispatcher("/views/ManagerCategory.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String dongSPID = request.getParameter("id");
            if (dongSPID != null && !dongSPID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(dongSPID);
                    dongSanPhamService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-category");
        } else if (uri.contains("/detail")) {
            String categoryID = request.getParameter("id");
            if (categoryID != null && !categoryID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(categoryID);
                    DongSP category = dongSanPhamService.findCategorytByID(uuid);
                    request.setAttribute("dongSPDetail", category);
                    request.getRequestDispatcher("/views/DetailCategory.jsp").forward(request, response);

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
            DongSP dongSP = new DongSP(ma, ten);
            dongSanPhamService.insert(dongSP);
            response.sendRedirect("/manager-category");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String id = request.getParameter("id");
            UUID categoryID = UUID.fromString(id);
            System.out.println(ma);
            System.out.println(ten);
            DongSP dongSP = new DongSP(categoryID, ma, ten);
            dongSanPhamService.update(dongSP);
            response.sendRedirect("/manager-category");
        }

    }
}
