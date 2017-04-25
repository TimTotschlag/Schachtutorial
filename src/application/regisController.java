package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    	Datenbank.post(benutzer, passwort);
    	abbrechen(event);
    }

    @FXML
    void abbrechen(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

     static void registerComplete() throws Exception {
		Pane erfolgPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regiserfolg.fxml"));
    	Stage erfolgStage = new Stage();
    	erfolgStage.setScene(new Scene(erfolgPane));
    	erfolgStage.show();
    	erfolgStage.setResizable(false);
    	Thread.sleep(3000);  //paused the windows for 3 seconds
    	erfolgStage.close();  //close the windows
    }

    static void registrationIncomplete() throws Exception {
		Pane erfolgPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regisfehlg.fxml"));
    	Stage erfolgStage = new Stage();
    	erfolgStage.setScene(new Scene(erfolgPane));
    	erfolgStage.show();
    	erfolgStage.setResizable(false);
    	Thread.sleep(3000);  //paused the windows for 3 seconds
    	erfolgStage.close();  //close the windows
    }
}
