package kino.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import kino.MainApp;
import kino.model.TicketSale;

import java.util.ArrayList;
import java.util.List;

public class SmallTheaterController {

    private MainApp mainApp;

    @FXML
    private GridPane seatOverview;

    public SmallTheaterController() {

    }

    public void drawTheater(List<TicketSale> ticketSaleList) {

        List<TicketSale> list = new ArrayList<>(ticketSaleList);
        ArrayList<myButton> buttonList = new ArrayList<>();

        int seatCount = 1;
        System.out.println(list);
        int columns = 20, rows = 12;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {

                myButton rb = new myButton(seatCount);
                buttonList.add(rb);
                seatCount++;
                seatOverview.add(rb, i, j);

            }

        }

        // disable all sold buttons
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getSold() == 1 || list.get(k).getReserved() == 1) {
                buttonList.get(k).setDisable(true);
            }
        }
    }

    public class myButton extends RadioButton {

        int seatID;

        public myButton(int id) {
            this.seatID = id;
        }

        public int getSeatID() {
            return this.seatID;
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
