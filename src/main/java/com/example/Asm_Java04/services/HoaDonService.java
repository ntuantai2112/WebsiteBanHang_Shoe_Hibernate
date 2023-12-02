package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.HoaDonRepository;

import java.util.List;

public class HoaDonService {
    HoaDonRepository hoaDonRepository = new HoaDonRepository();

    public List<HoaDon> getAll() {

        return hoaDonRepository.getList();
    }

    ;

    public void insert(HoaDon hoaDon) {
            hoaDonRepository.insert(hoaDon);
    }

    ;

    public void update(HoaDon hoaDon) {

    }

    ;

    public void delete(HoaDon hoaDon) {

    }

    ;
}
