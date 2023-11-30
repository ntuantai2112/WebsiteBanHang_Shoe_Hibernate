package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "HinhAnh")
    private String hinhAnh;

    public SanPham(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public SanPham(String ma, String ten, String hinhAnh) {
        this.ma = ma;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
    }
}
