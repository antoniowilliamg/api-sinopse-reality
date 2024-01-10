package com.datapro.apiSinopsers.service;

import com.datapro.apiSinopsers.dto.RealityShowDto;
import com.datapro.apiSinopsers.model.RealityShow;
import com.datapro.apiSinopsers.repository.RealityShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealityShowService {
    @Autowired
    private RealityShowRepository realityShowRepository;

    public void cadastrarReality(RealityShowDto realityShowDto) {
        RealityShow realityShow = new RealityShow();
        realityShow.setNome(realityShowDto.getNome());
        realityShow.setSinopse(realityShowDto.getSinopse());
        realityShowRepository.save(realityShow);

    }

    public List<RealityShowDto> listarRealityShow(){
        List<RealityShow> realityShows = realityShowRepository.findAll();
        List<RealityShowDto> listaRealitys = new ArrayList<>();

        for (RealityShow realityShow : realityShows){
            RealityShowDto realityShowDto = new RealityShowDto();
            realityShowDto.setId(realityShow.getId());
            realityShowDto.setNome(realityShow.getNome());
            realityShowDto.setSinopse(realityShow.getSinopse());
            listaRealitys.add(realityShowDto);
        }
        return listaRealitys;
    }

    public void atualizarReality(RealityShowDto realityShowDto){
        RealityShow realityShow = realityShowRepository.buscarPorId(realityShowDto.getId());
        realityShow.setNome(realityShowDto.getNome());
        realityShow.setSinopse(realityShowDto.getSinopse());
        realityShowRepository.save(realityShow);
    }

    public void excluirReality(Long id){
        realityShowRepository.deleteById(id);
    }
}

