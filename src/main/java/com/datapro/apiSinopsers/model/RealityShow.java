package com.datapro.apiSinopsers.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RealityShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 1000, nullable = false, unique = true)
    private String sinopse;


}
