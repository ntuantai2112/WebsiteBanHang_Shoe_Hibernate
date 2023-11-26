package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.ChiTietSPRepository;

import java.util.List;
import java.util.UUID;

public class ChiTietSPService {

    ChiTietSPRepository chiTietSPRepository  = new ChiTietSPRepository();

    public List<ChiTietSanPham> getAll(){

        return chiTietSPRepository.getAll();
    };

    public void insert(ChiTietSanPham sp){
        chiTietSPRepository.insert(sp);
    };
    public void update(ChiTietSanPham sp){
        chiTietSPRepository.update(sp);
    };
    public void delete( UUID id){
        chiTietSPRepository.delete(id);

    };

    public ChiTietSanPham findChiTietSanPhamByID(UUID id){
       return chiTietSPRepository.findChiTietSanPhamByID(id);
    }
}
