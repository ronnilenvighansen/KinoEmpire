package kino.model;


import kino.dao.DaoTicketSale;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ahmed Fadhel on 16-03-2017.
 */
public class ESO {


    TicketSale ticketSale;
    ArrayList<TicketSale> ticketSales1 = new ArrayList<>();
    ArrayList<TicketSale> ticketSales2 = new ArrayList<>();
    DaoTicketSale daoTicketSale = new DaoTicketSale();

    public boolean isReserved(){
        if (ticketSale.getReserved() == 1){
            return true;
        }
        return false;
    }

    public boolean isSold(){
        if (ticketSale.getSold() == 1){
            return true;
        }
        return false;
    }


    public ArrayList<TicketSale> generateTicketTheater1(int ticketNr1, String movieName1) {
        ArrayList<Integer> seatNr1 = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < ticketNr1; i++) {
            int seat = r.nextInt(240) + 1;
            seatNr1.add(seat);
            TicketSale ticket = new TicketSale(180, 1, 0, "2017", movieName1, r.nextInt(240) +1, 14815847);
            if (!seatNr1.contains(ticket.getSeat())) {
                ticketSales1.add(ticket);
                daoTicketSale.createTicketSale(ticket);
            } else {
                ticketNr1++;
            }
        }
        return ticketSales1;
    }

    public ArrayList<TicketSale> getTicketSales1() {
        return ticketSales1;
    }

        public ArrayList<TicketSale> generateTicketTheater2(int ticketNr2, String movieName2) {
            ArrayList<Integer> seatNr2 = new ArrayList<>();
            Random r = new Random();
            for (int i = 0; i < ticketNr2 ; i++) {
                int seat = r.nextInt(400) + 1;
                seatNr2.add(seat);
                TicketSale ticket = new TicketSale(180, 1, 0, "2017", movieName2, r.nextInt(400) + 1, 15206894);
                if (!seatNr2.contains(ticket.getSeat())) {
                    ticketSales2.add(ticket);
                    daoTicketSale.createTicketSale(ticket);
                } else {
                    ticketNr2++;
                }
            }
        return ticketSales2;
    }

    public ArrayList<TicketSale> getTicketSales2() {
        return ticketSales2;
    }
}
