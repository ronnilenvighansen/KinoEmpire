package kino.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import kino.MainApp;
import kino.model.Movie;
import kino.model.TicketSale;

import java.util.Optional;

public class CreateReservationController {

    @FXML
    private ComboBox<Movie> movieList;
    @FXML
    private ComboBox<String> screeningDate;
    @FXML
    private ComboBox<Integer> seatColumn;
    @FXML
    private ComboBox<Integer> seatRows;
    @FXML
    private TextField price;
    @FXML
    private TextField phoneNumber;
    @FXML
    private Button chooseSeatsButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button createTicket;

    private MainApp mainApp;

    public CreateReservationController() {

    }

    public void onCreateTicket() {
        if(phoneNumber.getText().length()==8) {
        TicketSale ticketSale = new TicketSale();
        ticketSale.setMovie_name(movieList.getSelectionModel().getSelectedItem().getMovieName());
        ticketSale.setSale_date(screeningDate.getSelectionModel().getSelectedItem());
        ticketSale.setPrice(Double.parseDouble(price.getText()));
        ticketSale.setPhone_number(Integer.parseInt(phoneNumber.getText()));
        ticketSale.setReserved(1);

        String movieName = movieList.getSelectionModel().getSelectedItem().getMovieName();
        String date = screeningDate.getSelectionModel().getSelectedItem();
        int phone = Integer.parseInt(phoneNumber.getText());
        int seat;
        int row;
        double ticketPrice = Double.parseDouble(price.getText());

        //TicketSale ticketSale = new TicketSale(ticketPrice, 0, 0, date, movieName, 0, phone);

        System.out.println(ticketSale);

        // call method in main to store ticket in DB
        this.mainApp.saveTicketToDB(ticketSale);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "The phone number you have entered is invalid. Please check" +
                            " if the number has 8 digits.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

            }
        }

    }

    public void onCancelButtonClicked() {
        this.mainApp.showReservationMenu();
    }

    public void onChooseSeatsClicked() {
        this.mainApp.showSeatsSmallTheater();
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        movieList.setItems(mainApp.getMovieList());
    }

    // will be executed when fxml file is loaded
    public void initialize() {
        screeningDate.getItems().addAll("21-03");
        price.setText("420.0");
    }


}