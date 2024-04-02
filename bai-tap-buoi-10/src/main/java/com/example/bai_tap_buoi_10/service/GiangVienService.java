package com.example.bai_tap_buoi_10.service;

import com.example.bai_tap_buoi_10.entity.GiangVien;
import com.example.bai_tap_buoi_10.repository.GiangVienRepository;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> giangVienList = new ArrayList<>();
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.getAll();
    }

    public GiangVien detailGiangVien(String mssv) {
        return giangVienRepository.getOne(mssv);
    }

    public void addGiangVien(GiangVien giangVien) {
        giangVienRepository.add(giangVien);
    }

    public void updateGiangVien(GiangVien giangVien) {
        giangVienRepository.update(giangVien);
    }

    public void removeGiangVien(GiangVien giangVien) {
        giangVienRepository.delete(giangVien);
    }
}
