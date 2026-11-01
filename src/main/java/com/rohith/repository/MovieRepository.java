package com.rohith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohith.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
