package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DongSP {
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

    public DongSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }


}
