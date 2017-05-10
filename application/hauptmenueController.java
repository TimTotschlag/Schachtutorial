package application;


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
    	chessboard.show();
    	((Node)(event.getSource())).getScene().getWindow().hide();
    	


    }

    @FXML
    void Tutorial(ActionEvent event) throws Exception {
    	AnchorPane tutorialPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("tutorial.fxml"));
    	Stage tutorialStage = new Stage();
    	tutorialStage.setScene(new Scene(tutorialPane));
    	tutorialStage.setResizable(false);
    	tutorialStage.setTitle("Tutorial");
    	tutorialStage.show();
    	((Node)(event.getSource())).getScene().getWindow().hide();
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
