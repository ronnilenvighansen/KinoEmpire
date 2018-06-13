package kino.model;

/**
 * Created by Ahmed Fadhel on 14-03-2017.
 */
public class TicketSale {

    private String movie_name;
    private String sale_date;
    private int id_ticketSale;
    private int reserved;
    private int sold;
    private int seat;
    private int row;
    private int phone_number;
    private double price;

    public TicketSale(double price, int sold, int reserved, String sale_date, String movie_name, int seat, int phone_number) {
        this.reserved = reserved;
        this.sold = sold;
        this.price = price;
        this.movie_name = movie_name;
        this.seat = seat;
        this.row = row;
        this.sale_date = sale_date;
        this.phone_number = phone_number;
    }

    public TicketSale() {

    }

    public TicketSale(int reserved, int sold, double price) {
        this.reserved = reserved;
        this.sold = sold;
        this.price = price;
    }

    public int getId_ticketSale() {
        return id_ticketSale;
    }

    public void setId_ticketSale(int id_ticketSale) {
        this.id_ticketSale = id_ticketSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }

    public int getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String toString () {

        return "TicketSale ID: " + id_ticketSale + " Reserved: " + reserved +
                " Sold: " + sold + " Price: " + price + " Movie: " + movie_name +
                " Screening Date: " + sale_date + " Phone Number: " + phone_number + " Seat: " + seat + "\n";

    }

}
