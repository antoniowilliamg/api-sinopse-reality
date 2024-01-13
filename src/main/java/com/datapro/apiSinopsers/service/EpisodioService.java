package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.EpisodioDto;
import com.datapro.apiSinopsers.model.Episodio;
import com.datapro.apiSinopsers.repository.EpisodioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodioService {
    @Autowired
    private EpisodioRepository episodioRepository;

    private static final String REALITY_NAO_ENCONTRADO = "Episodio não encontrado!";


    public ResponseEntity cadastrar(@RequestBody EpisodioDto episodioDto) {
        String nome = episodioRepository.BuscarPorNome(episodioDto.getNome());
        if (nome == null) {
            Episodio episodio = new Episodio();
            episodio.setNome(episodioDto.getNome());
            episodio.setDescricao(episodioDto.getDescricao());
            episodio.setNumeroDoEpisodio(episodioDto.getNumeroDoEpisodio());
            episodioRepository.save(episodio);
            return ResponseEntity.status(201).body("Realityshow cadastrado com sucesso!");
        }
        return ResponseEntity.status(409).body("Realityshow ja cadastrado seja mais criativo!");
    }

    public List<EpisodioDto> listar() {
        List<Episodio> Episodios = episodioRepository.findAll();
        List<EpisodioDto> listaEpisodios = new ArrayList<>();

        for (Episodio episodio : Episodios){
            EpisodioDto episodioDto = new EpisodioDto();
            episodioDto.setId(episodio.getId());
            episodioDto.setNome(episodio.getNome());
            episodioDto.setDescricao(episodio.getDescricao());
            episodioDto.setNumeroDoEpisodio(episodio.getNumeroDoEpisodio());
            listaEpisodios.add(episodioDto);
        }
        return listaEpisodios;
    }


    public ResponseEntity atualizar(EpisodioDto episodioDto) {

        Episodio episodio = episodioRepository.buscarPorId(episodioDto.getId());
        if (episodio != null) {
            episodio.setNome(episodioDto.getNome());
            episodio.setDescricao(episodioDto.getDescricao());
            episodio.setNumeroDoEpisodio(episodioDto.getNumeroDoEpisodio());
            episodioRepository.save(episodio);
            return ResponseEntity.status(200).body("Realityshow atualizado com sucesso!");
        }
        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }

    public ResponseEntity excluir(Long id) {
        Episodio episodio = episodioRepository.buscarPorId(id);
        if (episodio != null){
            episodioRepository.deleteById(id);
            return ResponseEntity.status(204).body("Episodio deletado com sucesso!");
        }

        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }
}


