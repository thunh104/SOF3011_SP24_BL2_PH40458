package com.example.de_thi_thu_03.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgaySX")
    private Date ngaySX;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "Website")
    private String website;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuong")
    private Long soLuong;

    @Column(name = "IdLoaiSP")
    private Long idLoaiSP;

    @Column(name = "TrangThai")
    private Long trangThai;
}
