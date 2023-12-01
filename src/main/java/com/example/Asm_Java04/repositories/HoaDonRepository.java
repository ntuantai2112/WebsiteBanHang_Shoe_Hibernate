package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HoaDonRepository {
    public List<SanPham> getAll() {

        return null;
    }

    ;

    public void insert(SanPham sp) {

    }

    ;

    public void update(SanPham sp) {

    }

    ;

    public void delete(SanPham sp) {

    }

    ;

    public HoaDon findHoaDonByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from HoaDon o where o.id = :id";
            TypedQuery<HoaDon> query = session.createQuery(jpql, HoaDon.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
