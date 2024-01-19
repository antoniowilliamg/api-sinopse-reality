package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.RealityShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RealityShowRepository extends JpaRepository<RealityShow, Long>{
       @Query(value = "SELECT titulo from tb_realityshow WHERE titulo = ?1", nativeQuery = true)
    String buscarPorTitulo(String titulo);
    @Query(value = "SELECT * from tb_realityshow WHERE cod_realityshow = ?1", nativeQuery = true)
    RealityShow buscarPorCodigo(Long cod_realityshow);
}
