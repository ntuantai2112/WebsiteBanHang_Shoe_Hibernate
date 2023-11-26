package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.SanPhamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamService {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    public ArrayList<SanPham> getAll(){

        return sanPhamRepository.getList();
    };

    public void insert(SanPham sp){
        sanPhamRepository.createSanPham(sp);
    };
    public void update(SanPham sp){
        sanPhamRepository.updateSanPham(sp);
    };
    public void delete( UUID id){
        sanPhamRepository.deleteSanPham(id);
    };

    public SanPham findSanPhamByID(UUID id){
        return sanPhamRepository.findSanPhamByID(id);
    }
}
