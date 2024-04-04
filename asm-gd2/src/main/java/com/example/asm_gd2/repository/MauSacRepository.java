package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MauSacRepository {
    public List<MauSac> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<MauSac> mauSacList = session.createQuery("FROM MauSac").list();
        session.close();
        return mauSacList;
    }

    public MauSac getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM MauSac WHERE id=: id");
        query.setParameter("id", id);
        MauSac ms = (MauSac) query.getSingleResult();
        session.close();
        return ms;
    }

    public void addMS(MauSac ms) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMS(MauSac ms) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMS(MauSac ms) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
