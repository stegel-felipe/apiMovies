package com.indicadores.filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProducerResponseDTO {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

}
