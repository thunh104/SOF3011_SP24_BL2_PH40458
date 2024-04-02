package com.example.asm_gd2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHoaDon")
    private Long idHoaDon;

    @Column(name = "IdChiTietSP")
    private Long idCTSP;

    @Column(name = "SoLuong")
    private Long soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;
}
