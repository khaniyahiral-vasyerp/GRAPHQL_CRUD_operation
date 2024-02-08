package com.example.graphql.graphqldemo.service;

import java.util.List;

import com.example.graphql.graphqldemo.model.Movie;

public interface MovieService {
    // cerates
    Movie createMovie(Movie movie);

    // updates
    Movie updateMovie(Movie movie);

    // get all movies
    List<Movie> getAllMovies();

    // gets a movie by id
    Movie getMovieById(int id);

    public void deleteMovie(int id);

}
