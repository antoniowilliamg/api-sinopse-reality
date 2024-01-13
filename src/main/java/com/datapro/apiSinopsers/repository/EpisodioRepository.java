package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
    @Query(value = "SELECT nome from tb_episodio WHERE nome = ?1", nativeQuery = true)
    String BuscarPorNome(String nome);
    @Query(value = "SELECT * from tb_episodio WHERE id = ?1", nativeQuery = true)
    Episodio buscarPorId(Long id);
    @Query(value = "SELECT nome from tb_episodio WHERE nome = ?1", nativeQuery = true)
    List<Episodio> findByNome(String nome);
}
