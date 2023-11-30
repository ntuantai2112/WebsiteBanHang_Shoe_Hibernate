package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.ChiTietSPRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPService {

    ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    public List<ChiTietSanPham> getAll() {

        return chiTietSPRepository.getList();
    }

    ;

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

    public ChiTietSanPham findChiTietSanPhamByID(UUID id) {
        return chiTietSPRepository.findChiTietSanPhamByID(id);
    }


    public ChiTietSanPham getChiTietSanPhamByIDSP(UUID idSanPham) {
        return chiTietSPRepository.getChiTietSanPhamByIDSP(idSanPham);
    }

    public ArrayList<ChiTietSanPham> getChiTietSPLimited(int amount) {
        return chiTietSPRepository.getChiTietSPLimited(amount);
    }

    public ArrayList<ChiTietSanPham> getThreeItems() {
        return chiTietSPRepository.getThreeItems();
    }

    public int getCountPageOfChiTietSP() {
        return chiTietSPRepository.getCountPageOfChiTietSP();
    }

    public ArrayList<ChiTietSanPham> getPaging(int offset) {
        return chiTietSPRepository.getPaging(offset);
    }

    public ArrayList<ChiTietSanPham> getChiTietSanPhamByCategoryID(UUID categoryID) {
        return chiTietSPRepository.getChiTietSanPhamByCategoryID(categoryID);
    }
}
