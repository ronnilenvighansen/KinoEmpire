package kino.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import kino.MainApp;
import kino.model.Movie;

/**
 * @author samm0091
 * @version 21-03-2017.
 */
public class EditMovieMenuController {

    @FXML
    private TableView<Movie> movieTable;
    @FXML
    private TableColumn<Movie, String> movieColumn;
    @FXML
    private TextField movieName;
    @FXML
    private TextField movieGenre;

    private MainApp mainApp;

    public EditMovieMenuController() {

    }

    @FXML
    private void initialize() {
        // Initialize the movieColumn containing movie name
        movieColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMovieName()));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        movieTable.setItems(this.mainApp.getMovieList());
    }

    public void onAddClicked() {
        Movie movie = new Movie(movieName.getText(), movieGenre.getText());
        this.mainApp.getMovieList().add(movie);

        //call method from main to store movie in DB
        this.mainApp.saveMovieToDB(movie);
    }

    public void onDeleteClicked() {
        int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            movieTable.getItems().remove(selectedIndex);

            //TODO: delete movie from database
        }
        else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("Please select a movie in the table.");

            alert.showAndWait();
        }
    }
}
