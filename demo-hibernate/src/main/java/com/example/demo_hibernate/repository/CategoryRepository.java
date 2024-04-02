package com.example.demo_hibernate.repository;

import com.example.demo_hibernate.config.HibernateConfig;
import com.example.demo_hibernate.entity.Category;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryRepository {
    // CRUD (Create, Read, Update, Delete)
    public List<Category> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Category> lists = session.createQuery("FROM Category").list();
        session.close();
        return lists;
    }

    // GET ONE
    public Category getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM Category c WHERE c.id =: id");
        query.setParameter(1, id);
        Category category = (Category) query.getSingleResult();
        session.close();
        return category;
    }

    // ADD
    public void add(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(category); //Hàm add
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(category); //Hàm delete
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(category); //Hàm update
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
