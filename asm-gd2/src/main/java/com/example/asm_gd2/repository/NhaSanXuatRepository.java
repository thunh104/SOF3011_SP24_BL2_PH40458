package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.NhaSanXuat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NhaSanXuatRepository {
    public List<NhaSanXuat> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<NhaSanXuat> nhaSanXuatList = session.createQuery("FROM NhaSanXuat").list();
        session.close();
        return nhaSanXuatList;
    }

    public NhaSanXuat getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM NhaSanXuat WHERE id=: id");
        query.setParameter("id", id);
        NhaSanXuat nsx = (NhaSanXuat) query.getSingleResult();
        session.close();
        return nsx;
    }

    public void addNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
