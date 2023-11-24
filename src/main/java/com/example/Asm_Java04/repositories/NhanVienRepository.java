package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.NhanVien;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public ArrayList<NhanVien> getList() {
        ArrayList<NhanVien> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<NhanVien>) session.createQuery("from NhanVien ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createNhanVien(NhanVien nv){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void updateNhanVien(NhanVien nv){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void deleteNhanVien(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            NhanVien cv = session.get(NhanVien.class, id);
            if(cv != null) {
                session.delete(cv);
            }else{
//                throw  new Exception("Student này không tồn tại!");
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien findNhanVientByID(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from ChucVu o where o.id = :id";
            TypedQuery<NhanVien> query = session.createQuery(jpql, NhanVien.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
