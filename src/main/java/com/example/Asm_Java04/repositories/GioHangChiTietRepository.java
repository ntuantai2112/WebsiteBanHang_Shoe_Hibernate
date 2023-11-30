package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.GioHangChiTiet;
import com.example.Asm_Java04.model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class GioHangChiTietRepository {
    public ArrayList<GioHangChiTiet> getList() {
        ArrayList<GioHangChiTiet> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<GioHangChiTiet>) session.createQuery("from GioHangChiTiet ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public void createGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(gioHangChiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.saveOrUpdate(gioHangChiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    ;

    public void deleteGioHangChiTiet(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            GioHangChiTiet gioHangChiTiet = session.get(GioHangChiTiet.class, id);
            if (gioHangChiTiet != null) {
                session.delete(gioHangChiTiet);
            } else {
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public GioHangChiTiet findGioHangByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from GioHangChiTiet o where o.id = :id";
            TypedQuery<GioHangChiTiet> query = session.createQuery(jpql, GioHangChiTiet.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
