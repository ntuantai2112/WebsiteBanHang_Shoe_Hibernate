package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class SanPhamRepository {

    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // Lấy sản phẩm theo tên
    public ArrayList<SanPham> searchSanPhamByName(String keyword) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select c FROM SanPham c WHERE c.ten LIKE :keyword";
            Query<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setParameter("keyword", "%" + keyword + "%");

            ArrayList<SanPham> results = (ArrayList<SanPham>) query.list();
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void createSanPham(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
//        finally {
//            session.close();
//        }
    }

    public void updateSanPham(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.update(sp);
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

    public void deleteSanPham(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, id);
            if (sp != null) {
                session.delete(sp);
            } else {
//                throw  new Exception("Student này không tồn tại!");
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SanPham findSanPhamByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from SanPham o where o.id = :id";
            TypedQuery<SanPham> query = session.createQuery(jpql, SanPham.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public SanPham findSanPhamByID(String keyword) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from SanPham o where o.ten = :keyword";
            TypedQuery<SanPham> query = session.createQuery(jpql, SanPham.class);
            query.setParameter("keyword", keyword);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    // Chức năng load more sản phẩm, lấy ra 6 sản phẩm tiếp theo
    public ArrayList<SanPham> getPaging(int offset) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createSQLQuery("SELECT * FROM SanPham ORDER BY Id OFFSET :offset ROWS FETCH NEXT 6 ROWS ONLY")
                    .addEntity(SanPham.class)
                    .setParameter("offset", (offset - 1) * 6);

            ArrayList<SanPham> results = (ArrayList<SanPham>) query.list();

            return results;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


}
