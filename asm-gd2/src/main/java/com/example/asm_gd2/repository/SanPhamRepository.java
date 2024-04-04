package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<SanPham> sanPhamList = session.createQuery("FROM SanPham").list();
        session.close();
        return sanPhamList;
    }

    public SanPham getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM SanPham WHERE id=: id");
        query.setParameter("id", id);
        SanPham sp = (SanPham) query.getSingleResult();
        session.close();
        return sp;
    }

    public void addSP(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSP(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteSP(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
