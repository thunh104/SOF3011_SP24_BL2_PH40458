package com.example.PH40458_LAB7_8_2129.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "chiTietSanPham")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCTSP")
    private Long idCTSP;

    @Column(name = "idSanPham")
    private Long idSP;

    @Column(name = "idThuongHieu")
    private Long idThuongHieu;

    @Column(name = "idKhoiLuong")
    private Long idKhoiLuong;

    @Column(name = "idDonViTinh")
    private Long idDonViTinh;

    @Column(name = "idXuatXu")
    private Long idXuatXu;

    @Column(name = "idChatLieu")
    private Long idChatLieu;

    @Column(name = "idLoaiSanPham")
    private Long idLoaiSP;

    @Column(name = "soLuongTon")
    private Long soLuongTon;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "barcode")
    private String barCode;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "createdAt")
    private Date createAt;

    @Column(name = "createdBy")
    private Long createBy;

    @Column(name = "updatedAt")
    private Date updateAt;

    @Column(name = "updatedBy")
    private Long updateBy;

    @Column(name = "deleted")
    private Boolean deleted;
}
