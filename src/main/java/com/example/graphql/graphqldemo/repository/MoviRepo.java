package com.example.graphql.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.graphqldemo.model.Movie;

public interface MoviRepo extends JpaRepository<Movie, Integer> {

}
