package org.example.movie_feedback.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private String fullName;
    @Override
    public String toString() {
        return String.format("Режиссер: %s", fullName);
    }
}
