package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class anmeldeController {

    @FXML
    private PasswordField passwort;

    @FXML
    private TextField benutzer;

    @FXML
    void anmelden(ActionEvent event) throws Exception {

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
    	Pane regisPane = (Pane) FXMLLoader.load(Main.class.getResource("regis.fxml")); //l�d die fxml Datei an welches die Daten des Fensters enth�lt
    	Stage regisStage = new Stage();
    	regisStage.setScene(new Scene(regisPane));//erstellt das Fenster
    	regisStage.show();//Zeigt das Fenster welches man erstellt hat an
    	regisStage.setResizable(false); //Die gr��e des Fensters kann nicht ver�ndert werden
    	regisStage.setTitle("Registrierung");
    }

    @FXML
    void info(ActionEvent event) {

    }

    @FXML
    void verlassen(ActionEvent event) {
    	Platform.exit();
    }

}
