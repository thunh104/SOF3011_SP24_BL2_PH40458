package com.example.demo_lab_7_8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String ma;

    @Column
    private String ten;

    @Column
    private Long tuoi;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "lop_id")
    private Long lopId;
}
