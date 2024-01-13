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
    private ResponseEntity cadastrar(@RequestBody RealityShowDto realityShowDto) {
        return realityShowService.cadastrar(realityShowDto);
    }

    @GetMapping
    public List<RealityShowDto> listar() {
        return realityShowService.listar();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody RealityShowDto realityShowDto) {
        return realityShowService.atualizar(realityShowDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity excluir(@PathVariable Long id) {
        return realityShowService.excluir(id);
    }
}
