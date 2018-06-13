package kino.model;

/**
 * Created by Ali on 14-03-2017.
 */
public class Movie {

    private String movieGenre;
    private String movieName;
    private String movieStartDate;
    private String movieEndDate;
    private int movieAge;
    private int movieId;
    private int movieLength;
    private int active;

    public Movie() {

    }

    public Movie(String movieName, String movieGenre) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
    }

    public Movie(String movieGenre, String movieName, int movieAge, int movieId,
                 String movieStartDate, String movieEndDate, int movieLength, int active) {
        this.movieGenre = movieGenre;
        this.movieName = movieName;
        this.movieAge = movieAge;
        this.movieId = movieId;
        this.movieStartDate = movieStartDate;
        this.movieEndDate = movieEndDate;
        this.movieLength = movieLength;
        this.active = active;
    }


    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieAge() {
        return movieAge;
    }

    public void setMovieAge(int movieAge) {
        this.movieAge = movieAge;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieStartDate() {
        return movieStartDate;
    }

    public void setMovieStartDate(String movieStartDate) {
        this.movieStartDate = movieStartDate;
    }

    public String getMovieEndDate() {
        return movieEndDate;
    }

    public void setMovieEndDate(String movieEndDate) {
        this.movieEndDate = movieEndDate;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Name: " + getMovieName() + "\nGenre: " + getMovieGenre() + "\nAge: " + getMovieAge() + "\nId: "
                + getMovieId() + "\nStart Date: " + getMovieStartDate() + "\n End Date: " + getMovieEndDate() +
                "\nLength: " + getMovieLength();
    }
}
