package com.example.PH40458_LAB7_8_2129.repository;

import com.example.PH40458_LAB7_8_2129.config.HibernateConfig;
import com.example.PH40458_LAB7_8_2129.entity.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChiTietSanPhamRepository {
    public List<ChiTietSanPham> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<ChiTietSanPham> listctsp = s.createQuery("FROM ChiTietSanPham").list();
        s.close();
        return listctsp;
    }

    public ChiTietSanPham getOne(Long idCTSP) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM ChiTietSanPham WHERE idCTSP=:idCTSP");
        q.setParameter("idCTSP", idCTSP);
        ChiTietSanPham ctsp = (ChiTietSanPham) q.getSingleResult();
        return ctsp;
    }

    public void addCT(ChiTietSanPham ctsp) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
//            Transaction tra = null;
//            tra = s.beginTransaction();
//            s.persist(ctsp);
//            tra.commit();
            s.getTransaction().begin();
            s.saveOrUpdate(ctsp);
            s.getTransaction().commit();
        } catch (Exception e) {
            Session s = HibernateConfig.getFACTORY().openSession();
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void removeCT(ChiTietSanPham ctsp) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
//            Transaction tra = null;
//            tra = s.beginTransaction();
//            s.delete(ctsp);
//            tra.commit();
            s.getTransaction().begin();
            s.delete(ctsp);
            s.getTransaction().commit();
        } catch (Exception e) {
            Session s = HibernateConfig.getFACTORY().openSession();
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSanPhamRepository().getAll());
    }
}
