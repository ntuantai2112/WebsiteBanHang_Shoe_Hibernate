package com.example.Asm_Java04.repositories;

import com.example.Asm_Java04.model.ChiTietSanPham;
//import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.model.SanPham;
import com.example.Asm_Java04.services.ChiTietSPService;
import com.example.Asm_Java04.util.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChiTietSPRepository {

    // Lấy tất cả danh sách sản phẩm
    public ArrayList<ChiTietSanPham> getList() {
        ArrayList<ChiTietSanPham> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            ketQua = (ArrayList<ChiTietSanPham>) session.createQuery("from ChiTietSanPham ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // Lấy chi tiết sản phẩm theo tên
    public ArrayList<ChiTietSanPham> searchChiTietSanPhamByName(String keyword) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select c FROM ChiTietSanPham c WHERE c.sanPham.ten LIKE :keyword";
            Query<ChiTietSanPham> query = session.createQuery(hql, ChiTietSanPham.class);
            query.setParameter("keyword", "%" + keyword + "%");

            ArrayList<ChiTietSanPham> results = (ArrayList<ChiTietSanPham>) query.list();
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Chức năng load more sản phẩm, lấy ra 3 sản phẩm
    public ArrayList<ChiTietSanPham> getThreeItems() {
        ArrayList<ChiTietSanPham> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<ChiTietSanPham> query = session.createQuery("SELECT o FROM ChiTietSanPham o ORDER BY o.id");
            query.setMaxResults(3); // Giới hạn số lượng kết quả trả về thành 3

            ketQua = (ArrayList<ChiTietSanPham>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // Chức năng load more sản phẩm, lấy ra 3 sản phẩm tiếp theo
    public ArrayList<ChiTietSanPham> getChiTietSPLimited(int offset) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createSQLQuery("SELECT * FROM ChiTietSP ORDER BY Id OFFSET :offset ROWS FETCH NEXT 3 ROWS ONLY")
                    .addEntity(ChiTietSanPham.class)
                    .setParameter("offset", offset);

            ArrayList<ChiTietSanPham> results = (ArrayList<ChiTietSanPham>) query.list();

            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    // Chức năng phân trang lấy số lượng Page muốn hiển thị
    public int getCountPageOfChiTietSP() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT COUNT(c) FROM ChiTietSanPham c ";
            Query<Long> query = session.createQuery(hql, Long.class);
            Long result = query.uniqueResult();
            if (result != null) {
                int total = result.intValue();
                int countPage = 0;
                countPage = total / 6;
                if (total % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }




    public ChiTietSanPham getChiTietSanPhamByID(UUID id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            ChiTietSanPham chiTietSanPham = session.find(ChiTietSanPham.class,id);
            return chiTietSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Chức năng load more sản phẩm, lấy ra 6 sản phẩm tiếp theo
    public ArrayList<ChiTietSanPham> getPaging(int offset) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSanPham")
                    .setFirstResult((offset - 1) * 6)
                    .setMaxResults(6);

            ArrayList<ChiTietSanPham> results = (ArrayList<ChiTietSanPham>) query.list();

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(ChiTietSanPham sp) {
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
    }

    ;

    public void update(ChiTietSanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            session.saveOrUpdate(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    ;

    public void delete(UUID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //Tạo ra Transaction
            transaction = session.beginTransaction();
            ChiTietSanPham cv = session.get(ChiTietSanPham.class, id);
            if (cv != null) {
                session.delete(cv);
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    ;

    //Tìm kiếm chi tiết sản phẩm theo ID
    public ChiTietSanPham findChiTietSanPhamByID(UUID id) {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSanPham o WHERE o.id = :id");
            query.setParameter("id", id);
            chiTietSanPham = (ChiTietSanPham) query.getSingleResult();
            return chiTietSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Tìm kiếm chi tiết sản phẩm theo ID Sản phẩm
    public ChiTietSanPham getChiTietSanPhamByIDSP(UUID idSanPham) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "SELECT o FROM ChiTietSanPham o WHERE o.sanPham.id = :idSanPham";
            TypedQuery<ChiTietSanPham> query = session.createQuery(jpql, ChiTietSanPham.class);
            query.setParameter("idSanPham", idSanPham);

            try {
                ChiTietSanPham chiTietSanPham = query.getSingleResult();
                return chiTietSanPham;
            } catch (NoResultException e) {
                // Handle the case where no result is found
                System.out.println("Không tìm thấy chi tiết sản phẩm với ID sản phẩm này.");
                return null; // or throw a custom exception or handle it as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any other exceptions that might occur during the query execution
        }
        return null;
    }

    // Lấy danh sách chi tiết sản phẩm theo CategoryID
    public ArrayList<ChiTietSanPham> getChiTietSanPhamByCategoryID(UUID categoryID) {
        ArrayList<ChiTietSanPham> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String jpql = "SELECT c FROM ChiTietSanPham c WHERE c.dongSanPham.id = :categoryId";
            TypedQuery<ChiTietSanPham> query = session.createQuery(jpql, ChiTietSanPham.class);
            query.setParameter("categoryId", categoryID);
            ketQua = (ArrayList<ChiTietSanPham>) query.getResultList();
            return ketQua;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might occur during the query execution
        }
        return null;
    }


//    public static void main(String[] args) {
//        ChiTietSPRepository chiTietSPService = new ChiTietSPRepository();
////        SanPhamRepository sanPhamRepository = new SanPhamRepository();
////        String id = "ac5f1e88-e9dc-c842-83e5-3f4a8b056481";
////        UUID idC = UUID.fromString(id);
//        ArrayList<ChiTietSanPham> listP =chiTietSPService.getPaging(1);
//        for (ChiTietSanPham sp: listP){
//            System.out.println(sp.getSanPham().getTen());
//        }
//    }


}
