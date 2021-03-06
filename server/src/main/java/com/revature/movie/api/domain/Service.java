package com.revature.movie.api.domain;

import java.util.List;

/**
 * Service
 */
public interface Service<E> {
    void insert(E e);

    List<E> getAll();

    void update();

    void delete();
}