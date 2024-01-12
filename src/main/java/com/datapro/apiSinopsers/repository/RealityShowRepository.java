package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.RealityShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RealityShowRepository extends JpaRepository<RealityShow, Long>{

    @Query(value = "SELECT * from tb_realityshow WHERE id = ?1", nativeQuery = true)
    RealityShow buscarPorId(Long id);

    @Query(value = "SELECT titulo from tb_realityshow WHERE titulo = ?1", nativeQuery = true)
    String buscarPorTitulo(String titulo);
}
