package com.datapro.apiSinopsers.controller;

import com.datapro.apiSinopsers.dto.EpisodioDto;
import com.datapro.apiSinopsers.service.EpisodioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodios")
public class EpisodioController {

    @Autowired
    private EpisodioService episodioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity cadastrar(@RequestBody EpisodioDto episodioDto) {
        return episodioService.cadastrar(episodioDto);
    }

    @GetMapping
    public List<EpisodioDto> listar() {
        return episodioService.listar();
    }

    @PutMapping
    public ResponseEntity atualiza(@RequestBody EpisodioDto episodioDto) {
        return episodioService.atualizar(episodioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity excluir(@PathVariable Long id) {
        return episodioService.excluir(id);
    }

}