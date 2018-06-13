package kino.model;

import kino.dao.MovieDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave on 21/03/2017.
 */
public class MoviePlanning {

    private MovieDao movieDao;

    public MoviePlanning() {
        super();
        movieDao = new MovieDao();
    }

    public void setMovieAsActive(int movieID) {

        Movie mov = movieDao.getMovieById(movieID);

        movieDao.updateMovie(mov);
        mov.setActive(1);
    }

    public void setMovieAsInactive(int movieID) {

        Movie mov = movieDao.getMovieById(movieID);

        mov.setActive(0);
    }

    /** Get all movies from database sorted by active status, with parameters "active", "inactive". */
    public ArrayList<Movie> getMoviesByActive(String req) {

        List<Movie> listget = new ArrayList<>(movieDao.getAllMovies());

        ArrayList<Movie> listret = new ArrayList<>();

        if (req.equalsIgnoreCase("active")) {

            for (Movie movie : listget) {
                if (movie.getActive() == 1) {
                    listret.add(movie);
                }
            }
        }
        else if (req.equalsIgnoreCase("inactive")) {

            for (Movie movie : listget) {
                if (movie.getActive() == 0) {
                    listret.add(movie);
                }
            }
        }


        return listret;
    }


}


