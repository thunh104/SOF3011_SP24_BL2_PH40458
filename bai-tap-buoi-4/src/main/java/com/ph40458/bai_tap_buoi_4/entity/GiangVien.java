package com.ph40458.bai_tap_buoi_4.entity;

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
public class GiangVien {
    private String id;

    private String ma;

    private String ten;

    private int tuoi;

    private boolean gioiTinh;

    private String diaChi;

}
