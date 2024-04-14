package com.example.de_thi_thu_03.repository;

import com.example.de_thi_thu_03.config.HibernateConfig;
import com.example.de_thi_thu_03.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<SanPham> sanPhamList = s.createQuery("FROM SanPham").list();
        s.close();
        return sanPhamList;
    }

    public SanPham getOne(Long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM SanPham WHERE id=:id");
        q.setParameter("id", id);
        SanPham sanPham = (SanPham) q.getSingleResult();
        return sanPham;
    }

    public void addSanPham(SanPham sanPham) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.persist(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSanPham(SanPham sanPham) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.merge(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPham(SanPham sanPham) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.delete(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
