package com.datapro.apiSinopsers.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_realityshow")
@Data
public class RealityShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    private  String titulo;

    @Column(length = 1000, nullable = false, unique = true)
    private String sinopse;

}
