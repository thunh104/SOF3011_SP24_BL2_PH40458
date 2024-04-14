package com.example.de_thi_thu_01.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "Ban")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "SoThich")
    private String soThich;

    @Column(name = "GioiTinh")
    private Long gioiTinh;

    @Column(name = "IdMQH")
    private Long idMQH;

    @Column(name = "TrangThai")
    private Long trangThai;
}
