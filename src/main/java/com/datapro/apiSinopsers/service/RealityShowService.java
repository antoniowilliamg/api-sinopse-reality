package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.RealityShowDto;
import com.datapro.apiSinopsers.model.RealityShow;
import com.datapro.apiSinopsers.repository.RealityShowRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealityShowService {
    @Autowired
    private RealityShowRepository realityShowRepository;

    @Autowired
    private ModelMapper modelMapper;


    private static final String REALITY_NAO_ENCONTRADO = "Realityshow não encontrado!";

    public ResponseEntity cadastrar(RealityShowDto realityShowDto) {
        String titulo =  realityShowRepository.buscarPorTitulo(realityShowDto.getTitulo());
        if (titulo == null){
            RealityShow realityShow = modelMapper.map(realityShowDto, RealityShow.class);
            realityShowRepository.save(realityShow);
            return ResponseEntity.status(201).body("Realityshow cadastrado com sucesso!");
        }
        return ResponseEntity.status(409).body("Realityshow ja cadastrado!");
    }
    public List<RealityShowDto> listar() {
        List<RealityShow> realityShows = realityShowRepository.findAll();
        List<RealityShowDto> listaRealitys = new ArrayList<>();

        for (RealityShow realityShow : realityShows) {
            RealityShowDto realityShowDto = modelMapper.map(realityShow, RealityShowDto.class);
            listaRealitys.add(realityShowDto);
        }
        return listaRealitys;
    }
    public ResponseEntity atualizar(RealityShowDto realityShowDto){
        RealityShow realityShow = realityShowRepository.buscarPorCodigo(realityShowDto.getCod_realityshow());
        if (realityShow != null) {
            realityShow = modelMapper.map(realityShowDto, RealityShow.class);
            realityShowRepository.save(realityShow);
            return ResponseEntity.status(200).body("Realityshow atualizado com sucesso!");
        }
        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }
    public ResponseEntity excluir(Long cod_realityshow){
        RealityShow realityShow = realityShowRepository.buscarPorCodigo(cod_realityshow);
        if (realityShow != null){
            realityShowRepository.deleteById(cod_realityshow);
            return ResponseEntity.status(204).body("Realityshow deletado com sucesso!");
        }

        return ResponseEntity.status(409).body(REALITY_NAO_ENCONTRADO);
    }


}

