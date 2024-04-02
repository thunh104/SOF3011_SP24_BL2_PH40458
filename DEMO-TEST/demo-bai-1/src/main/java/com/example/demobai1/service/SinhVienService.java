package com.example.demobai1.service;

import com.example.demobai1.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listsv = new ArrayList<>();

    public SinhVienService() {
        listsv.add(new SinhVien("HangNT169", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listsv.add(new SinhVien("PhongTT35", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listsv.add(new SinhVien("NguyenVV4", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listsv.add(new SinhVien("KhanhPG", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listsv.add(new SinhVien("TienNH21", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listsv.add(new SinhVien("DungNA29", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
    }

    public List<SinhVien> getAll() {
        return listsv;
    }

    public void add(SinhVien sv) {
        listsv.add(sv);
    }

    public void remove(String mssv) {
        for (int i = 0; i < listsv.size(); i++) {
            if (listsv.get(i).getMssv().equals(mssv)) {
                listsv.remove(i);
            }
        }
    }
}
