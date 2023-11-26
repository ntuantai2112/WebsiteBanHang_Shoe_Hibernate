package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.NSX;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.NSXRepository;

import java.util.List;
import java.util.UUID;

public class NSXService {

    NSXRepository nsxRepository = new NSXRepository();


    public List<NSX> getAll(){

        return nsxRepository.getList();
    };

    public void insert(NSX nsx){
        nsxRepository.createNSX(nsx);
    };
    public void update(NSX nsx){
        nsxRepository.updateNSX(nsx);
    };
    public void delete( UUID id){
        nsxRepository.deleteNSX(id);
    };

    public NSX findNSXtByID(UUID id){
        return nsxRepository.findNSXtByID(id);
    }
}
