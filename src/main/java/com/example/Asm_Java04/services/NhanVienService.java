package com.example.Asm_Java04.services;

import com.example.Asm_Java04.model.NhanVien;
import com.example.Asm_Java04.repositories.NhanVienRepository;

import java.util.List;
import java.util.UUID;

public class NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    public List<NhanVien> getAll() {

        return nhanVienRepository.getList();
    }

    public void insert(NhanVien nv) {
        nhanVienRepository.createNhanVien(nv);
    }

    public void update(NhanVien nv) {
        nhanVienRepository.updateNhanVien(nv);
    }

    public void delete(UUID id) {
        nhanVienRepository.deleteNhanVien(id);
    }

    public NhanVien findNhanVientByID(UUID id) {
        return nhanVienRepository.findNhanVientByID(id);
    }

    public NhanVien getNhanVien(String userName, String matKhau) {
        return nhanVienRepository.getNhanVien(userName, matKhau);
    }

}
