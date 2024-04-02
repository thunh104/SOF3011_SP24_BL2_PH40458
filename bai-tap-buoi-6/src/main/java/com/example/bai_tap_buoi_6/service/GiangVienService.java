package com.example.bai_tap_buoi_6.service;

import com.example.bai_tap_buoi_6.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> listGiangVien = new ArrayList<>();

    public GiangVienService() {
        listGiangVien.add(new GiangVien("anv1", "Nguyen Van A", 23, "Ha Noi"));
        listGiangVien.add(new GiangVien("anv2", "Nguyen Van A", 24, "Ha Noi"));
        listGiangVien.add(new GiangVien("anv3", "Nguyen Van A", 30, "Ha Noi"));
        listGiangVien.add(new GiangVien("anv4", "Nguyen Van A", 32, "Ha Noi"));
        listGiangVien.add(new GiangVien("anv5", "Nguyen Van A", 25, "Ha Noi"));
    }

    public List<GiangVien> getAll() {
        return listGiangVien;
    }

    public void add(GiangVien gv) {
        listGiangVien.add(gv);
    }

    public void remove(String maGV) {
        for (int i = 0; i < listGiangVien.size(); i++) {
            if (listGiangVien.get(i).getMaGV().equals(maGV)) {
                listGiangVien.remove(i);
            }
        }
    }

    public GiangVien detail(String maGV) {
        for (GiangVien gv : listGiangVien) {
            if (gv.getMaGV().equalsIgnoreCase(maGV)) {
                return gv;
            }
        }
        return null;
    }

    public void update(String maGV, GiangVien gv) {
        for (int i = 0; i < listGiangVien.size(); i++) {
            if (listGiangVien.get(i).getMaGV().equalsIgnoreCase(maGV)) {
                listGiangVien.set(i, gv);
                return;
            }
        }
    }
}
