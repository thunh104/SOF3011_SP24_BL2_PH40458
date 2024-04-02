package com.example.bai_tap_buoi_11.repository;

import com.example.bai_tap_buoi_11.config.HibernateConfig;
import com.example.bai_tap_buoi_11.entity.GiangVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class iGiangVienRepository {
    public List<GiangVien> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<GiangVien> giangVienList = session.createQuery("FROM GiangVien").list();
        session.close();
        return giangVienList;
    }

    public GiangVien getOne(String ma) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM GiangVien gv WHERE gv.ma =:ma");
        query.setParameter("ma", ma);
        GiangVien giangVien = (GiangVien) query.getSingleResult();
        session.close();
        return giangVien;
    }

    public void add(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(giangVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(giangVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(giangVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new GiangVienRepository().getAll());
    }
}
