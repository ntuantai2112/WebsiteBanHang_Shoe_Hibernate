package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.ChiTietSPService;
import com.example.Asm_Java04.services.HoaDonService;
import com.example.Asm_Java04.services.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@MultipartConfig()
@WebServlet(name = "/ManagerBill", value = {"/manager-bill"
        , "/bill/add", "/bill/update", "/bill/delete", "/bill/detail"
})

public class ManagerBill extends HttpServlet {

    SanPhamService sanPhamService = new SanPhamService();
    ChiTietSPService chiTietSPService = new ChiTietSPService();
    HoaDonService hoaDonService = new HoaDonService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/manager-product")) {
            ArrayList<HoaDon> listHD = (ArrayList<HoaDon>) hoaDonService.getAll();
            request.setAttribute("listHD",listHD);
            request.getRequestDispatcher("/views/ManagerBill.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String mauSacID = request.getParameter("id");
            if (mauSacID != null && !mauSacID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(mauSacID);
                    sanPhamService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-product");
        } else if (uri.contains("/detail")) {
            String productID = request.getParameter("id");
            if (productID != null && !productID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(productID);
                    SanPham sp = sanPhamService.findSanPhamByID(uuid);
                    request.setAttribute("spDetail", sp);
                    request.getRequestDispatcher("/views/DetailProduct.jsp").forward(request, response);

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
            UUID spId = UUID.randomUUID();
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String hinhAnh = "";
            System.out.println(ma);
            System.out.println(ten);

            try {
                // Tạo thư mục để lưu trữ file tải lên
                File dir = new File(request.getServletContext().getRealPath("/files"));
                if (!dir.exists()) {
                    dir.mkdir();
                }
                // Lấy thông tin về file hình ảnh
                // Lưu các file upload vào thư mục files
                Part photo = request.getPart("image");
                // Lấy tên đường dẫn
                // Cho vào file
                File imageFile = new File(dir, photo.getSubmittedFileName());
                // Lưu trữ file tải lên
                photo.write(imageFile.getAbsolutePath());
                hinhAnh = "/files/" + imageFile.getName();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(hinhAnh);
            SanPham sanPham = new SanPham(ma, ten, hinhAnh);
            sanPhamService.insert(sanPham);
            response.sendRedirect("/manager-product");

        } else if (uri.contains("/update")) {
            String idSPStr = request.getParameter("id");
            UUID spId = UUID.fromString(idSPStr);
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String hinhAnh = "";
            try {
                // Tạo thư mục để lưu trữ file tải lên
                File dir = new File(request.getServletContext().getRealPath("/files"));
                if (!dir.exists()) {
                    dir.mkdir();
                }
                // Lấy thông tin về file hình ảnh
                // Lưu các file upload vào thư mục files
                Part photo = request.getPart("image");
                // Lấy tên đường dẫn
                // Cho vào file
                File imageFile = new File(dir, photo.getSubmittedFileName());
                // Lưu trữ file tải lên
                photo.write(imageFile.getAbsolutePath());
                hinhAnh = "/files/" + imageFile.getName();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(hinhAnh);
            SanPham sanPham = new SanPham();
            sanPham.setId(spId);
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            sanPham.setHinhAnh(hinhAnh);
            sanPhamService.update(sanPham);
            response.sendRedirect("/manager-product");

        }
    }
}
