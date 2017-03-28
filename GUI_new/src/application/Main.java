package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
//import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Main extends Application {

	public static void main(String[] args)throws Exception {
		System.out.println("Hallo MainMain");
		Application.launch(args);
//		Datenbank.getConnection();

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = (Pane) FXMLLoader.load(Main.class.getResource("Anmeldefenster.fxml")); //läd die fxml Datei an welches die Daten des Fensters enthält
		primaryStage.setScene(new Scene(mainPane)); //erstellt das Fenster
		primaryStage.show(); //Zeigt das Fenster welches man erstellt hat an
		primaryStage.setResizable(false); //Die größe des Fensters kann nicht verändert werden
		primaryStage.setTitle("Sachtutorial");
		
		//test
		//test2
		//test3
	}


}
