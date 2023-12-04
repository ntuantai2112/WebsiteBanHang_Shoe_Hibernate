package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(HoaDonChiTietId.class)
@Entity
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;
}
