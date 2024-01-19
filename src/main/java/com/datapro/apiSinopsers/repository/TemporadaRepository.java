package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemporadaRepository extends JpaRepository<Temporada, Long> {
    @Query(value = "SELECT titulo from tb_temporada WHERE titulo = ?1", nativeQuery = true)
    String buscarPorTitulo(String titulo);
    @Query(value = "SELECT * from tb_temporada WHERE cod_temporada = ?1", nativeQuery = true)
    Temporada buscarPorId(Long id);
    @Query(value = "SELECT * from tb_temporada WHERE cod_temporada = ?1", nativeQuery = true)
    Temporada buscarPorCodigo(Long codTemporada);
    @Query(value = "SELECT * from tb_temporada WHERE cod_realityshow = ?1", nativeQuery = true)
     List<Temporada> buscarPorCodRealityShow(Long codReality);
}
