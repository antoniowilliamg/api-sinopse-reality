package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.RealityShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RealityShowRepository extends JpaRepository<RealityShow, Long>{

    @Query(value = "SELECT * tb_realityshow WHERE id = ?1", nativeQuery = true)
    RealityShow buscarPorId(Long id);
}
