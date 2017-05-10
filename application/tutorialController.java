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
    void Bauer(ActionEvent event) throws Exception {
    	AnchorPane bauerPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialbauer.fxml"));
    	Stage bauerStage = new Stage();
    	bauerStage.setScene(new Scene(bauerPane));
    	bauerStage.setTitle("Bauer");
    	bauerStage.setResizable(false);
    	bauerStage.show();
    }

    @FXML
    void Springer(ActionEvent event) throws Exception {
    	AnchorPane springerPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialspringer.fxml"));
    	Stage springerStage = new Stage();
    	springerStage.setScene(new Scene(springerPane));
    	springerStage.setTitle("Springer");
    	springerStage.setResizable(false);
    	springerStage.show();
    }

    @FXML
    void Läufer(ActionEvent event) throws Exception {
    	AnchorPane läuferPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialläufer.fxml"));
    	Stage läuferStage = new Stage();
    	läuferStage.setScene(new Scene(läuferPane));
    	läuferStage.setTitle("Läufer");
    	läuferStage.setResizable(false);
    	läuferStage.show();
    }

    @FXML
    void Turm(ActionEvent event) throws Exception {
    	AnchorPane turmPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialtürme.fxml"));
    	Stage turmStage = new Stage();
    	turmStage.setScene(new Scene(turmPane));
    	turmStage.setTitle("Turm");
    	turmStage.setResizable(false);
    	turmStage.show();
    }

    @FXML
    void König(ActionEvent event) throws Exception {
    	AnchorPane königPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialkoenig.fxml"));
    	Stage königStage = new Stage();
    	königStage.setScene(new Scene(königPane));
    	königStage.setTitle("König");
    	königStage.setResizable(false);
    	königStage.show();
    }

    @FXML
    void Dame(ActionEvent event) throws Exception {
    	AnchorPane damePane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorialdame.fxml"));
    	Stage dameStage = new Stage();
    	dameStage.setScene(new Scene(damePane));
    	dameStage.setTitle("Dame");
    	dameStage.setResizable(false);
    	dameStage.show();
    }

}
