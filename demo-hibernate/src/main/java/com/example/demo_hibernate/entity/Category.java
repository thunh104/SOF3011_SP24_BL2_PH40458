package com.example.demo_hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    //    J3: JDBC(Java Database Connection): Truy vấn trên SQL
//    J4: Hibernate
//    + C1: Truy vấn trên SQL
//    + C2: Truy vấn HQL(Hibernate Query Language) => Truy vấn trên thực thể (trên class)
//    J5: JPA
//    + C1: native query => Truy vấn trên SQL
//    + C2:
//    ORM (Object Relationship Mapping):
//    + Table
//    + Column:
//         + Khóa chính
//         + Khóa ngoại
//         + Cột bình thường trong column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;
}