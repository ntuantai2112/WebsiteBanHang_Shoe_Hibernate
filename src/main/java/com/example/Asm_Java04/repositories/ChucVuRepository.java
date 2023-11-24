package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepository {

    public ArrayList<ChucVu> getList() {
        ArrayList<ChucVu> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<ChucVu>) session.createQuery("from ChucVu ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createChucVu(ChucVu cv){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
//        finally {
//            session.close();
//        }
    }

    public void updateChucVu(ChucVu cv){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.update(cv);
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

    public void deleteChucVu(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            ChucVu cv = session.get(ChucVu.class, id);
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

    public ChucVu findChucVutByID(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from ChucVu o where o.id = :id";
            TypedQuery<ChucVu> query = session.createQuery(jpql, ChucVu.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
