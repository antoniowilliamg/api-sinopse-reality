package com.datapro.apiSinopsers.controller;

import com.datapro.apiSinopsers.dto.RealityShowDto;
import com.datapro.apiSinopsers.service.RealityShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/realityshows")
public class RealityShowController {
    @Autowired
    private RealityShowService realityShowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity cadastrarReality(@RequestBody RealityShowDto realityShowDto) {
        return realityShowService.cadastrarReality(realityShowDto);
    }

    @GetMapping
    public List<RealityShowDto> listarReality() {
        return realityShowService.listarRealityShow();
    }

    @PutMapping
    public ResponseEntity atualizarReality(@RequestBody RealityShowDto realityShowDto) {
        return realityShowService.atualizarReality(realityShowDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity excluirReality(@PathVariable Long id) {
        return realityShowService.excluirReality(id);
    }
}
