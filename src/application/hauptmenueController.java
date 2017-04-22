package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class hauptmenueController {

    @FXML
    void Start(ActionEvent event) throws Exception {
    	ChessBoard.fullBoard();
    	ChessBoard.showAll();
    	AnchorPane chessPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("chessboard.fxml"));
    	Stage chessboard = new Stage();
    	chessboard.setScene(new Scene(chessPane));
    	chessboard.setTitle("Schachtutorial");
    	chessboard.setResizable(false);
    	chessboard.show();
    	((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void Szenarien(ActionEvent event) {

    }

    @FXML
    void zurück(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
