package com.datapro.apiSinopsers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodioDto {

    private Long cod_episodio;

    private  String nome;

    private String descricao;

    private Integer numero;

    private Long cod_temporada;

    private TemporadaDto temporadaDto;

}
