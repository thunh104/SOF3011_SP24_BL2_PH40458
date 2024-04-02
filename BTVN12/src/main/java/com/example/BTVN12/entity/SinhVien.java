package com.example.BTVN12.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "ma")

    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "tuoi")
    private int tuoi;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name="lop_id", referencedColumnName="id")
    private Lop lop;
    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}
