package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChiTietSanPham;
import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    public ArrayList<ChiTietSanPham> getList() {
        ArrayList<ChiTietSanPham> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<ChiTietSanPham>) session.createQuery("from ChiTietSanPham ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public void insert(ChiTietSanPham sp){
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
    };
    public void update(ChiTietSanPham sp){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.saveOrUpdate(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    };
    public void delete( UUID id){
       Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            ChiTietSanPham cv = session.get(ChiTietSanPham.class, id);
            if(cv != null) {
                session.delete(cv);
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    };
    public ChiTietSanPham findChiTietSanPhamByID(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from ChiTietSanPham o where o.id = :id";
            TypedQuery<ChiTietSanPham> query = session.createQuery(jpql, ChiTietSanPham.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
