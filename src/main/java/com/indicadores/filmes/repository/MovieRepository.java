package com.indicadores.filmes.repository;

import com.indicadores.filmes.model.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	/**
     * Retorna uma lista de todos os filmes com a marcação 'winner' como verdadeira.
     *
     * @return Uma lista de filmes vencedores.
     */
    List<Movie> findAllByWinnerTrue();
}
