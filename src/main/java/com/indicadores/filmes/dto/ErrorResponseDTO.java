package com.indicadores.filmes.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public class ErrorResponseDTO {

    private final HttpStatus status;
    private final List<String> errors;

    public ErrorResponseDTO(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ErrorResponseDTO(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Collections.singletonList(error);
    }

}
