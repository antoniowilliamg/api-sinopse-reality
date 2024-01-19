package com.datapro.apiSinopsers.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_realityshow")
@Data
public class RealityShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_realityshow")
    private Long cod_realityshow;

    @Column(nullable = false, unique = true)
    private  String titulo;

    @Column(length = 1000, nullable = false, unique = true)
    private String sinopse;

    @OneToMany(mappedBy = "realityShow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Temporada> temporadas;
}
