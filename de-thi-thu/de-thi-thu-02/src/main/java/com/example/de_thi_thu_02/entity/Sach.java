package com.example.de_thi_thu_02.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Sach")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgayXuatBan")
    private Date ngayXuatBan;

    @Column(name = "SoTrang")
    private Long soTrang;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "IdNXB")
    private Long idNXB;

    @Column(name = "TrangThai")
    private Long trangThai;
}
