package org.example.movie_feedback.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dto.MovieDto;
import org.example.movie_feedback.service.MovieService;
import org.example.movie_feedback.service.implementations.MovieServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("{movieId}")
    public MovieDto getMovie(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }
    @PostMapping
    public HttpStatus createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return HttpStatus.CREATED;
    }

}
