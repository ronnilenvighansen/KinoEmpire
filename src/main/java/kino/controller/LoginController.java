package kino.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kino.MainApp;
import kino.model.Login;


/**
 * Created by clint on 20-03-2017.
 */
public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Text incorrect;

    private MainApp mainApp;
    private Login L = new Login();

    public void loginOK (ActionEvent event)
    {
        boolean existingUser = L.checkLogin(username.getText(),password.getText());
        if(existingUser == true)
        {
            mainApp.showReservationMenu();

        }
        else{
            username.clear();
            password.clear();
            incorrect.setVisible(true);

        }
    }

    public void cancel(ActionEvent event)
    {
        Stage loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginstage.close();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}
