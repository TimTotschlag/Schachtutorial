package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class regisController {

	static Label regiscomp = new Label("Registrierung erfolgreich"); //Label wird erstellt
	static Label regisIncom = new Label("Benutzer schon vorhanden!");

	public String benutzer;
	public String passwort;

    @FXML
    private PasswordField regispasswort;

    @FXML
    private TextField regisname;

    @FXML
    void registrieren(ActionEvent event) throws Exception {
    	benutzer = regisname.getText(); //der Text der in das Feld geschrieben wird, wird der Variable Benutzer zugefügt
    	passwort = regispasswort.getText();
    	Datenbank.createTable();
    	int erfolgreich = Datenbank.post(benutzer, passwort);
    	if(erfolgreich == 1){
    		anmeldeController.regisPane.getChildren().add(regiscomp); //fügt das Label dem Fenster zu
    		anmeldeController.regisPane.getChildren().remove(regisIncom); //löscht ein Label vom Fenster
    	}
    	else{
    		anmeldeController.regisPane.getChildren().add(regisIncom);
    		anmeldeController.regisPane.getChildren().remove(regiscomp);
    	}
    }

    @FXML
    void abbrechen(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide(); //versteckt das Fenster
    }

     static void registerComplete() throws Exception {
    	regiscomp.setFont(new Font("Arial", 10)); //ändert die Schriftart und Größe
    	regiscomp.setLayoutX(60); //Koordinaten werden verändert
    	regiscomp.setLayoutY(135);
    	regiscomp.setStyle("-fx-text-fill: red"); //ändert die Farbe
    }

    static void registrationIncomplete() throws Exception {
    	regisIncom.setFont(new Font("Arial", 10));
    	regisIncom.setLayoutX(60);
    	regisIncom.setLayoutY(135);
    	regisIncom.setStyle("-fx-text-fill: red");
    }
}
