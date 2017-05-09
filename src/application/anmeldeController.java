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

	Label label = new Label("DICK");

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
    	hauptStage.show();
    	hauptStage.setResizable(false);
    	((Node)(event.getSource())).getScene().getWindow().hide();
    	
    	String user = benutzer.getText();
    	String pass = passwort.getText();
    	Datenbank.ueberpruefen(pass);

    	String pwueberpruefung = Datenbank.get();

    	String pwlogindaten = Datenbank.getoriginalpassword(user);

    	if(pwueberpruefung.equals(pwlogindaten)){
    		Datenbank.pruefinhaltloeschen();
    		System.out.println("Login korrekt!");

    	}
    	else {
    		System.out.println("Falscher Username oder Passwort");
    		Datenbank.pruefinhaltloeschen();
    	}
    }


    @FXML
    void registrieren(ActionEvent event) throws Exception {
    	Pane regisPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regis.fxml")); //läd die fxml Datei an welches die Daten des Fensters enthält
    	Stage regisStage = new Stage();
    	regisStage.setScene(new Scene(regisPane));//erstellt das Fenster
    	//regisStage.show();//Zeigt das Fenster welches man erstellt hat an
    	regisStage.setResizable(false); //Die größe des Fensters kann nicht verändert werden
    	regisStage.setTitle("Registrierung");
    	
        label.setFont(new Font("Arial", 10));
        label.setLayoutX(60);
        label.setLayoutY(135);
        regisPane.getChildren().add(label);
        regisStage.show();
    }

    @FXML
    void info(ActionEvent event) {

    }

    @FXML
    void verlassen(ActionEvent event) {
    	Platform.exit();
    }

}
