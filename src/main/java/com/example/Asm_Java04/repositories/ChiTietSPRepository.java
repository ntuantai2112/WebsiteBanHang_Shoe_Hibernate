package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    public List<ChiTietSanPham> getAll(){

        return null;
    };

    public void insert(ChiTietSanPham sp){
//        chiTietSPRepository.insert(sp);
    };
    public void update(ChiTietSanPham sp){
//        chiTietSPRepository.update(sp);
    };
    public void delete( UUID sp){
//        chiTietSPRepository.delete();
    };
    public ChiTietSanPham findChiTietSanPhamByID(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from ChiTietSanPham o where o.id = :id";
            TypedQuery<ChiTietSanPham> query = session.createQuery(jpql, ChiTietSanPham.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
