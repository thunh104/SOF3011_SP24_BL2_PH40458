package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.GioHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GioHangRepository {
    public List<GioHang> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<GioHang> gioHangList = session.createQuery("FROM GioHang").list();
        session.close();
        return gioHangList;
    }

    public GioHang getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM GioHang WHERE id=: id");
        query.setParameter("id", id);
        GioHang gh = (GioHang) query.getSingleResult();
        session.close();
        return gh;
    }

    public void addGH(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGH(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGH(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
