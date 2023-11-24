package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.DongSP;
import com.example.Asm_Java04.model.NSX;
import com.example.Asm_Java04.services.DongSanPhamService;
import com.example.Asm_Java04.services.NSXService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerProducer", value = {"/manager-producer"
        , "/producer/add", "/producer/update", "/producer/delete"
})
public class ManagerProducer extends HttpServlet {
    NSXService nsxService = new NSXService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/manager-producer")) {
//            HttpSession session = request.getSession();
            ArrayList<NSX> listNSX = (ArrayList<NSX>) nsxService.getAll();
            request.setAttribute("listNSX",listNSX);

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
        } else if (uri.contains("/add")) {
//            List<Category> listC = categoryService.getAllCategory();
//            request.setAttribute("listC", listC);
//            request.getRequestDispatcher("/views/AddProduct.jsp").forward(request, response);

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
            NSX nsx = new NSX(ma,ten);
            nsxService.insert(nsx);
            response.sendRedirect("/manager-producer");
        }

    }
}
