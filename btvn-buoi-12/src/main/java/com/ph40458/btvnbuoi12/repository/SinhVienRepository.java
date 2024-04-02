package com.ph40458.btvnbuoi12.repository;


import com.ph40458.btvnbuoi12.config.HibernateConfig;
import com.ph40458.btvnbuoi12.entity.SinhVien;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class SinhVienRepository {
    public List<SinhVien> getALl() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<SinhVien> sinhVienList = session.createQuery("FROM SinhVien").list();
        session.close();
        return sinhVienList;
    }

    public SinhVien getByMa(long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM SinhVien sv WHERE sv.id=:id");
        query.setParameter("id", id);
        SinhVien sv = (SinhVien) query.getSingleResult();
        session.close();
        return sv;
    }

    public void addSinhVien(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session s = HibernateConfig.getFACTORY().openSession();) {
            transaction = s.beginTransaction();
            s.persist(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateSinhVien(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSinhVien(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getALl());
    }
}

