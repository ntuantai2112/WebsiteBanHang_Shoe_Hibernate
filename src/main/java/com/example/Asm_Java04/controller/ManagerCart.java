package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.NSX;
import com.example.Asm_Java04.services.NSXService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerCart", value = {"/manager-cart"
        , "/cart/add", "/cart/update", "/cart/delete", "/cart/detail"
})
public class ManagerCart extends HttpServlet {
    NSXService nsxService = new NSXService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/manager-cart")) {
//            HttpSession session = request.getSession();
            ArrayList<NSX> listNSX = (ArrayList<NSX>) nsxService.getAll();
            request.setAttribute("listNSX", listNSX);

            request.getRequestDispatcher("/views/ManagerProducer.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String dongSPID = request.getParameter("id");
            if (dongSPID != null && !dongSPID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(dongSPID);
                    nsxService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-producer");
        } else if (uri.contains("/detail")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    NSX nsx = nsxService.findNSXtByID(uuid);
                    request.setAttribute("nsxDetail", nsx);
                    request.getRequestDispatcher("/views/DetailProducer.jsp").forward(request, response);

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
            NSX nsx = new NSX(ma, ten);
            nsxService.insert(nsx);
            response.sendRedirect("/manager-producer");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            UUID nsxID = UUID.fromString(id);
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            System.out.println(id);
            System.out.println(ma);
            System.out.println(ten);
            NSX nsx = new NSX(nsxID, ma, ten);
            nsxService.update(nsx);
            response.sendRedirect("/manager-producer");
        }

    }
}
