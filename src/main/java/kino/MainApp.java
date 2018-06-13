package kino; /**
 * @author samm0091
 * @version 16-03-2017.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kino.controller.*;
import kino.dao.DaoTicketSale;
import kino.dao.MovieDao;
import kino.model.Movie;
import kino.model.TicketSale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    private Stage primaryStage;
    private ObservableList<Movie> movieList = FXCollections.observableArrayList();
    private List<TicketSale> ticketSaleList = new ArrayList();
    private DaoTicketSale daoTicketSale = new DaoTicketSale();
    private MovieDao movieDao = new MovieDao();



    public MainApp() {
        movieList.add(new Movie("Ali G", "Comedy"));
        movieList.add(new Movie("Ali G in da house", "Romance"));

    }

    public ObservableList<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Keanu");

        showLoginMenu();

    }

    public void showReservationMenu() {
        try {
            // Load ReservationMenu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/ReservationMenu.fxml"));
            AnchorPane reservationMenu = loader.load();

            // Show the scene
            Scene scene = new Scene(reservationMenu);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

            // Give the reservationMenuController access to the main app.
            ReservationMenuController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateReservationMenu() {
        try {
            // Load createReservationMenu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/CreateReservationMenu.fxml"));
            AnchorPane createReservation = loader.load();


            // new scene
            Scene scene = new Scene(createReservation);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Create Reservation");
            primaryStage.show();

            // Give the createReservationController access to the main app.
            CreateReservationController controller = loader.getController();
            controller.setMainApp(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showLoginMenu() {
        try {
            // Load login
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/Login.fxml"));
            AnchorPane login = loader.load();


            Scene scene = new Scene(login);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Give the LoginController access to the main app.
            LoginController controller = loader.getController();
            controller.setMainApp(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSeatsSmallTheater() {
        try {
            // Load seatsOverview for Small theater
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/SeatsOverview/Seats_SmallTheater.fxml"));
            GridPane smallTheater = loader.load();


            // new Stage with new scene
            Stage seatStage = new Stage();
            Scene scene = new Scene(smallTheater);
            seatStage.setScene(scene);
            seatStage.setTitle("Small Theater");

            // Give the SmallTheaterController access to the main app.
            SmallTheaterController controller = loader.getController();
            controller.setMainApp(this);

            this.ticketSaleList = daoTicketSale.getAllTicketSales();

            controller.drawTheater(ticketSaleList);
            seatStage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showEditMovieMenu() {
        try {
            // Load editMovie
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/EditMovieMenu.fxml"));
            AnchorPane editMovie = loader.load();


            // new Stage with new scene
            Stage seatStage = new Stage();
            Scene scene = new Scene(editMovie);
            seatStage.setScene(scene);
            seatStage.setTitle("Edit Movie");
            seatStage.show();

            // Give the EditMovieMenuController access to the main app.
            EditMovieMenuController controller = loader.getController();
            controller.setMainApp(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTicketToDB(TicketSale ticketSale) {
        ArrayList<TicketSale> list = new ArrayList<>(daoTicketSale.getAllTicketSales());

        for (TicketSale tick : list) {
            if (ticketSale.getSeat() != tick.getSeat()) {
                this.daoTicketSale.createTicketSale(ticketSale);
            }
        }



    }

    public void saveMovieToDB(Movie movie) {
        this.movieDao.createMovieGenreName(movie.getMovieGenre(), movie.getMovieName());
    }

    public List<TicketSale> findReservationFromDB(int phonenumber)
    {
        List<TicketSale> ticketList = new ArrayList<TicketSale>();
        ticketList = this.daoTicketSale.findTickets(phonenumber);
        return ticketList;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
