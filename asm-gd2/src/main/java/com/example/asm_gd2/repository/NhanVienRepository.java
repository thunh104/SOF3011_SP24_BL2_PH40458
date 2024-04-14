package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<NhanVien> nhanVienList = session.createQuery("FROM NhanVien").list();
        session.close();
        return nhanVienList;
    }

    public NhanVien getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM NhanVien WHERE id=: id");
        query.setParameter("id", id);
        NhanVien nv = (NhanVien) query.getSingleResult();
        session.close();
        return nv;
    }

    public void addNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void upadateNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
