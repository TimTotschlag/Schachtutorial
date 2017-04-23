package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class hauptmenueController {
	
	 static AnchorPane chessPane = new AnchorPane();
	 
	
	static void bild() {
		Image img = new Image("https://www.spreadshirt.de/image-server/v1/designs/16144300,width=178,height=178/schachfigur-bauer.png");
		ImageView Bauer = new ImageView(img);
		Bauer.setFitHeight(40);
		Bauer.setFitWidth(50);
		Bauer.setLayoutX(80);
		Bauer.setLayoutY(330);
		chessPane.getChildren().add(Bauer);
	}

    @FXML
    void Start(ActionEvent event) throws Exception {
    	ChessBoard.fullBoard();
    	ChessBoard.showAll();
    	AnchorPane chessPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("chessboard.fxml"));
    	Stage chessboard = new Stage();
    	chessboard.setScene(new Scene(chessPane));
    	chessboard.setTitle("Schachtutorial");
    	chessboard.setResizable(false);
    	bild();
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
