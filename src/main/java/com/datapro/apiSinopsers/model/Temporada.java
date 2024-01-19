package com.datapro.apiSinopsers.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tb_temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_temporada")
    private Long cod_temporada;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episodio> episodios;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_realityshow", nullable = false)
    private RealityShow realityShow;

}
