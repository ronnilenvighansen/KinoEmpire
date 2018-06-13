package kino.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kino.MainApp;
import kino.dao.DaoTicketSale;
import kino.model.TicketSale;
import org.junit.FixMethodOrder;

import java.util.ArrayList;
import java.util.List;


/**
 * @author samm0091
 * @version 17-03-2017.
 */
public class ReservationMenuController {

    private MainApp mainApp;
    @FXML
    TextField phoneNumber;
    @FXML
    TextArea reservationInfo;


    public ReservationMenuController() {

    }


    public void onCreateReservationClicked() {
        mainApp.showCreateReservationMenu();

    }

    public void onEditMovieClicked() {
        mainApp.showEditMovieMenu();
    }

    public void onDeleteReservationClicked() {
    }

    public void onPayReservationClicked() {
    }

    public void onFindReservationClicked() {
        try {


            reservationInfo.clear();
            List<TicketSale> a;
            a = this.mainApp.findReservationFromDB(Integer.parseInt(phoneNumber.getText()));
            int maxChar = 8;
            if ( phoneNumber.getText().length() == maxChar) {


                if (!a.isEmpty()) {
                    for (TicketSale ticket : a) {
                        reservationInfo.appendText(a.get(0).toString());

                    }
                } else {
                    System.out.println("Else is reached ");
                    reservationInfo.appendText("No reservation match on: " + phoneNumber.getText());
                }
            }else {
                reservationInfo.appendText("You must enter a valid phone number, containing 8 digits.");
            }
        } catch (IndexOutOfBoundsException iobe) {
            System.err.println(iobe.getMessage());
        } catch (NumberFormatException n) {
            System.err.println(n.getMessage());
            reservationInfo.appendText("Invalid phone number ");
        }

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
