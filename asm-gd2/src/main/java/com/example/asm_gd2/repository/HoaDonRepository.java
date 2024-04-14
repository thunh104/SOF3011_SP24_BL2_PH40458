package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HoaDonRepository {
    public List<HoaDon> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<HoaDon> hoaDonList = session.createQuery("FROM HoaDon").list();
        session.close();
        return hoaDonList;
    }

    public HoaDon getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM HoaDon WHERE id=: id");
        query.setParameter("id", id);
        HoaDon hd = (HoaDon) query.getSingleResult();
        session.close();
        return hd;
    }

    public void addHD(HoaDon hd) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHD(HoaDon hd) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHD(HoaDon hd) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
