package org.example.movie_feedback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cast {
    private String fullName;
    private String role;
    @Override
    public String toString() {
        return String.format("%s в роли %s", fullName, role);
    }
}
