package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.DongSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DongSanPhamRepository {
    public List<DongSanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<DongSanPham> gioHangList = session.createQuery("FROM DongSanPham").list();
        session.close();
        return gioHangList;
    }

    public DongSanPham getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM DongSanPham WHERE id=: id");
        query.setParameter("id", id);
        DongSanPham dsp = (DongSanPham) query.getSingleResult();
        session.close();
        return dsp;
    }

    public void addDSP(DongSanPham dsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDSP(DongSanPham dsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDSP(DongSanPham dsp) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
