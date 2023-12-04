package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.HoaDon;
import com.example.Asm_Java04.model.KhachHang;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HoaDonRepository {
    public ArrayList<HoaDon> getList() {
        ArrayList<HoaDon> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<HoaDon>) session.createQuery("from HoaDon ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    ;

    public void insert(HoaDon hoaDon) {
        Transaction transaction = null;
        Session session = HibernateUtil.getFACTORY().openSession();
        try  {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();

        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    ;

    public void update(SanPham sp) {

    }

    ;

    public void delete(SanPham sp) {

    }

    ;

    public HoaDon findHoaDonByID(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "Select o from HoaDon o where o.id = :id";
            TypedQuery<HoaDon> query = session.createQuery(jpql, HoaDon.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }


    public static void main(String[] args) {
        HoaDonRepository hoaDonRepository = new HoaDonRepository();
        HoaDon hoaDon = new HoaDon();
        UUID idHD = UUID.randomUUID();
        System.out.println(idHD);
        hoaDon.setId(idHD);
        hoaDon.setNgayTao(new Date());
        hoaDonRepository.insert(hoaDon);
    }
}
