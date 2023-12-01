package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.GioHang;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class GioHangRepository {
    public ArrayList<GioHang> getList() {
        ArrayList<GioHang> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<GioHang>) session.createQuery("from GioHang ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public void createGioHang(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void updateGioHang(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.saveOrUpdate(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    ;

    public void deleteGioHang(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            GioHang cv = session.get(GioHang.class, id);
            if (cv != null) {
                session.delete(cv);
            } else {
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public GioHang findGioHangByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from GioHang o where o.id = :id";
            TypedQuery<GioHang> query = session.createQuery(jpql, GioHang.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
