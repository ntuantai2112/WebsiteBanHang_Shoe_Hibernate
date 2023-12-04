package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSanPham;
    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    public ChiTietSanPham(SanPham sanPham, NSX nhaSanXuat, MauSac mauSac, DongSP dongSanPham, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.sanPham = sanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.dongSanPham = dongSanPham;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }
}
