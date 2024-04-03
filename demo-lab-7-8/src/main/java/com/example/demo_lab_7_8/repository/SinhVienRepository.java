package com.example.demo_lab_7_8.repository;

import com.example.demo_lab_7_8.config.HibernateConfig;
import com.example.demo_lab_7_8.entity.SinhVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienRepository {
    public List<SinhVien> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<SinhVien> lists = s.createQuery("FROM SinhVien").list();
        s.close();
        return lists;
    }

    public SinhVien getOne(Long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM SinhVien WHERE id=:id");
        q.setParameter("id", id);
        SinhVien sv = (SinhVien) q.getSingleResult();
        return sv;
    }

    public void addSV(SinhVien sv) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction tra = null;
            tra = s.beginTransaction();
            s.persist(sv);
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSV(SinhVien sv) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction tra = null;
            tra = s.beginTransaction();
            s.merge(sv);
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSV(SinhVien sv) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction tra = null;
            tra = s.beginTransaction();
            s.delete(sv);
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
