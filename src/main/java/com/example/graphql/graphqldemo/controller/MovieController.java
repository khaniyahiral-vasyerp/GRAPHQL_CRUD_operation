package com.example.graphql.graphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.graphql.graphqldemo.model.Movie;
import com.example.graphql.graphqldemo.service.MovieService;

import lombok.Getter;
import lombok.Setter;

@Controller
// @RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    // create
    // @PostMapping("/create")
    @MutationMapping("createMovie")
    public Movie createMovie(@Argument MovieInpute movie) {
        Movie m = new Movie();
        m.setTitle(movie.getTitle());
        m.setGenres(movie.getGenres());
        m.setYear(movie.getYear());

        return service.createMovie(m);
    }

    // getAll
    // @GetMapping
    @QueryMapping("getallMovie")
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    // @GetMapping("/{id}")
    @QueryMapping(" getMovie")
    public Movie getMovieById(@Argument int id) {
        return service.getMovieById(id);
    }

    // delete
    // @DeleteMapping("/delete/{id}")
    @MutationMapping("deleteMovie")
    public void deleteMovie(@PathVariable int id) {
        service.deleteMovie(id);
    }

    // update
    // @PutMapping("/update/{id}")
    @MutationMapping("updateMovie")
    public void updateMovie(@Argument int id, @Argument MovieInpute moviInpute) {
        Movie movie = service.getMovieById(id);
        if (movie != null) {
            movie.setTitle(moviInpute.getTitle());
            movie.setGenres(moviInpute.getGenres());
            movie.setYear(moviInpute.getYear());
            service.updateMovie(movie);
        }

    }

    @Getter
    @Setter
    class MovieInpute

    {
        private String title;
        private String genres;
        private int year;
    }
}