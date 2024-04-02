package com.example.demobai1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SinhVien {
    private String mssv;

    private String ten;

    private int tuoi;

    private String diaChi;

    private boolean gioiTinh;

}
