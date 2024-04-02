package com.ph40458.bai_tap_buoi_4.service;

import com.ph40458.bai_tap_buoi_4.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> listGiangVien = new ArrayList<>();
    public GiangVienService(){
        listGiangVien.add(new GiangVien("1", "HangNT169", "Táo", 3, false, "Đồng bằng"));
        listGiangVien.add(new GiangVien("2", "NguyenVV4", "Cam", 4, false, "Trung du miền núi"));
        listGiangVien.add(new GiangVien("3", "PhongTT35", "Sầu riêng", 5, true, "Miền nam"));
        listGiangVien.add(new GiangVien("4", "KhanhPG", "Vải", 7, false, "Bắc Giang"));
        listGiangVien.add(new GiangVien("5", "TienNH21", "Mít", 10, true, "Miền Bắc"));
    }

    public List<GiangVien> getAll(){
        return listGiangVien;
    }

    public void add(GiangVien gv){
        listGiangVien.add(gv);
    }

    public void remove(String ma){
        for(int i = 0; i < listGiangVien.size(); i++){
            if (listGiangVien.get(i).getMa().equals(ma)) {
                listGiangVien.remove(i);
            }
        }
    }
}
