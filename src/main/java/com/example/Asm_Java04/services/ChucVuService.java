package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.repositories.ChucVuRepository;

import java.util.List;
import java.util.UUID;

public class ChucVuService {

    ChucVuRepository chucVuRepository = new ChucVuRepository();

    public List<ChucVu> getAll() {

        return chucVuRepository.getList();
    }

    ;

    public void insert(ChucVu cv) {
        chucVuRepository.createChucVu(cv);
    }

    ;

    public void update(ChucVu cv) {
        chucVuRepository.updateChucVu(cv);
    }

    ;

    public void delete(UUID id) {
        chucVuRepository.deleteChucVu(id);
    }

    ;

    public ChucVu findChucVutByID(UUID id) {
        return chucVuRepository.findChucVutByID(id);
    }
}
