package com.example.PH40458_LAB5_6_0406.repository;

import com.example.PH40458_LAB5_6_0406.config.HibernateConfig;
import com.example.PH40458_LAB5_6_0406.entity.SanPham;
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

    public SanPham getByID(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM SanPham sp WHERE sp.id =: id");
        query.setParameter("id", id);
        SanPham sanPham = (SanPham) query.getSingleResult();
        session.close();
        return sanPham;
    }

    public void addSanPham(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPham(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
