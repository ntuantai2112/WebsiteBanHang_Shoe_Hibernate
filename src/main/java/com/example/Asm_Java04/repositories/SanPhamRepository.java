package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createSanPham(SanPham sp){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void updateSanPham(SanPham sp){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void deleteSanPham(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, id);
            if(sp != null) {
                session.delete(sp);
            }else{
//                throw  new Exception("Student này không tồn tại!");
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


}
