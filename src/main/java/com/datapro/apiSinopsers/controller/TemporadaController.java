package com.datapro.apiSinopsers.controller;

import com.datapro.apiSinopsers.dto.TemporadaDto;
import com.datapro.apiSinopsers.service.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaService temporadaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity cadastrar(@RequestBody TemporadaDto temporadaDto) {
        return temporadaService.cadastrar(temporadaDto);
    }

    @GetMapping
    public List<TemporadaDto> listar() {
        return temporadaService.listar();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody TemporadaDto temporadaDto) {
        return temporadaService.atualizar(temporadaDto);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity excluir(@PathVariable Long id) {
        return temporadaService.excluir(id);
    }


}
