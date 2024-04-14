package com.example.de_thi_thu_05.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "XeMay")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XeMay {
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

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuong")
    private Long soLuong;

    @Column(name = "Website")
    private String website;

    @Column(name = "IdLXM")
    private Long idLXM;

    @Column(name = "TrangThai")
    private Long trangThai;
}
