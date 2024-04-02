package com.example.BTVN12.repository;


import com.example.BTVN12.config.HibernateConfig;
import com.example.BTVN12.entity.Lop;
import com.example.BTVN12.entity.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

public class SinhVienRepository {
    private Session se;

    public SinhVienRepository() {
        se = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        List<SinhVien> sinhVienList = se.createQuery("from SinhVien ").list();
        return sinhVienList;
    }

    public SinhVien getOne(Long id) {
        String sql = "from SinhVien where id=:id";
        Query q = se.createQuery(sql);
        q.setParameter("id", id);
        return (SinhVien) q.getSingleResult();
    }

    public HashMap<String, String> add(SinhVien sv) {
        try {
            se.getTransaction().begin();
            se.persist(sv);
            se.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(SinhVien sv){
        try {
            se.getTransaction().begin();
            se.merge(sv);
            se.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void delete(SinhVien sv){
        try {
            se.getTransaction().begin();
            se.delete(sv);
            se.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
//  public  List<SinhVien> findTop3(String name){
//        List<SinhVien> newList = new ArrayList<>();
//        try {
//            Query query = se.createQuery("from SinhVien where ten=:ten order by tuoi asc ");
//            query.setParameter("ten",name);
//            query.setMaxResults(3);
//            newList = query.getResultList();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//      return newList;
//  }
    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getAll());
    }

}
