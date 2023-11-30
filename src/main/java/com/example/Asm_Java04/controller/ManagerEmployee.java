package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.KhachHang;
import com.example.Asm_Java04.model.NhanVien;
import com.example.Asm_Java04.services.ChucVuService;
import com.example.Asm_Java04.services.CuaHangService;
import com.example.Asm_Java04.services.KhachHangService;
import com.example.Asm_Java04.services.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "/ManagerEmployee", value = {"/manager-employee"
        , "/employee/add", "/employee/update", "/employee/delete", "/employee/detail"
})

public class ManagerEmployee extends HttpServlet {

    NhanVienService nhanVienService = new NhanVienService();
    ChucVuService chucVuService = new ChucVuService();
    CuaHangService cuaHangService = new CuaHangService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/manager-employee")) {
            ArrayList<NhanVien> list = (ArrayList<NhanVien>) nhanVienService.getAll();
            ArrayList<CuaHang> listCH = (ArrayList<CuaHang>) cuaHangService.getAll();
            ArrayList<ChucVu> listCV = (ArrayList<ChucVu>) chucVuService.getAll();
            request.setAttribute("listNV", list);
            request.setAttribute("listCH", listCH);
            request.setAttribute("listCV", listCV);
            request.getRequestDispatcher("/views/ManagerEmployee.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String khachHangID = request.getParameter("id");
            System.out.println(khachHangID);
            if (khachHangID != null && !khachHangID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(khachHangID);
                    nhanVienService.delete(uuid);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            response.sendRedirect("/manager-employee");
        } else if (uri.contains("/detail")) {
            String empID = request.getParameter("id");
            ArrayList<NhanVien> list = (ArrayList<NhanVien>) nhanVienService.getAll();
            ArrayList<CuaHang> listCH = (ArrayList<CuaHang>) cuaHangService.getAll();
            ArrayList<ChucVu> listCV = (ArrayList<ChucVu>) chucVuService.getAll();
            request.setAttribute("listCH", listCH);
            request.setAttribute("listCV", listCV);
            if (empID != null && !empID.isEmpty()) {
                try {
                    UUID uuid = UUID.fromString(empID);
                    NhanVien nhanVien = nhanVienService.findNhanVientByID(uuid);
                    request.setAttribute("nvDetail", nhanVien);
                    request.getRequestDispatcher("/views/DetailEmployee.jsp").forward(request, response);

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

            String fullName = request.getParameter("ten");
            String[] nameParts = fullName.split("\\s+");

            String ho = ""; // Default to empty string if no parts available
            String tenDem = "";
            String ten = "";

            if (nameParts.length >= 3) {
                ho = nameParts[0];
                tenDem = nameParts[1];
                ten = nameParts[2];
            } else if (nameParts.length == 2) {
                ho = nameParts[0];
                ten = nameParts[1];
            } else if (nameParts.length == 1) {
                ten = nameParts[0];
            }

            String ngaySinhStr = request.getParameter("ngaySinh");
            Date ngaySinh = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust pattern as per your date format
            try {
                ngaySinh = dateFormat.parse(ngaySinhStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception
            }

            String ma = request.getParameter("ma");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String matKhau = request.getParameter("matKhau");
            String gioiTinh = request.getParameter("gioiTinh");
            String trangThai = request.getParameter("trangThai");
            String idStrCH = request.getParameter("cuaHang");
            UUID idCH = UUID.fromString(idStrCH);
            String idStrCV = request.getParameter("cv");
            UUID idCV = UUID.fromString(idStrCV);
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(idCH);
            ChucVu chucVu = new ChucVu();
            chucVu.setId(idCV);


//            UUID nhanVienId = UUID.randomUUID();
            NhanVien nhanVien = new NhanVien(ma, ho, tenDem, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, Integer.parseInt(trangThai), cuaHang, chucVu);
            nhanVienService.insert(nhanVien);
            response.sendRedirect("/manager-employee");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            UUID empID = UUID.fromString(id);
            String fullName = request.getParameter("ten");
            System.out.println(fullName);
            String[] nameParts = fullName.split("\\s+");

            String ho = ""; // Default to empty string if no parts available
            String tenDem = "";
            String ten = "";

            if (nameParts.length >= 3) {
                ho = nameParts[0];
                tenDem = nameParts[1];
                ten = nameParts[2];
            } else if (nameParts.length == 2) {
                ho = nameParts[0];
                ten = nameParts[1];
            } else if (nameParts.length == 1) {
                ten = nameParts[0];
            }

            String ngaySinhStr = request.getParameter("ngaySinh");
            Date ngaySinh = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust pattern as per your date format
            try {
                ngaySinh = dateFormat.parse(ngaySinhStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception
            }

            String ma = request.getParameter("ma");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String matKhau = request.getParameter("matKhau");
            String gioiTinh = request.getParameter("gioiTinh");
            String trangThai = request.getParameter("trangThai");
            String idStrCH = request.getParameter("cuaHang");
            UUID idCH = UUID.fromString(idStrCH);
            String idStrCV = request.getParameter("cv");
            UUID idCV = UUID.fromString(idStrCV);
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(idCH);
            ChucVu chucVu = new ChucVu();
            chucVu.setId(idCV);

            System.out.println(ho);
            System.out.println(tenDem);
            System.out.println(ten);

            NhanVien nhanVien = new NhanVien(empID, ma, ho, tenDem, ten, gioiTinh, ngaySinh, diaChi, sdt, matKhau, Integer.parseInt(trangThai), cuaHang, chucVu);
            nhanVienService.update(nhanVien);
            response.sendRedirect("/manager-employee");
        }
    }
}
