package com.example.bai_tap_buoi_6.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiangVien {
    private String maGV;

    private String ten;

    private int tuoi;

    private String queQuan;

}
