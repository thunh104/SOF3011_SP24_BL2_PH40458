package com.example.de_thi_thu_04.repository;

import com.example.de_thi_thu_04.config.HibernateConfig;
import com.example.de_thi_thu_04.entity.NhanVien;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<NhanVien> nhanVienList = s.createQuery("FROM NhanVien").list();
        s.close();
        return nhanVienList;
    }

    public NhanVien getOne(Long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM NhanVien WHERE id =: id");
        q.setParameter("id", id);
        NhanVien nhanVien = (NhanVien) q.getSingleResult();
        s.close();
        return nhanVien;
    }

    public void addNV(NhanVien nhanVien) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.persist(nhanVien);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNV(NhanVien nhanVien) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.merge(nhanVien);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNV(NhanVien nhanVien) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.delete(nhanVien);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
