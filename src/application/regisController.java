package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class regisController {

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
    	//create a window
		Pane erfolgPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regiserfolg.fxml"));
    	Stage erfolgStage = new Stage();
    	erfolgStage.setScene(new Scene(erfolgPane));
    	erfolgStage.show();
    	erfolgStage.setResizable(false);
    	Thread.sleep(3000);  //paused the windows for 3 seconds
    	erfolgStage.close();  //close the windows
    	//window finished
    }

    static void registrationIncomplete() throws Exception {
    	//create a window
		Pane erfolgPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("regisfehlg.fxml"));
    	Stage erfolgStage = new Stage();
    	erfolgStage.setScene(new Scene(erfolgPane));
    	erfolgStage.show();
    	erfolgStage.setResizable(false);
    	Thread.sleep(3000);  //paused the windows for 3 seconds
    	erfolgStage.close();  //close the windows
    	//window finished

    }
}
