package com.revature.movie.api.domain;

import java.util.List;

import com.revature.movie.api.entities.Dao;

/**
 * MovieService
 */
public class MovieService implements Service<Movie> {
    private Dao<Movie> dao;

    public MovieService(Dao<Movie> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Movie movie) {
        this.dao.insert(movie);
    }

    @Override
    public List<Movie> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}