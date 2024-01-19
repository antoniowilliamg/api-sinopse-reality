package com.datapro.apiSinopsers.dto;

import lombok.Data;

import java.util.List;

@Data
public class RealityShowDto {

    private Long cod_realityshow;

    private String titulo;

    private String sinopse;

    private List<TemporadaDto> temporadas;



}
