package com.example.Asm_Java04.controller;

import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.HoaDonChiTiet;
import com.example.Asm_Java04.model.KhachHang;
import com.example.Asm_Java04.services.HoaDonChiTietService;
import com.example.Asm_Java04.services.HoaDonService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AddOrderController", value = "/AddOrderController")
public class AddOrderController extends HttpServlet {

    HoaDonService hoaDonService = new HoaDonService();
    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("cart");// luu tam vao session

        if (obj != null) {//KIEM TRA XEM CO SP TRONG GIO HANG KO?
            Map<String, HoaDonChiTiet> map = (Map<String, HoaDonChiTiet>) obj;

            //TAO HOA DON TRUOC, DE LAY DUOC ID BILL
            HoaDon bill = new HoaDon();
            // Khởi tạo UUID cho 'id'
//            bill.setId(UUID.randomUUID());
            bill.setNgayTao(new Date());
            System.out.println(bill.getId());

            // lay dang nhap
//            KhachHang buyer = (KhachHang) session.getAttribute("loginUser");
//            bill.setTenNguoiNhan(buyer.getTen());
            //XEM THEM O LOP BILLDAO, CACH TRA VE ID TU GEN O SQL
            hoaDonService.insert(bill);// save bill trc de lay id
            // Tim mat hang
            long total = 0;//tinh tong gia

            //lap cac phan tu trong map
            for (Map.Entry<String, HoaDonChiTiet> entry : map.entrySet()) {
                HoaDonChiTiet billProduct = entry.getValue();

                billProduct.setHoaDon(bill);// set bill id vao day
                //luu lai cac mat hang
                hoaDonChiTietService.insert(billProduct);
                // tinh tong gia
//                total += (long) billProduct.getSoLuong() * billProduct.getDonGia();
            }

            ///cap nhat lai bill de co tong gia tien
//            bill.set(total);
//            billDao.update(bill);

            // chuyen ve trang thanh cong
            // xoa session gio hang vi da tao don hang thanh cong, giai phong bo nho
            session.removeAttribute("cart");
//            resp.sendRedirect(req.getContextPath() + "/member/bills");
        } else {
            // tra ve trang chu neu gio hang rong
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
