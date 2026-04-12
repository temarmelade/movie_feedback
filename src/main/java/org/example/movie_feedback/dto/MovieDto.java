package org.example.movie_feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.movie_feedback.model.Cast;
import org.example.movie_feedback.model.Director;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Director director;
    private List<Cast> cast;
}
