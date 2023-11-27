package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.CuaHang;
import com.example.Asm_Java04.model.DongSP;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.DongSanPhamRepository;

import java.util.List;
import java.util.UUID;

public class DongSanPhamService {

    DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();
    public List<DongSP> getAll(){

        return dongSanPhamRepository.getList();
    };

    public void insert(DongSP sp){
        dongSanPhamRepository.createDongSP(sp);
    };
    public void update(DongSP sp){
        dongSanPhamRepository.updateDongSP(sp);
    };
    public void delete( UUID id){
        dongSanPhamRepository.deleteDongSP(id);
    };

    public DongSP findCategorytByID(UUID id){
        return dongSanPhamRepository.findCategorytByID(id);
    }
}
