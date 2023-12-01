package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.GioHang;
import com.example.Asm_Java04.repositories.GioHangChiTietRepository;

import java.util.ArrayList;

public class GioHangService {
    GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();

    public ArrayList<GioHang> getAll() {

        return null;
    }

    ;

    public void insert(GioHang gioHang) {
//        gioHangChiTietRepository.insert(sp);
    }

    ;

    public void update(GioHang gioHang) {

    }

    ;

    public void delete(GioHang gioHang) {

    }

    ;

//    public GioHangChiTiet findGioHangChiTiettByID(UUID id){
//        return gioHangChiTietRepository.findGioHangChiTiettByID(id);
//    }
}
