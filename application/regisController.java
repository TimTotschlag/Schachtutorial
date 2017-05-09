package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class regisController {

	static Label regiscomp = new Label("Registrierung erfolgreich");
	static Label regisIncom = new Label("Benutzer schon vorhanden!");

	public String benutzer;
	public String passwort;

    @FXML
    private PasswordField regispasswort;

    @FXML
    private TextField regisname;

    @FXML
    void regis(ActionEvent event) throws Exception {
    	benutzer = regisname.getText();
    	passwort = regispasswort.getText();
    	Datenbank.createTable();
    	int erfolgreich = Datenbank.post(benutzer, passwort);
    	if(erfolgreich == 1){
    		anmeldeController.regisPane.getChildren().add(regiscomp);
    		anmeldeController.regisPane.getChildren().remove(regisIncom);
    	}
    	else{
    		anmeldeController.regisPane.getChildren().add(regisIncom);
    		anmeldeController.regisPane.getChildren().remove(regiscomp);
    	}
    }

    @FXML
    void abbrechen(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

     static void registerComplete() throws Exception {
    	regiscomp.setFont(new Font("Arial", 10));
    	regiscomp.setLayoutX(60);
    	regiscomp.setLayoutY(135);
    	regiscomp.setStyle("-fx-text-fill: red");
    }

    static void registrationIncomplete() throws Exception {
    	regisIncom.setFont(new Font("Arial", 10));
    	regisIncom.setLayoutX(60);
    	regisIncom.setLayoutY(135);
    	regisIncom.setStyle("-fx-text-fill: red");
    }
}
