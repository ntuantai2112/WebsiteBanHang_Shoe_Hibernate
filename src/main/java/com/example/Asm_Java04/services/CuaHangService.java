package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.CuaHang;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.CuaHangRepository;

import java.util.List;
import java.util.UUID;

public class CuaHangService {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();


    public List<CuaHang> getAll(){

        return cuaHangRepository.getList();
    };

    public void insert(CuaHang ch){
        cuaHangRepository.createCuaHang(ch);
    };
    public void update(CuaHang ch){
        cuaHangRepository.updateCuaHang(ch);
    };
    public void delete( UUID id){
        cuaHangRepository.deleteCuaHang(id);
    };

    public CuaHang findCuaHangByID(UUID id){
        return cuaHangRepository.findCuaHangByID(id);
    }
}
