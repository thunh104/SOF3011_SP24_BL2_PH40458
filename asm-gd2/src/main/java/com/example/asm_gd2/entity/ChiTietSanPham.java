package com.example.asm_gd2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietSP")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdSP")
    private Long idSP;

    @Column(name = "IdNsx")
    private Long idNSX;

    @Column(name = "IdMauSac")
    private Long idMauSac;

    @Column(name = "IdDongSP")
    private Long idDongSP;

    @Column(name = "NamBH")
    private Long namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Long soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;
}
