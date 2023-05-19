package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Director;
import org.example.entity.Film;
import org.example.repository.FilmRepository;

import java.util.List;

public class FilmRepositoryImpl extends BaseRepositoryImpl<Film,Long> implements FilmRepository {
    @Override
    public Class<Film> getEntityClass() {
        return Film.class;
    }


    @Override
    public List<Film> producedByDirector(Director x) {
      return   entityManager.createQuery("FROM Film film where film.director=? ",Film.class).setParameter(1,x).getResultList();
       // entityManager.createQuery("FROM Film film where film.director=:director  ",Film.class).setParameter("director",x).getResultList();

    }

    @Override
    public List<Film> getScoreMoreThanPoints(int rate) {
        return null;
    }

    @Override
    public Film getMaxLengthOfFilm() {
        return null;
    }

    @Override
    public Director getDirector(Film film) {
        return null;
    }
}
