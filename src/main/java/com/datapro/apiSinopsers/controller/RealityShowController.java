package com.datapro.apiSinopsers.controller;

import com.datapro.apiSinopsers.dto.RealityShowDto;
import com.datapro.apiSinopsers.service.RealityShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/realityshows")

public class RealityShowController {
    @Autowired
    private RealityShowService realityShowService;

    @PostMapping
    private void cadastrarReality(@RequestBody RealityShowDto realityShowDto) {
        realityShowService.cadastrarReality(realityShowDto);
    }
    @GetMapping
    public List<RealityShowDto>listarReality(){
        return realityShowService.listarRealityShow();
    }

    @PutMapping
    public void atualizarReality(@RequestBody RealityShowDto realityShowDto) {
        realityShowService.atualizarReality(realityShowDto);
    }

    @DeleteMapping("/{id}")
    public void excluirReality(@PathVariable Long id){
        realityShowService.excluirReality(id);
    }


}
