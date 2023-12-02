package com.example.Asm_Java04.controller;

//import com.example.Assignment.model.Product;
//import com.example.Assignment.service.ProductService;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.services.ChiTietSPService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoadMoreController", value = "/load-more")
public class LoadMoreController extends HttpServlet {

    ChiTietSPService chiTietSPService = new ChiTietSPService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String total = request.getParameter("exits");
        System.out.println(total);
        int amount = Integer.parseInt(total);
//        UUID idSP = UUID.fromString(total);


        ArrayList<ChiTietSanPham> listProduct = chiTietSPService.getChiTietSPLimited(amount);
        for (ChiTietSanPham p : listProduct) {
            printWriter.println("  <div class=\"product col-12 col-md-4 mb-4\">\n" +
                    "                <div class=\"card h-100 card_title\">\n" +
                    "                    <a href=\"/store/detail?pid=" + p.getSanPham().getId() + "\" class=\"\">\n" +
                    "                        <img src=\"" + p.getSanPham().getHinhAnh() + "\" class=\"card-img-top image_link\" alt=\"...\" >\n" +
                    "                    </a>\n" +
                    "                    <div class=\"card-body\">\n" +
                    "                        <ul class=\"list-unstyled d-flex justify-content-between\">\n" +
                    "                            <li>\n" +
                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
                    "                                <i class=\"text-warning fa fa-star\"></i>\n" +
                    "                                <i class=\"text-muted fa fa-star\"></i>\n" +
                    "                                <i class=\"text-muted fa fa-star\"></i>\n" +
                    "                            </li>\n" +
                    "                            <li class=\"text-muted text-right fw-bold text-danger\"> " + p.getGiaBan() + " $</li>\n" +
                    "                        </ul>\n" +
                    "                        <a href=\"/store/detail?pid=" + p.getSanPham().getId() + "\" class=\"product_name  fs-3  \">" + p.getSanPham().getTen() + "</a>\n" +
                    "                        <div class=\"row d-flex justify-content-between align-items-center\">\n" +
                    "                            <div class=\"col-7\">\n" +
                    "                                <p class=\"text-muted\">Reviews (24)</p>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"col-5\">\n" +
                    "                                <a href=\"/AddToCart?pid="+ p.getSanPham().getId() +"\">\n" +
                    "                                    <button type=\"submit\" class=\"btn btn-success btn-lg\" name=\"submit\" value=\"addtocard\">Add To Cart</button>\n" +
                    "                                </a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
