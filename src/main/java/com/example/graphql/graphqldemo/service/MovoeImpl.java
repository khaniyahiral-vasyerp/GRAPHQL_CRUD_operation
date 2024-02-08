package com.example.graphql.graphqldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.graphqldemo.model.Movie;
import com.example.graphql.graphqldemo.repository.MoviRepo;

@Service
public class MovoeImpl implements MovieService {
    private MoviRepo movvieRepo;

    @Autowired
    public MovoeImpl(MoviRepo movvieRepo) {
        this.movvieRepo = movvieRepo;
    }

    @Override
    public Movie createMovie(Movie movie) {
        // TODO Auto-generated method stub

        return (Movie) movvieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        // TODO Auto-generated method stub
        movie.setTitle(movie.getTitle());
        movie.setGenres(movie.getGenres());
        movie.setYear(movie.getYear());
        return movvieRepo.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        // TODO Auto-generated method stub
        return (List<Movie>) this.movvieRepo.findAll();
    }

    @Override
    public Movie getMovieById(int id) {
        // TODO Auto-generated method stub
        return (Movie) this.movvieRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteMovie(int id) {
        // TODO Auto-generated method stub
        movvieRepo.deleteById(id);//
    }

}
