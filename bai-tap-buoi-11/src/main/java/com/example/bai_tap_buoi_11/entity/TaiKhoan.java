package com.example.bai_tap_buoi_11.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
