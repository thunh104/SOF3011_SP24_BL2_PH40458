package com.example.de_thi_thu_05.repository;

import com.example.de_thi_thu_05.config.HibernateConfig;
import com.example.de_thi_thu_05.entity.XeMay;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class XeMayRepository {
    public List<XeMay> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<XeMay> xeMayList = s.createQuery("FROM XeMay").list();
        s.close();
        return xeMayList;
    }

    public XeMay getOne(Long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM XeMay WHERE id =: id");
        q.setParameter("id", id);
        XeMay xm = (XeMay) q.getSingleResult();
        return xm;
    }

    public void addXM(XeMay xeMay) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.persist(xeMay);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateXM(XeMay xeMay) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.merge(xeMay);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteXM(XeMay xeMay) {
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            Transaction t = null;
            t = s.beginTransaction();
            s.delete(xeMay);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
