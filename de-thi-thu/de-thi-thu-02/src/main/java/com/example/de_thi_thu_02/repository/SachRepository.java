package com.example.de_thi_thu_02.repository;

import com.example.de_thi_thu_02.config.HibernateConfig;
import com.example.de_thi_thu_02.entity.Sach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SachRepository {
    public List<Sach> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<Sach> sachList = s.createQuery("FROM Sach").list();
        s.close();
        return sachList;
    }

    public Sach getOne(Long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM Sach WHERE id=:id");
        q.setParameter("id", id);
        Sach sach = (Sach) q.getSingleResult();
        s.close();
        return sach;
    }

    public void addSach(Sach sach) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.persist(sach);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSach(Sach sach) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.update(sach);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deteleSach(Sach sach) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.delete(sach);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
