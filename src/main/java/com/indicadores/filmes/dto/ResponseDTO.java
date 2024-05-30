package com.indicadores.filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    @Builder.Default
    private List<ProducerResponseDTO> min = new ArrayList<>();
    @Builder.Default
    private List<ProducerResponseDTO> max = new ArrayList<>();

}