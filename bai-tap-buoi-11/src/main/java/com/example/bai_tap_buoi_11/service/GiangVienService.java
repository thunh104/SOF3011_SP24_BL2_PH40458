package com.example.bai_tap_buoi_11.service;

import com.example.bai_tap_buoi_11.entity.GiangVien;
import com.example.bai_tap_buoi_11.repository.GiangVienRepository;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> giangVienList = new ArrayList<>();
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.getAll();
    }

    public GiangVien detailGiangVien(String ma) {
        return giangVienRepository.getOne(ma);
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
