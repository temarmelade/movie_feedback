package org.example.movie_feedback.service.implementations;

import org.example.movie_feedback.dto.MovieDto;
import org.example.movie_feedback.model.Director;
import org.example.movie_feedback.model.Movie;
import org.example.movie_feedback.service.MovieService;
import org.example.movie_feedback.util.FileUtil;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final List<Movie> movies;


    public MovieServiceImpl() {
        this.movies = new FileUtil().getMovies("movies.json");
    }
    @Override
    public List<MovieDto> getAllMovies() {
        return movies.stream()
                .map(e -> MovieDto.builder()
                        .id(e.getId())
                        .year(e.getYear())
                        .name(e.getName())
                        .description(e.getDescription())
                        .build())
                .toList();
    }
    @Override
    public MovieDto getMovieById(String movieId) {
        int id = Integer.parseInt(movieId);
        return movies.stream()
                .filter(e -> e.getId() == id)
                .map(e -> MovieDto.builder()
                        .id(e.getId())
                        .year(e.getYear())
                        .name(e.getName())
                        .description(e.getDescription())
                        .build())
                .findAny()
                .orElseThrow();
    }
    @Override
    public void createMovie(MovieDto movieDto) {
        movies.add(Movie.builder()
                        .description(movieDto.getDescription())
                        .year(movieDto.getYear())
                        .id(movieDto.getId())
                        .name(movieDto.getName())
                        .director(new Director())
                        .cast(new ArrayList<>())
                .build());
    }
}
