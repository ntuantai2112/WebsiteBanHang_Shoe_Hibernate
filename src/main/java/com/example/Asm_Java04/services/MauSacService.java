package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.MauSac;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.MauSacRepository;

import java.util.List;
import java.util.UUID;

public class MauSacService {

    MauSacRepository mauSacRepository = new MauSacRepository();
    public List<MauSac> getAll(){

        return mauSacRepository.getList();
    };

    public void insertMauSac(MauSac ms){
        mauSacRepository.createMauSac(ms);
    };
    public void update(MauSac sp){
        mauSacRepository.updateMauSac(sp);
    };
    public void delete( UUID sp){
        mauSacRepository.deleteMauSac(sp);
    };
}
