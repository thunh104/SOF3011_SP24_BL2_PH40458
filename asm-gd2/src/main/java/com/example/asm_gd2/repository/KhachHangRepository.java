package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class KhachHangRepository {
    public List<KhachHang> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<KhachHang> khachHangList = session.createQuery("FROM KhachHang").list();
        session.close();
        return khachHangList;
    }

    public KhachHang getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM KhachHang WHERE id=: id");
        query.setParameter("id", id);
        KhachHang kh = (KhachHang) query.getSingleResult();
        session.close();
        return kh;
    }

    public void addKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
