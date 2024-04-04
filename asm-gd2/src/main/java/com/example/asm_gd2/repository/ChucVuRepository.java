package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<ChucVu> chucVuList = session.createQuery("FROM ChucVu").list();
        session.close();
        return chucVuList;
    }

    public ChucVu getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM ChucVu WHERE id=: id");
        query.setParameter("id", id);
        ChucVu cv = (ChucVu) query.getSingleResult();
        session.close();
        return cv;
    }

    public void addCV(ChucVu cv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCV(ChucVu cv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteCV(ChucVu cv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
