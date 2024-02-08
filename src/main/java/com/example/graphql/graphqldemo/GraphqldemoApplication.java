package com.example.graphql.graphqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.graphql.graphqldemo.model.Movie;
import com.example.graphql.graphqldemo.service.MovieService;

@SpringBootApplication
public class GraphqldemoApplication implements CommandLineRunner {
	@Autowired
	private MovieService mMovieService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqldemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Movie m = new Movie();
		m.setTitle("test");
		m.setGenres("comedy");
		m.setYear(2019);

		// movie 2
		Movie m2 = new Movie();
		m2.setTitle("test2");
		m2.setGenres("comedy2");
		m2.setYear(2019);

		this.mMovieService.createMovie(m);
		this.mMovieService.createMovie(m2);
	}

}
