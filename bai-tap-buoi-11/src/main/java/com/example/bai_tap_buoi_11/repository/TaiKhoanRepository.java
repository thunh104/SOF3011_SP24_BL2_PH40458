package com.example.bai_tap_buoi_11.repository;

import com.example.bai_tap_buoi_11.config.HibernateConfig;
import com.example.bai_tap_buoi_11.entity.TaiKhoan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaiKhoanRepository {
    public List<TaiKhoan> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<TaiKhoan> taiKhoanList = session.createQuery("FROM TaiKhoan").list();
        session.close();
        return taiKhoanList;
    }

    public TaiKhoan getOne(String username) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM TaiKhoan tk WHERE tk.username =: username");
        query.setParameter(1, username);
        TaiKhoan taiKhoan = (TaiKhoan) query.getSingleResult();
        session.close();
        return taiKhoan;
    }

    public void add(TaiKhoan taiKhoan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(taiKhoan);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(TaiKhoan taiKhoan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(taiKhoan);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(TaiKhoan taiKhoan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(taiKhoan);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new TaiKhoanRepository().getAll());
    }
}
