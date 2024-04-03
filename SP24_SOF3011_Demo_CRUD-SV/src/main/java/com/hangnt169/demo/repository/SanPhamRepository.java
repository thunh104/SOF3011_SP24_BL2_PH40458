package com.hangnt169.demo.repository;

import com.hangnt169.demo.entity.SanPham;
import com.hangnt169.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author hangnt169
 */
public class SanPhamRepository {

    private Session s;

    public SanPhamRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<SanPham> getAll() {
        return s.createQuery("FROM SanPham").getResultList();
    }

    public SanPham getOne(int id) {
        Query<SanPham> q = s.createQuery("FROM SanPham WHERE id=:id");
        q.setParameter(1, id);
        return q.getSingleResult();
    }

    public void addOrUpdate(SanPham sp) {
        try {
            s.getTransaction().begin();
            s.saveOrUpdate(sp);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(SanPham sp) {
        try {
            s.getTransaction().begin();
            s.delete(sp);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getAll());
    }
}
