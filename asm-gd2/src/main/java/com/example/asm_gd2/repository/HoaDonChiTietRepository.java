package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HoaDonChiTietRepository {
    public List<HoaDonChiTiet> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<HoaDonChiTiet> hoaDonChiTietList = session.createQuery("FROM HoaDonChiTiet").list();
        session.close();
        return hoaDonChiTietList;
    }

    public HoaDonChiTiet getOne(Long idHoaDon) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM HoaDonChiTiet WHERE idHoaDon=: idHoaDon");
        query.setParameter("idHoaDon", idHoaDon);
        HoaDonChiTiet kh = (HoaDonChiTiet) query.getSingleResult();
        session.close();
        return kh;
    }

    public void addHDCT(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHDCT(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHDCT(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
