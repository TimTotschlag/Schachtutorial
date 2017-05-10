package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class anmeldeController {

	Label anmeldebenachr = new Label("Benutzer oder Passwort falsch!");
	static Label benutzerlabel;
	public static Pane regisPane = new Pane();
	static String user;
	static String pass;


	@FXML
    private PasswordField passwort;

    @FXML
    private TextField benutzer;

    @FXML
    void anmelden(ActionEvent event) throws Exception {
    	AnchorPane hauptPane = (AnchorPane) FXMLLoader.load(ChessBoard.class.getResource("hauptmenue.fxml"));
    	Stage hauptStage = new Stage();
    	hauptStage.setScene(new Scene(hauptPane));
    	hauptStage.setTitle("Hauptseite");
    	hauptStage.setResizable(false);

    	user = benutzer.getText();
    	pass = passwort.getText();
    	Datenbank.ueberpruefen(pass);

    	String pwueberpruefung = Datenbank.get();

    	String pwlogindaten = Datenbank.getoriginalpassword(user);
    	
    	benutzerlabel = new Label(user);
		benutzerlabel.setFont(new Font("System", 12));
		benutzerlabel.setLayoutX(67);
		benutzerlabel.setLayoutY(6);
		benutzerlabel.setPrefWidth(100);    //maximale breite des labels
		benutzerlabel.setWrapText(false);   //wenn die Maximale Buchstaben Zahl erreicht wurde kürzt er das mit ... ab
		benutzerlabel.setStyle("-fx-text-fill: black");
		hauptPane.getChildren().add(benutzerlabel);

    	if(pwueberpruefung.equals(pwlogindaten)){
    		Datenbank.pruefinhaltloeschen();
    		System.out.println("Login korrekt!");
        	hauptStage.show();
        	((Node)(event.getSource())).getScene().getWindow().hide();

    	}
    	else {
    		Datenbank.pruefinhaltloeschen();
    		anmeldebenachr.setFont(new Font("Arial", 10));
    		anmeldebenachr.setLayoutX(143);
    		anmeldebenachr.setLayoutY(150);
    		anmeldebenachr.setStyle("-fx-text-fill: red");
            ChessBoard.mainPane.getChildren().add(anmeldebenachr);

    	}
    }


    @FXML
    void registrieren(ActionEvent event) throws Exception {
    	regisPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regis.fxml"));
    	Stage regisStage = new Stage();
    	regisStage.setScene(new Scene(regisPane));
    	regisStage.setResizable(false);
    	regisStage.setTitle("Registrierung");
        regisStage.show();
    }


    @FXML
    void verlassen(ActionEvent event) {
    	Platform.exit();
    }


}
