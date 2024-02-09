package com.example.graphql.graphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import com.example.graphql.graphqldemo.model.Movie;
import com.example.graphql.graphqldemo.service.MovieService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
// @RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    // create
    // @PostMapping("/create")
    @MutationMapping("createMovie")
    public Movie createMovie(@Argument Movie movie) {
        Movie m = new Movie();
        m.setTitle(movie.getTitle());
        m.setGenres(movie.getGenres());
        m.setYear(movie.getYear());

        return service.createMovie(m);
    }

    // getAll
    @QueryMapping("getAllMovies")
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    // getMovieById
    @QueryMapping("getMovieByID")
    public Movie getMovieByID(@Argument int id) {
        return service.getMovieById(id);
    }

    // deleteMovie
    @MutationMapping("deletedMovie")
    public void deletedMovie(@Argument int id) {
        service.deleteMovie(id);
    }

    // UpdateMovie
    @MutationMapping("updateMovie")
    public Movie updateMovie(@Argument int id, @Argument Movie movieInpute) {
        Movie movie = service.getMovieById(id);
        if (movie != null) {
            movie.setTitle(movieInpute.getTitle());
            movie.setGenres(movieInpute.getGenres());
            movie.setYear(movieInpute.getYear());
            service.updateMovie(movie);
        }
        return movie;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class MovieInpute

    {
        private String title;
        private String genres;
        private int year;
    }
}
