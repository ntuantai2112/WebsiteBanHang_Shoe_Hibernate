package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChucVu;
import com.example.Asm_Java04.model.CuaHang;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    public ArrayList<CuaHang> getList() {
        ArrayList<CuaHang> ketQua = new ArrayList<>();
        try (Session session  = HibernateUtil.getFACTORY().openSession();)  {
            ketQua = (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    public void createCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void updateCuaHang(CuaHang ch){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
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

    public void deleteCuaHang(UUID id){
        Transaction transaction = null;
        try(Session session  = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            CuaHang cv = session.get(CuaHang.class, id);
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
