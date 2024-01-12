package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.RealityShowDto;
import com.datapro.apiSinopsers.model.RealityShow;
import com.datapro.apiSinopsers.repository.RealityShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealityShowService {
    @Autowired
    private RealityShowRepository realityShowRepository;

    private static final String REALITY_NAO_ENCONTRADO = "Realityshow não encontrado!";

    public ResponseEntity cadastrarReality(RealityShowDto realityShowDto) {
        String titulo =  realityShowRepository.buscarPorTitulo(realityShowDto.getTitulo());
        if (titulo == null){
            RealityShow realityShow = new RealityShow();
            realityShow.setTitulo(realityShowDto.getTitulo());
            realityShow.setSinopse(realityShowDto.getSinopse());
            realityShowRepository.save(realityShow);
            return ResponseEntity.status(201).body("Realityshow cadastrado com sucesso!");
        }
       return ResponseEntity.status(409).body("Realityshow ja cadastrado seja mais criativo!");
    }


    public List<RealityShowDto> listarRealityShow(){
        List<RealityShow> realityShows = realityShowRepository.findAll();
        List<RealityShowDto> listaRealitys = new ArrayList<>();

        for (RealityShow realityShow : realityShows){
            RealityShowDto realityShowDto = new RealityShowDto();
            realityShowDto.setId(realityShow.getId());
            realityShowDto.setTitulo(realityShow.getTitulo());
            realityShowDto.setSinopse(realityShow.getSinopse());
            listaRealitys.add(realityShowDto);
        }
        return listaRealitys;
    }

    public ResponseEntity atualizarReality(RealityShowDto realityShowDto){

        RealityShow realityShow = realityShowRepository.buscarPorId(realityShowDto.getId());
        if (realityShow != null) {
            realityShow.setTitulo(realityShowDto.getTitulo());
            realityShow.setSinopse(realityShowDto.getSinopse());
            realityShowRepository.save(realityShow);
            return ResponseEntity.status(200).body("Realityshow atualizado com sucesso!");
        }
        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }

    public ResponseEntity excluirReality(Long id){
        RealityShow realityShow = realityShowRepository.buscarPorId(id);
        if (realityShow != null){
            realityShowRepository.deleteById(id);
            return ResponseEntity.status(204).body("Realityshow deletado com sucesso!");
        }

        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }

}

