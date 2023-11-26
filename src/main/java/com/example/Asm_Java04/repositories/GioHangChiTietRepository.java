package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.DongSP;
import com.example.Asm_Java04.model.GioHangChiTiet;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GioHangChiTietRepository {
    public ArrayList<GioHangChiTiet> getAll(){

        return null;
    };

    public void insert(GioHangChiTiet gioHangChiTiet){

    };
    public void update(GioHangChiTiet gioHangChiTiet){

    };
    public void delete( GioHangChiTiet gioHangChiTiet){

    };

    public GioHangChiTiet findGioHangChiTiettByID(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from DongSP o where o.id = :id";
            TypedQuery<GioHangChiTiet> query = session.createQuery(jpql, GioHangChiTiet.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
