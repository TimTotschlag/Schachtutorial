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
    void anmelden(ActionEvent event) {
    	System.out.println("Benutzer: " + benutzer.getText() + "\nPasswort: " + passwort.getText());
    }

    @FXML
    void registrieren(ActionEvent event) throws Exception {
    	Pane regisPane = (Pane) FXMLLoader.load(Main.class.getResource("regis.fxml")); //läd die fxml Datei an welches die Daten des Fensters enthält
    	Stage regisStage = new Stage();
    	regisStage.setScene(new Scene(regisPane));//erstellt das Fenster
    	regisStage.show();//Zeigt das Fenster welches man erstellt hat an
    	regisStage.setResizable(false); //Die größe des Fensters kann nicht verändert werden
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
