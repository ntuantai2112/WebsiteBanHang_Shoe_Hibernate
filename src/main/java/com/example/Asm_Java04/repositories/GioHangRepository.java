package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.GioHang;
import com.example.Asm_Java04.model.GioHangChiTiet;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class GioHangRepository {
    public List<GioHang> getAll(){

        return null;
    };

    public void insert(GioHang sp){

    };
    public void update(GioHang sp){

    };
    public void delete( GioHang sp){

    };

//    public GioHang findGioHangByID(UUID id){
//        Transaction transaction = null;
//        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
//            String jpql = "Select o from GioHang o where o.id = :id";
//            TypedQuery<GioHang> query = session.createQuery(jpql, GioHang.class);
//            query.setParameter("id", id);
//            return query.getSingleResult();
//        }catch (Exception e){
//            e.printStackTrace();
//            transaction.rollback();
//        }
//        return null;
//    }
}
