package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class tutorialController {

    @FXML
    void zurück(ActionEvent event) throws Exception {
    	AnchorPane hauptPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("hauptmenue.fxml"));
    	Stage hauptStage = new Stage();
    	hauptStage.setScene(new Scene(hauptPane));
    	hauptStage.setTitle("Hauptseite");
    	hauptStage.setResizable(false);
    	hauptStage.show();
    	((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void Bauer(ActionEvent event) {

    }

    @FXML
    void Springer(ActionEvent event) {

    }

    @FXML
    void Läufer(ActionEvent event) {

    }

    @FXML
    void Turm(ActionEvent event) {

    }

    @FXML
    void König(ActionEvent event) {

    }

    @FXML
    void Dame(ActionEvent event) {

    }

}
