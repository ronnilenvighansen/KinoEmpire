package kino.dao;

import kino.model.Movie;
import kino.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronnilenvighansen on 17/03/2017.
 */
public class MovieDao implements MovieDaoInterface {

    private Connection connection;

    public MovieDao() {
        connection = SQLConnection.getConnection();
    }

    public void createMovie(String movieGenre, String movieName, int movieAge, String movieStartDate,
                            String movieEndDate, int movieLength, int active) {
        try {
            PreparedStatement prepstat = connection.prepareStatement(
                    "INSERT INTO movie(movieGenre, movieName, movieAge, movieStartDate, movieEndDate, movieLength, active) VALUES (?,?,?,?,?,?,?)");
            prepstat.setString(1, movieGenre);
            prepstat.setString(2, movieName);
            prepstat.setInt(3, movieAge);
            prepstat.setString(4, movieStartDate);
            prepstat.setString(5, movieEndDate);
            prepstat.setInt(6, movieLength);
            prepstat.setInt(7, active);
            prepstat.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMovie(int movieId) {
        try {
            PreparedStatement prepstat = connection.prepareStatement("DELETE FROM movie WHERE movieId = ?");
            prepstat.setInt(1, movieId);
            prepstat.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createMovieGenreName(String movieGenre, String movieName){
        try{
            PreparedStatement prepstat = connection.prepareStatement(
                    "INSERT INTO movie(movieGenre, movieName) VALUES (?,?)");
            prepstat.setString(1, movieGenre);
            prepstat.setString(2, movieName);
            prepstat.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void createMovieName(String movieName){
        try{
            PreparedStatement prepstat = connection.prepareStatement(
                    "INSERT INTO movie(movieName) VALUES (?)");
            prepstat.setString(1, movieName);
            prepstat.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateMovie(Movie movie) {

        try {
            PreparedStatement prepstat = connection.prepareStatement(("UPDATE movie SET movieGenre = ?, movieName = ?, movieAge" +
                    " = ?, movieStartDate = ?, movieEndDate = ?, movieLength = ?, active = ?"));
            prepstat.setString(1, movie.getMovieGenre());
            prepstat.setString(2, movie.getMovieName());
            prepstat.setInt(3, movie.getMovieAge());
            prepstat.setString(4, movie.getMovieStartDate());
            prepstat.setString(5, movie.getMovieEndDate());
            prepstat.setInt(6, movie.getMovieLength());
            prepstat.setInt(7, movie.getActive());
            prepstat.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Movie getMovieById(int movieId) {
        Movie movie = new Movie();
        try {
            PreparedStatement prepstat = connection.prepareStatement("SELECT * FROM movie WHERE movieId = ?");
            prepstat.setInt(1, movieId);
            ResultSet resultset = prepstat.executeQuery();

            // Uses a resultset of data retrieved from database and puts it into an Product object
            if (resultset.next()) {
                movie.setMovieGenre(resultset.getString(1));
                movie.setMovieName(resultset.getString(2));
                movie.setMovieAge(resultset.getInt(3));
                movie.setMovieId(resultset.getInt(4));
                movie.setMovieStartDate(resultset.getString(5));
                movie.setMovieEndDate(resultset.getString(6));
                movie.setMovieLength(resultset.getInt(7));
                movie.setActive(resultset.getInt(8));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<Movie>();
        int count = 0;
        try {
            PreparedStatement prepstat = connection.prepareStatement("SELECT * FROM movie");
            ResultSet resultset = prepstat.executeQuery();

            while (resultset.next()) {
                Movie movie = new Movie();
                movie.setMovieGenre(resultset.getString(1));
                movie.setMovieName(resultset.getString(2));
                movie.setMovieAge(resultset.getInt(3));
                movie.setMovieId(resultset.getInt(4));
                movie.setMovieStartDate(resultset.getString(5));
                movie.setMovieEndDate(resultset.getString(6));
                movie.setMovieLength(resultset.getInt(7));
                movie.setActive(resultset.getInt(8));
                movieList.add(count, movie);
                count++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return movieList;
    }
}