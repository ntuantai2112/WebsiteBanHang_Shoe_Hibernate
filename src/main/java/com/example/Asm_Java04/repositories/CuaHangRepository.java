package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepository {
    public ArrayList<CuaHang> getList() {
        ArrayList<CuaHang> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createCuaHang(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
//        finally {
//            session.close();
//        }
    }

    public void updateCuaHang(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.update(ch);
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
            e.printStackTrace();
            transaction.rollback();
        }
//        } finally {
//            session.close();
//        }
    }

    public void deleteCuaHang(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            CuaHang cv = session.get(CuaHang.class, id);
            if (cv != null) {
                session.delete(cv);
            } else {
//                throw  new Exception("Student này không tồn tại!");
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public CuaHang findCuaHangByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from CuaHang o where o.id = :id";
            TypedQuery<CuaHang> query = session.createQuery(jpql, CuaHang.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
