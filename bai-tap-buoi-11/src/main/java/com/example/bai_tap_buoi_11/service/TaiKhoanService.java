package com.example.bai_tap_buoi_11.service;

import com.example.bai_tap_buoi_11.entity.TaiKhoan;
import com.example.bai_tap_buoi_11.repository.GiangVienRepository;
import com.example.bai_tap_buoi_11.repository.TaiKhoanRepository;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanService {
    private List<TaiKhoan> taiKhoanList = new ArrayList<>();
    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepository.getAll();
    }

    public TaiKhoan detailTaiKhoan(String username) {
        return taiKhoanRepository.getOne(username);
    }

    public void addTaiKhoan(TaiKhoan taiKhoan) {
        taiKhoanRepository.add(taiKhoan);
    }

    public void updateGiangVien(TaiKhoan taiKhoan) {
        taiKhoanRepository.update(taiKhoan);
    }

    public void removeGiangVien(TaiKhoan taiKhoan) {
        taiKhoanRepository.delete(taiKhoan);
    }
}
