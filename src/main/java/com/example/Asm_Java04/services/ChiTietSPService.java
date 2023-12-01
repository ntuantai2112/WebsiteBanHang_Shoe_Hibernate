package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.repositories.ChiTietSPRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPService {

    ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    public List<ChiTietSanPham> getAll() {

        return chiTietSPRepository.getList();
    }




    public ArrayList<ChiTietSanPham> searchChiTietSanPhamByName(String keyword) {
        return chiTietSPRepository.searchChiTietSanPhamByName(keyword);
    }

    public void insert(ChiTietSanPham sp) {
        chiTietSPRepository.insert(sp);
    }

    ;

    public void update(ChiTietSanPham sp) {
        chiTietSPRepository.update(sp);
    }

    ;

    public void delete(UUID id) {
        chiTietSPRepository.delete(id);

    }

    ;
    //Láy ra chi tiết sản phẩm theo ID Chi Tiết sản phẩm
    public ChiTietSanPham findChiTietSanPhamByID(UUID id) {
        return chiTietSPRepository.findChiTietSanPhamByID(id);
    }

    // Lấy ra chi tiết sản phẩm theo ID sản phẩm
    public ChiTietSanPham getChiTietSanPhamByIDSP(UUID idSanPham) {
        return chiTietSPRepository.getChiTietSanPhamByIDSP(idSanPham);
    }



    // Lấy ra 3 sản phẩm tiesp teo
    public ArrayList<ChiTietSanPham> getChiTietSPLimited(int amount) {
        return chiTietSPRepository.getChiTietSPLimited(amount);
    }
    // Lấy ra 3 sản phẩm
    public ArrayList<ChiTietSanPham> getThreeItems() {
        return chiTietSPRepository.getThreeItems();
    }

    // Số lượng trang cần hiển thị
    public int getCountPageOfChiTietSP() {
        return chiTietSPRepository.getCountPageOfChiTietSP();
    }

    // Phân trang
    public ArrayList<ChiTietSanPham> getPaging(int offset) {
        return chiTietSPRepository.getPaging(offset);
    }

    // Lấy chi tiết sản phẩm theo tên danh mục
    public ArrayList<ChiTietSanPham> getChiTietSanPhamByCategoryID(UUID categoryID) {
        return chiTietSPRepository.getChiTietSanPhamByCategoryID(categoryID);
    }
    public ChiTietSanPham getChiTietSanPhamByID(UUID id){
        return chiTietSPRepository.getChiTietSanPhamByID(id);
    }


}
