package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.GioHangChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GioHangChiTietRepository {
    public List<GioHangChiTiet> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<GioHangChiTiet> gioHangChiTietList = session.createQuery("FROM GioHangChiTiet").list();
        session.close();
        return gioHangChiTietList;
    }

    public GioHangChiTiet getOne(Long idGioHang) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM GioHangChiTiet WHERE idGioHang=: idGioHang");
        query.setParameter("idGioHang", idGioHang);
        GioHangChiTiet ghct = (GioHangChiTiet) query.getSingleResult();
        session.close();
        return ghct;
    }

    public void addGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGHCT(GioHangChiTiet ghct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ghct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
