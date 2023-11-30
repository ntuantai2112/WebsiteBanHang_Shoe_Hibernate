package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.NhanVien;
import com.example.Asm_Java04.model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class NhanVienRepository {
    public ArrayList<NhanVien> getList() {
        ArrayList<NhanVien> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<NhanVien>) session.createQuery("from NhanVien ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createNhanVien(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
//        finally {
//            session.close();
//        }
    }

    public void updateNhanVien(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.update(nv);
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

    public void deleteNhanVien(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            NhanVien cv = session.get(NhanVien.class, id);
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

    public NhanVien findNhanVientByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from NhanVien o where o.id = :id";
            TypedQuery<NhanVien> query = session.createQuery(jpql, NhanVien.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public NhanVien getNhanVien(String userName, String matKhau) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "SELECT o FROM NhanVien o WHERE o.userName = :userName AND o.matKhau = :matKhau";
            TypedQuery<NhanVien> query = session.createQuery(jpql, NhanVien.class);
            query.setParameter("userName", userName); // Sửa thành "userName"
            query.setParameter("matKhau", matKhau); // Sửa thành "matKhau"
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            // Xử lý nếu không tìm thấy kết quả
            System.out.println("Không tìm thấy người dùng với tên đăng nhập và mật khẩu này.");
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ khác nếu có
        }
        return null;
    }

    public static void main(String[] args) {
        NhanVienRepository repository = new NhanVienRepository();
        NhanVien nv = repository.getNhanVien("Taik3", "123456");

        System.out.println(nv.getUserName());
        System.out.println(nv.getMatKhau());
    }
}
