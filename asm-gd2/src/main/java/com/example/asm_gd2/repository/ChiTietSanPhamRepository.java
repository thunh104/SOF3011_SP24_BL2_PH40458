package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChiTietSanPhamRepository {
    public List<ChiTietSanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<ChiTietSanPham> chiTietSanPhamList = session.createQuery("FROM ChiTietSanPham").list();
        session.close();
        return chiTietSanPhamList;
    }

    public ChiTietSanPham getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM ChiTietSanPham WHERE id=: id");
        query.setParameter("id", id);
        ChiTietSanPham ctsp = (ChiTietSanPham) query.getSingleResult();
        session.close();
        return ctsp;
    }

    public void addCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
