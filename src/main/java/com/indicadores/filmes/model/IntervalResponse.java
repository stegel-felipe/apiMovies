package com.indicadores.filmes.model;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
public class IntervalResponse {
	private List<Interval> min;
	private List<Interval> max;
	
	public IntervalResponse(List<Interval> min, List<Interval> max) {
        this.min = min;
        this.max = max;
    }
}
