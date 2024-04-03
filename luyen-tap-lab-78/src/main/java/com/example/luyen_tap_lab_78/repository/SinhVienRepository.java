package com.example.luyen_tap_lab_78.repository;

import com.example.luyen_tap_lab_78.config.HibernateConfig;
import com.example.luyen_tap_lab_78.entity.SinhVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienRepository {
    public List<SinhVien> getAll(){
        Session session = HibernateConfig.getFACTORY().openSession();
        List<SinhVien> listsv = session.createQuery("FROM SinhVien").list();
        session.close();
        return listsv;
    }

    public SinhVien getById(Long id){
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM SinhVien sv WHERE sv.id =: id");
        query.setParameter("id", id);
        SinhVien sinhVien = (SinhVien) query.getSingleResult();
        session.close();
        return sinhVien;
    }

    public void addSinhVien(SinhVien sinhVien){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sinhVien);
            transaction.commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateSinhVien(SinhVien sinhVien){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sinhVien);
            transaction.commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteSinhVien(SinhVien sinhVien){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
