package com.example.demo_lab_01.repository;

import com.example.demo_lab_01.config.HibernateConfig;
import com.example.demo_lab_01.entity.NhanVien;
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

    public NhanVien getByID(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM NhanVien nv WHERE nv.id =: id");
        query.setParameter("id", id);
        NhanVien nv = (NhanVien) query.getSingleResult();
        session.close();
        return nv;
    }

    public void addNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
