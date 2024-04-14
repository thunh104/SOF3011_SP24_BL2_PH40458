package com.example.de_thi_thu_05.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LoaiXM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoaiXeMay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
}
