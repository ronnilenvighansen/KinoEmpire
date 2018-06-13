package kino.dao;


import kino.model.TicketSale;
import kino.utility.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave on 17/03/2017.
 */
public class DaoTicketSale implements DaoTicketSale_Interface {

    private Connection conn;

    public DaoTicketSale() {
        conn = SQLConnection.getConnection();
    }

    /**
     * creating TicketSale object in Database, with int as parameter to check if sold or reserved
     */
    public void createTicketSaleParam(TicketSale ticketSale, int sale_status) {

        try {
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO ticketsale(price, sold, reserved, sale_date, movie_name, seat, phone_number) VALUES (? ,? ,?, ?, ?, ?, ?)");

            if (sale_status == 0) {
                prepStat.setDouble(1, ticketSale.getPrice());
                prepStat.setInt(2, 1);
                prepStat.setInt(3, ticketSale.getReserved());
                prepStat.setString(4, ticketSale.getSale_date());
                prepStat.setString(5, ticketSale.getMovie_name());
                prepStat.setInt(6, ticketSale.getSeat());
                prepStat.setInt(7, ticketSale.getPhone_number());

            } else if (sale_status == 1) {
                prepStat.setDouble(1, ticketSale.getPrice());
                prepStat.setInt(2, ticketSale.getSold());
                prepStat.setInt(3, 1);
                prepStat.setString(4, ticketSale.getSale_date());
                prepStat.setString(5, ticketSale.getMovie_name());
                prepStat.setInt(6, ticketSale.getSeat());
                prepStat.setInt(7, ticketSale.getPhone_number());

            } else if (sale_status > 1) {
                throw new IllegalArgumentException("Error in parameter, must be 0 or 1");
            }
            prepStat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Create TicketSale object in Database
     */
    public void createTicketSale(TicketSale ticketSale) {

        try {
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO ticketsale(price, sold, reserved, sale_date, movie_name, seat, phone_number) VALUES (? ,? ,?, ?, ?, ?, ?)");

            prepStat.setDouble(1, ticketSale.getPrice());
            prepStat.setInt(2, ticketSale.getSold());
            prepStat.setInt(3, ticketSale.getReserved());
            prepStat.setString(4, ticketSale.getSale_date());
            prepStat.setString(5, ticketSale.getMovie_name());
            prepStat.setInt(6, ticketSale.getSeat());
            prepStat.setInt(7, ticketSale.getPhone_number());
            prepStat.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads TicketSale object from Database
     */
    public void getTicketSale(int id_ticketSale) {

        try {
            PreparedStatement prepStat = conn.prepareStatement("SELECT FROM ticketsale WHERE id_ticketSale = ?");

            prepStat.setInt(1, id_ticketSale);
            prepStat.executeUpdate();

            TicketSale ticketSale = new TicketSale();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Update TicketSale object in Database
     */
    public void updateTicketSale(TicketSale ticketSale) {
        try {
            PreparedStatement prepStat = conn.prepareStatement("UPDATE ticketsale SET price = ?, sold = ?, reserved = ?, sale_date = ?, movie_name = ?, seat = ?, phone_number = ?" + "WHERE ticket_id = ?");

            prepStat.setDouble(1, ticketSale.getPrice());
            prepStat.setInt(2, ticketSale.getSold());
            prepStat.setInt(3, ticketSale.getReserved());
            prepStat.setString(4, ticketSale.getSale_date());
            prepStat.setString(5, ticketSale.getMovie_name());
            prepStat.setInt(6, ticketSale.getSeat());
            prepStat.setInt(7, ticketSale.getPhone_number());
            prepStat.setInt(8, ticketSale.getId_ticketSale());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Delete TicketSale object from database, checking by id_ticket
     */
    public void removeTicketSale(int id_ticketSale) {

        try {
            PreparedStatement prepStat = conn.prepareStatement("DELETE FROM ticketsale WHERE id_ticketSale = ?");

            prepStat.setInt(1, id_ticketSale);
            prepStat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<TicketSale> findTickets(int phoneNumber) {

        List tickets = new ArrayList<TicketSale>();
        try {
            PreparedStatement prepstat = conn.prepareStatement("SELECT * FROM ticketsale WHERE phone_number = ?");
            prepstat.setInt(1, phoneNumber);
            ResultSet resultset = prepstat.executeQuery();

            if (resultset.next()) {
                TicketSale ticket = new TicketSale();
                ticket.setId_ticketSale(resultset.getInt(1));
                ticket.setPrice(resultset.getInt(2));
                ticket.setSold(resultset.getInt(3));
                ticket.setReserved(resultset.getInt(4));
                ticket.setSale_date(resultset.getString(5));
                ticket.setMovie_name(resultset.getString(6));
                ticket.setSeat(resultset.getInt(7));
                ticket.setPhone_number(resultset.getInt(8));
                tickets.add(ticket);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public int getTicketsSold(){
        int amount = 0;
        try{
            PreparedStatement prepstat = conn.prepareStatement("SELECT sold FROM ticketsale WHERE sold = 1");
            ResultSet resultset = prepstat.executeQuery();
            while(resultset.next()){
                amount++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public int getTicketsAvailable(){
        int amount = 0;
        try{
            PreparedStatement prepstat = conn.prepareStatement("SELECT sold FROM ticketsale WHERE sold = 0");
            ResultSet resultset = prepstat.executeQuery();
            while(resultset.next()){
                amount++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public double getProfit(){
        int sum = 0;
        try{
            PreparedStatement prepstat = conn.prepareStatement("SELECT price FROM ticketsale WHERE sold = 1");
            ResultSet resultset = prepstat.executeQuery();
            while(resultset.next()){
                sum += resultset.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return sum;
    }




        public List<TicketSale> getAllTicketSales()
        {
            List<TicketSale> ticketList = new ArrayList<TicketSale>();
            int count = 0;
            try {
                PreparedStatement prepstat = conn.prepareStatement("SELECT * FROM ticketsale");
                ResultSet resultset = prepstat.executeQuery();

                while (resultset.next()) {
                    TicketSale ticketSale = new TicketSale();
                    ticketSale.setPrice(resultset.getDouble(1));
                    ticketSale.setSold(resultset.getInt(2));
                    ticketSale.setReserved(resultset.getInt(3));
                    ticketSale.setSale_date(resultset.getString(4));
                    ticketSale.setMovie_name(resultset.getString(5));
                    ticketSale.setSeat(resultset.getInt(6));
                    ticketSale.setPhone_number(resultset.getInt(7));
                    ticketList.add(count, ticketSale);

                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            return ticketList;
        }

}

