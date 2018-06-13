package kino.model;

/**
 * Created by Ali on 14-03-2017.
 */

public class Theater {

    private int theaterNumber =0;
    private int rows = 0;
    private int seats = 0;
    private int id;

    public Theater(int theaterNumber, int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.theaterNumber = theaterNumber;
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }


    @Override
    public String toString() {
        return "theaterClass{" +
                "rows=" + rows + ", seats=" + seats + ", id=" + id +
                '}';
    }
}
