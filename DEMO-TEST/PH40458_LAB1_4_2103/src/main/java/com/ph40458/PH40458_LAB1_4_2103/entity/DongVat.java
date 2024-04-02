package com.ph40458.PH40458_LAB1_4_2103.entity;

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
public class DongVat {
    private int id;

    private String ten;

    private int tuoi;

    private boolean gioiTinh;

    private double canNang;

    private String khuVuc;
}
