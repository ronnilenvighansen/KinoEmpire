import kino.model.ESO;

/**
 * Created by Ahmed Fadhel on 17-03-2017.
 */
public class tickettest {
    public static void main(String[] args) {
        ESO eso = new ESO();
        System.out.println(eso.generateTicketTheater1(20,"logan") + "\n");
        System.out.println(eso.getTicketSales1().size());
    }
}
