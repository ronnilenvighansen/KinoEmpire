package kino.dao;


import kino.model.TicketSale;
import sun.security.krb5.internal.Ticket;

import java.util.List;

/**
 * Created by Dave on 20/03/2017.
 */
public interface DaoTicketSale_Interface {

    void createTicketSaleParam(TicketSale ticketsale, int sale_status);

    void createTicketSale(TicketSale ticketsale);

    void getTicketSale(int ticketSale_id);

    void updateTicketSale(TicketSale ticketSale);

    void removeTicketSale(int ticketSale_id);

    public List<TicketSale> getAllTicketSales();


    public int getTicketsSold();

    public int getTicketsAvailable();

    public double getProfit();

}
