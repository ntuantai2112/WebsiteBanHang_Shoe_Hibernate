package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.NSX;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {

    public ArrayList<NSX> getList() {
        ArrayList<NSX> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<NSX>) session.createQuery("from NSX ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createNSX(NSX nsx){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
//        finally {
//            session.close();
//        }
    }

    public void updateNSX(NSX nsx){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.update(nsx);
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

    public void deleteNSX(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            NSX cv = session.get(NSX.class, id);
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
}
