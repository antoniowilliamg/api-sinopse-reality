package com.datapro.apiSinopsers.dto;

import lombok.Data;

import java.util.List;
@Data
public class TemporadaDto {

    private Long cod_temporada;

    private String titulo;

    private String descricao;

    private List<EpisodioDto> episodios;

    private Long cod_realityshow;



}
