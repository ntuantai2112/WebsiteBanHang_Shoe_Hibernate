package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.KhachHang;
import com.example.Asm_Java04.repositories.KhachHangRepository;

import java.util.List;
import java.util.UUID;

public class KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    public List<KhachHang> getAll() {

        return khachHangRepository.getList();
    }

    ;

    public void insert(KhachHang khachHang) {
        khachHangRepository.createKhachHang(khachHang);
    }

    ;

    public void update(KhachHang khachHang) {
        khachHangRepository.updateKhachHang(khachHang);
    }

    ;

    public void delete(UUID id) {
        khachHangRepository.deleteKhachHang(id);
    }

    ;

    public KhachHang findKhachHangtByID(UUID id) {
        return khachHangRepository.findKhachHangtByID(id);
    }
}
