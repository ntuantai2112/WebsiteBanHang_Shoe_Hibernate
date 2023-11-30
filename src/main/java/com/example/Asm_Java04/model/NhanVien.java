package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "UserName")
    private String userName;

    @ManyToOne()
    @JoinColumn(
            name = "IdCH",
            referencedColumnName = "Id"
    )
    private CuaHang cuaHang;

//    @Column(name = "IdGuiBC")
//        private String idGuiBC;

    @ManyToOne()
    @JoinColumn(
            name = "IdCV",
            referencedColumnName = "Id"
    )
    private ChucVu cv;

    public NhanVien(String ma, String ho, String tenDem, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, Integer trangThai, CuaHang cuaHang, ChucVu cv) {
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.cuaHang = cuaHang;
        this.cv = cv;
    }

    public NhanVien(UUID id, String ma, String ho, String tenDem, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, Integer trangThai, CuaHang cuaHang, ChucVu cv) {
        this.id = id;
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.cuaHang = cuaHang;
        this.cv = cv;
    }
}
