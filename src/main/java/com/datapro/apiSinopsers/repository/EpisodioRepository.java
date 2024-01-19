package com.datapro.apiSinopsers.repository;

import com.datapro.apiSinopsers.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    @Query(value = "SELECT nome from tb_episodio WHERE nome = ?1", nativeQuery = true)
    List<Episodio> findByNome(String nome);

    @Query(value = "SELECT * from tb_episodio WHERE cod_episodio = ?1", nativeQuery = true)
    Episodio buscarPorCodigo(Long cod_episodio);
    @Query(value = "SELECT * from tb_episodio WHERE numero = ?1", nativeQuery = true)
    Episodio buscarPorNumero(Long numero);
    @Query(value = "SELECT nome from tb_episodio WHERE nome = ?1", nativeQuery = true)
    String buscarPorNome(String nome);
}
