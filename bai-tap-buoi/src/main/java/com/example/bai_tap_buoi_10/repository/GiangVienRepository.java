package com.example.bai_tap_buoi_10.repository;

import com.example.bai_tap_buoi_10.config.HibernateConfig;
import com.example.bai_tap_buoi_10.entity.GiangVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GiangVienRepository {
    public List<GiangVien> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<GiangVien> lists = session.createQuery("FROM GiangVien").list();
        session.close();
        return lists;
    }

    public GiangVien getOne(String mssv) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM GiangVien gv WHERE gv.mssv =: mssv");
        query.setParameter("mssv", mssv);
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
