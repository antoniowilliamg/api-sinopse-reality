package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.EpisodioDto;
import com.datapro.apiSinopsers.model.Episodio;
import com.datapro.apiSinopsers.model.Temporada;
import com.datapro.apiSinopsers.repository.EpisodioRepository;
import com.datapro.apiSinopsers.repository.TemporadaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodioService {
    @Autowired
    private EpisodioRepository episodioRepository;
    @Autowired
    private TemporadaRepository temporadaRepository;
    @Autowired
    private ModelMapper modelMapper;

    private static final String EPISODIO_NAO_ENCONTRADO = "Episodio não encontrado!";

    public ResponseEntity cadastrar(EpisodioDto episodioDto) {
        String nome =  episodioRepository.buscarPorNome(episodioDto.getNome());
        Temporada temporada = temporadaRepository.buscarPorCodigo(episodioDto.getCod_temporada());
        if (nome == null){
            Episodio episodio = modelMapper.map(episodioDto, Episodio.class );
            episodio.setTemporada(temporada);
            episodioRepository.save(episodio);
            return ResponseEntity.status(201).body("Episodio cadastrado com sucesso!");
        }
        return ResponseEntity.status(409).body("Episodio ja cadastrado!");
    }
    public List<EpisodioDto> listar() {
        List<Episodio> episodios = episodioRepository.findAll();
        List<EpisodioDto> listaEpisodios = new ArrayList<>();

        for (Episodio episodio : episodios) {
            EpisodioDto episodioDto = modelMapper.map(episodio, EpisodioDto.class );
            listaEpisodios.add(episodioDto);
        }
        return listaEpisodios;
    }
    public ResponseEntity atualizar(EpisodioDto episodioDto){
        Episodio episodio = episodioRepository.buscarPorCodigo(episodioDto.getCod_episodio());
        if (episodio != null) {
            episodio = modelMapper.map(episodioDto, Episodio.class );
            episodioRepository.save(episodio);
            return ResponseEntity.status(200).body("Episodio atualizado com sucesso!");
        }
        return ResponseEntity.status(409).body(EPISODIO_NAO_ENCONTRADO);
    }
    public ResponseEntity excluir(Long cod_episodio){
        Episodio episodio = episodioRepository.buscarPorCodigo(cod_episodio);
        if (episodio != null){
            episodioRepository.deleteById(cod_episodio);
            return ResponseEntity.status(204).body("Episodio deletado com sucesso!");
        }

        return ResponseEntity.status(409).body(EPISODIO_NAO_ENCONTRADO);
    }

}

