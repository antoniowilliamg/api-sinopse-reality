package com.datapro.apiSinopsers.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_episodio")
@Data

public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_episodio")
    private Long cod_episodio;

    @Column(nullable = false, unique = true)
    private  String nome;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "cod_temporada", nullable = false)
    private Temporada temporada;


}

