package com.example.bai_tap_buoi_7.service;

import com.example.bai_tap_buoi_7.entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> listSanPham = new ArrayList<>();

    public SanPhamService() {
        listSanPham.add(new SanPham(1, "HangNT169", "Táo", "3", "Đực"));
        listSanPham.add(new SanPham(2, "NguyenVV4", "Cam", "3", "Đực"));
        listSanPham.add(new SanPham(3, "PhongTT35", "Sầu riêng", "5", "Miền nam"));
        listSanPham.add(new SanPham(4, "KhanhPG", "7", "3", "Bắc Giang"));
        listSanPham.add(new SanPham(5, "TienNH21", "Mít", "Cái", "Miền Bắc"));
    }

    public List<SanPham> getAll() {
        return listSanPham;
    }

    public void add(SanPham sp) {
        listSanPham.add(sp);
    }

    public void remove(String ma) {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMa().equals(ma)) {
                listSanPham.remove(i);
            }
        }
    }

    public SanPham detail(String ma){
        for(SanPham sp : listSanPham){
            if (sp.getMa().equals(ma)) {
                return sp;
            }
        }
        return null;
    }

    public void update(String ma, SanPham sp) {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMa().equalsIgnoreCase(ma)) {
                listSanPham.set(i, sp);
                return;
            }
        }
    }
}
