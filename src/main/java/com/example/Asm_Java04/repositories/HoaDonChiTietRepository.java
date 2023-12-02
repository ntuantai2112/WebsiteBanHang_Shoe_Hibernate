package com.example.Asm_Java04.repositories;



import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.HoaDonChiTiet;
import com.example.Asm_Java04.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HoaDonChiTietRepository {
    public List<HoaDonChiTiet> getAll() {

        return null;
    }

    ;

    public void insert(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getFACTORY().openSession();
        try  {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    ;

    public void update(HoaDonChiTiet sp) {

    }

    ;

    public void delete(HoaDonChiTiet sp) {

    }

    ;


}
