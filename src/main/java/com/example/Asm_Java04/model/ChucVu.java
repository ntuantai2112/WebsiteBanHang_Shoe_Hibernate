package com.example.Asm_Java04.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    private String Ma;
    private String Ten;

}



