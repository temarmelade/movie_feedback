package org.example.movie_feedback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Director director;
    private List<Cast> cast;
    @Override
    public String toString() {
        return String.format("%s, %d: %s.\n Режиссер: %s\nАктерский состав: %s", name, year, description, director, cast);
    }
}
