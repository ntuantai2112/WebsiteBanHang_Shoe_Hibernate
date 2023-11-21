package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {

    @Id
    @Column(name = "Id")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private UUID id;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhtoan;
    private Date ngayShip;
    private Date ngayNhan;
    private String tinhTrang;
    private String tenNguoinhan;
    private String diaChi;
    private String sdt;


}
