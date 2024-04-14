package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CuaHangRepository {
    public List<CuaHang> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<CuaHang> gioHangList = session.createQuery("FROM CuaHang").list();
        session.close();
        return gioHangList;
    }

    public CuaHang getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM CuaHang WHERE id=: id");
        query.setParameter("id", id);
        CuaHang ch = (CuaHang) query.getSingleResult();
        session.close();
        return ch;
    }

    public void addCH(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCH(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCH(CuaHang ch) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
