package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.*;
import com.example.Asm_Java04.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "/ManagerDetailProduct", value = {"/manager-detail-product"
        , "/detail-product/add", "/detail-product/update", "/detail-product/delete", "/detail-product/detail"
})

public class ManagerDetailProduct extends HttpServlet {

    ChiTietSPService chiTietSPService = new ChiTietSPService();
    SanPhamService sanPhamService = new SanPhamService();
    NSXService nsxService = new NSXService();
    MauSacService mauSacService = new MauSacService();
    DongSanPhamService dongSanPhamService = new DongSanPhamService();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/manager-detail-product")) {
            ArrayList<ChiTietSanPham> listDetailProduct = (ArrayList<ChiTietSanPham>) chiTietSPService.getAll();
            ArrayList<SanPham> listSP = (ArrayList<SanPham>) sanPhamService.getAll();
            ArrayList<NSX> listNSX = (ArrayList<NSX>) nsxService.getAll();
            ArrayList<MauSac> listMS = (ArrayList<MauSac>) mauSacService.getAll();
            ArrayList<DongSP> listDongSP = (ArrayList<DongSP>) dongSanPhamService.getAll();
            request.setAttribute("listDetailProduct", listDetailProduct);
            request.setAttribute("listSP", listSP);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listMS", listMS);
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/views/ManagerDetailProduct.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    chiTietSPService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-detail-product");
        } else if (uri.contains("/detail")) {
            ArrayList<SanPham> listSP = (ArrayList<SanPham>) sanPhamService.getAll();
            ArrayList<NSX> listNSX = (ArrayList<NSX>) nsxService.getAll();
            ArrayList<MauSac> listMS = (ArrayList<MauSac>) mauSacService.getAll();
            ArrayList<DongSP> listDongSP = (ArrayList<DongSP>) dongSanPhamService.getAll();
            request.setAttribute("listSP", listSP);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listMS", listMS);
            request.setAttribute("listDongSP", listDongSP);

            String productID = request.getParameter("id");
            if (productID != null && !productID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(productID);
                    ChiTietSanPham detailSP = chiTietSPService.findChiTietSanPhamByID(uuid);
                    request.setAttribute("spDetail", detailSP);
                    request.getRequestDispatcher("/views/Detail_DetailProduct.jsp").forward(request, response);

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
            String sanPhamStr = request.getParameter("sanPham");
            UUID idSP = UUID.fromString(sanPhamStr);
            String nhaSanXuat = request.getParameter("nhaSanXuat");
            UUID idNSX = UUID.fromString(nhaSanXuat);
            String mauSacStr = request.getParameter("mauSac");
            UUID idMS = UUID.fromString(mauSacStr);
            String dongSanPham = request.getParameter("dongSanPham");
            UUID idDongSP = UUID.fromString(dongSanPham);

            SanPham sanPham = new SanPham();
            sanPham.setId(idSP);

            NSX nsx = new NSX();
            nsx.setId(idNSX);


            MauSac mauSac = new MauSac();
            mauSac.setId(idMS);

            DongSP dongSP = new DongSP();
            dongSP.setId(idDongSP);

            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTon");
            String giaNhapStr = request.getParameter("giaNhap");
            String giaBanStr = request.getParameter("giaBan");

//            BigDecimal giaBan = BigDecimal.valueOf();
//            BigDecimal giaNhap = BigDecimal.valueOf();

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham(sanPham,nsx,mauSac,dongSP,Integer.parseInt(namBH),moTa, Integer.parseInt(soLuongTon),Double.parseDouble(giaNhapStr),Double.parseDouble(giaBanStr));
            chiTietSPService.insert(chiTietSanPham);
            response.sendRedirect("/manager-detail-product");
        }

        else  if(uri.contains("/update")){

            String idChiTietSPSrt = request.getParameter("id");
            UUID idChiTietSP = UUID.fromString(idChiTietSPSrt);

            String sanPhamStr = request.getParameter("sanPham");
            UUID idSP = UUID.fromString(sanPhamStr);
            String nhaSanXuat = request.getParameter("nhaSanXuat");
            UUID idNSX = UUID.fromString(nhaSanXuat);
            String mauSacStr = request.getParameter("mauSac");
            UUID idMS = UUID.fromString(mauSacStr);
            String dongSanPham = request.getParameter("dongSanPham");
            UUID idDongSP = UUID.fromString(dongSanPham);

            SanPham sanPham = new SanPham();
            sanPham.setId(idSP);

            NSX nsx = new NSX();
            nsx.setId(idNSX);


            MauSac mauSac = new MauSac();
            mauSac.setId(idMS);

            DongSP dongSP = new DongSP();
            dongSP.setId(idDongSP);

            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTon");
            String giaNhapStr = request.getParameter("giaNhap");
            String giaBanStr = request.getParameter("giaBan");

//            BigDecimal giaBan = BigDecimal.valueOf();
//            BigDecimal giaNhap = BigDecimal.valueOf();

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idChiTietSP,sanPham,nsx,mauSac,dongSP,Integer.parseInt(namBH),moTa, Integer.parseInt(soLuongTon),Double.parseDouble(giaNhapStr),Double.parseDouble(giaBanStr));
            chiTietSPService.update(chiTietSanPham);
            response.sendRedirect("/manager-detail-product");
        }
    }
}
