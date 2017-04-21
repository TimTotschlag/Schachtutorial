package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;



public class Main extends Application {

	public static void main(String[] args)throws Exception {

			Application.launch(args);
		

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = (Pane) FXMLLoader.load(Main.class.getResource("Anmeldefenster.fxml")); //läd die fxml Datei an welches die Daten des Fensters enthält
		primaryStage.setScene(new Scene(mainPane)); //erstellt das Fenster
		primaryStage.show(); //Zeigt das Fenster welches man erstellt hat an
		primaryStage.setResizable(false); //Die größe des Fensters kann nicht verändert werden
		primaryStage.setTitle("Sachtutorial");
		



	}


}
