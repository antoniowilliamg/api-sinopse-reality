package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.TemporadaDto;
import com.datapro.apiSinopsers.model.RealityShow;
import com.datapro.apiSinopsers.model.Temporada;
import com.datapro.apiSinopsers.repository.RealityShowRepository;
import com.datapro.apiSinopsers.repository.TemporadaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemporadaService {

    @Autowired
    private TemporadaRepository temporadaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RealityShowRepository realityShowRepository;
    private static final String TEMPORADA_NAO_ENCONTRADA = "Temporada não encontrada";
    public ResponseEntity cadastrar(TemporadaDto temporadaDto) {
        String titulo = temporadaRepository.buscarPorTitulo(temporadaDto.getTitulo());
        RealityShow realityShow = realityShowRepository.buscarPorCodigo(temporadaDto.getCod_realityshow());
        if (titulo == null){
            Temporada temporada = modelMapper.map(temporadaDto, Temporada.class);
            temporada.setRealityShow(realityShow);
            temporadaRepository.save(temporada);
            return ResponseEntity.status(201).body("Temporada cadastrada com sucesso");
        }
        return ResponseEntity.status(409).body("Temporada ja cadastrada");
    }
    public List<TemporadaDto> listar() {
        List<Temporada> temporadas = temporadaRepository.buscarPorCodRealityShow(1L);
        List<TemporadaDto> listaTemporadas = new ArrayList<>();


        for (Temporada temporada : temporadas) {
            TemporadaDto temporadaDto = modelMapper.map(temporada, TemporadaDto.class);
            listaTemporadas.add(temporadaDto);
        }
        return listaTemporadas;
    }
    public ResponseEntity atualizar(TemporadaDto temporadaDto) {
        Temporada temporada = temporadaRepository.buscarPorId(temporadaDto.getCod_temporada());
        if (temporada != null) {
            temporada = modelMapper.map(temporadaDto, Temporada.class);
            temporadaRepository.save(temporada);
            return ResponseEntity.status(200).body("Realityshow atualizado com sucesso!");
        }
        return ResponseEntity.status(409).body(TEMPORADA_NAO_ENCONTRADA);
    }
    public ResponseEntity excluir(Long id) {
        Temporada temporada = temporadaRepository.buscarPorId(id);
        if (temporada != null){
            temporadaRepository.deleteById(id);
            return ResponseEntity.status(204).body("Realityshow deletado com sucesso!");
        }
        return ResponseEntity.status(409).body(TEMPORADA_NAO_ENCONTRADA);
    }
}




