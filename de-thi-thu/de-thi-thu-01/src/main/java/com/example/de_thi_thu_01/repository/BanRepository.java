package com.example.de_thi_thu_01.repository;

import com.example.de_thi_thu_01.config.HibernateConfig;
import com.example.de_thi_thu_01.entity.Ban;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BanRepository {
    public List<Ban> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        List<Ban> banList = s.createQuery("FROM Ban").list();
        s.close();
        return banList;
    }

    public Ban getOne(long id) {
        Session s = HibernateConfig.getFACTORY().openSession();
        Query q = s.createQuery("FROM Ban b WHERE b.id=:id");
        q.setParameter("id", id);
        Ban ban = (Ban) q.getSingleResult();
        s.close();
        return ban;
    }

    public void addBan(Ban ban) {
        Transaction t = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            t = s.beginTransaction();
            s.persist(ban);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBan(Ban ban) {
        Transaction t = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            t = s.beginTransaction();
            s.merge(ban);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBan(Ban ban) {
        Transaction t = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            t = s.beginTransaction();
            s.delete(ban);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
