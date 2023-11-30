package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.GioHangChiTiet;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.GioHangChiTietRepository;

import java.util.ArrayList;

public class GioHangService {
    GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();

    public ArrayList<GioHang> getAll() {

        return null;
    }

    ;

    public void insert(GioHang sp) {
//        gioHangChiTietRepository.insert(sp);
    }

    ;

    public void update(GioHang sp) {

    }

    ;

    public void delete(GioHang sp) {

    }

    ;

//    public GioHangChiTiet findGioHangChiTiettByID(UUID id){
//        return gioHangChiTietRepository.findGioHangChiTiettByID(id);
//    }
}
