package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.Director;
import org.example.entity.Film;

import java.util.List;

public interface FilmRepository extends BaseRepository<Film,Long> {
    //    Films produced by director X.
// Movies that have scored more than 9 points.
// The longest film.
    List<Film> producedByDirector(Director x);
    List<Film>  getScoreMoreThanPoints(int rate);
    Film getMaxLengthOfFilm();
    Director getDirector(Film film);
}
