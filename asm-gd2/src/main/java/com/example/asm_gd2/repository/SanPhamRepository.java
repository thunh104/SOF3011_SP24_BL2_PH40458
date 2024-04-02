package com.example.asm_gd2.repository;

import com.example.asm_gd2.config.HibernateConfig;
import com.example.asm_gd2.entity.SanPham;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    public List<SanPham> getAll(){
        Session session = HibernateConfig.getFACTORY().openSession();
        List<SanPham> sanPhamList = session.createQuery("FROM SanPham").list();
        session.close();
        return sanPhamList;
    }
}
