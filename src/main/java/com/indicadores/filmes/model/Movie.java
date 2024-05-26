package com.indicadores.filmes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private Long id;
	
	@Column(name = "\"YEAR\"")
	private Integer year;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "STUDIOS")
	private String studios;
	
	@Column(name = "PRODUCERS")
	private String producers;

	@Column(name = "WINNER")
	@JsonProperty("winner")
	private Boolean winner;
	
	public boolean isWinner() {
        return winner;
    }

}
