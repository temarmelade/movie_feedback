package org.example.movie_feedback.service;

import org.example.movie_feedback.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(String id);

    void createMovie(MovieDto movieDto);
}
