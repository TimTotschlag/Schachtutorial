package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class hauptmenueController {
	

	    static AnchorPane chessPane = new AnchorPane();
		
	



    @FXML
    void Start(ActionEvent event) throws Exception {
    	ChessBoard.fullBoard();
    	ChessBoard.showAll();
    	chessPane = FXMLLoader.load(ChessBoard.class.getResource("chessboard.fxml"));
    	Stage chessboard = new Stage();
    	chessboard.setScene(new Scene(chessPane));
    	chessboard.setTitle("Schachtutorial");
    	chessboard.setResizable(false);
    	chessboardController.bild();
    	chessboard.show();
    	((Node)(event.getSource())).getScene().getWindow().hide();
    	
    }

    @FXML
    void Szenarien(ActionEvent event) {

    }

    @FXML
    void zurück(ActionEvent event) throws Exception {
    	ChessBoard.mainPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("Anmeldefenster.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(ChessBoard.mainPane)); 
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Sachtutorial");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    


}
