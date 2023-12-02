package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.HoaDonChiTiet;
import com.example.Asm_Java04.repositories.HoaDonChiTietRepository;

import java.util.List;

public class HoaDonChiTietService {

    HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    public List<HoaDonChiTiet> getAll() {

        return null;
    }

    ;

    public void insert(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.insert(hoaDonChiTiet);
    }

    ;

    public void update(HoaDonChiTiet sp) {

    }

    ;

    public void delete(HoaDonChiTiet sp) {

    }

    ;
}
