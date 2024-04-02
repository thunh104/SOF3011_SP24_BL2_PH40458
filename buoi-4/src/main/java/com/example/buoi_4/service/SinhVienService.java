package com.example.buoi_4.service;

import com.example.buoi_4.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        //Add đối tượng vào List
        listSinhVien.add(new SinhVien("HangNT169", "Nguyễn Thúy Hằng", 10, "Hà Nội", true));
        listSinhVien.add(new SinhVien("PhongTT35", "Trần Tuấn Phong", 11, "Hà Nội1", false));
        listSinhVien.add(new SinhVien("NguyenVV4", "Vũ Văn Nguyên", 12, "Hà Nội2", false));
        listSinhVien.add(new SinhVien("KhanhPG", "Phạm Gia Khánh", 13, "Hà Nội", false));
        listSinhVien.add(new SinhVien("TienNH21", "Nguyễn Hoàng Tiến", 14, "Hà Nội3", false));
        listSinhVien.add(new SinhVien("DungNA29", "Nguyễn Anh Dũng", 15, "Hà Nội4", false));
    }

    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    public void add(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public void remove(String mssv) {
        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equals(mssv)) {
                listSinhVien.remove(i);
            }
        }
    }

    public SinhVien detail(String mssv) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(mssv)) {
                return sv;
            }
        }
        return null;
    }

}
