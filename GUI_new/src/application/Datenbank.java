package application; // default package application

//MySQL Library for connection Statements
import java.sql.Connection;

//MySQL Library with drivers to get a connection to a MySQL Database
import java.sql.DriverManager;

//MySQL Library for Strings with SQL commands
import java.sql.PreparedStatement;

//MySql Library to give all information from a table
import java.sql.ResultSet;

//MySQL Library to give out the Table as Array List
//import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//start with the Database class, 4 methods
public class Datenbank {

	//method that connect to the MySQL database called "schachbenutzer"
	public static Connection getConnection() throws Exception {

			try {
				//loads the java MySQL connector driver
				String driver = "com.mysql.jdbc.Driver";

				//String that give the path where the MySQL database is saved
				String url = "jdbc:mysql://localhost";

				//String that gives the username of the database to get access
				String username = "root";

				//String that gives the password of the database to get access
				String password = "";

				Class.forName(driver);

				//try to connect to the database with the information (url, username, password)
				Connection conn = DriverManager.getConnection(url, username, password);
				
				//try to create database "schachbenutzer" if the database not exists
				PreparedStatement createDatabase = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS schachbenutzer");
				
				//gives the createDatabase command to SQL
				createDatabase.executeUpdate();
				
				//Statement that says that we have to use the database "schachbenutzer"
				PreparedStatement useDatabase = conn.prepareStatement("USE schachbenutzer");
				
				//gives the useDatabase command to SQL
				useDatabase.executeUpdate();
				
				//prints out that the programm is connected to SQL and we use the "schachbenutzer" database
				System.out.println("MySQL mit Datenbank 'Schachbenutzer' Verbunden");
				
				//returns the conn that says the SQL Driver that we are connected to the SQL with correct logindata
				return conn;

				//catch if there is anything wrong
			} catch (Exception e) {

				//calls out what the MySQL database error is
				System.out.println(e);
			}
			//return nothing if we got errors
			return null;
		}


	//method that create the tables logindaten (3 columns) and ueberpruefung (2 columns) 
	public static void createTable() throws Exception {
			
		//try to use the code
		try {
				//
				Connection con = getConnection();
				PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS logindaten(id int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (id), UNIQUE (username))");
				PreparedStatement createUeberpruefung = con.prepareStatement("CREATE TABLE IF NOT EXISTS ueberpruefung(id int NOT NULL AUTO_INCREMENT, passwordcheck varchar(255), PRIMARY KEY (id))");
				createTable.executeUpdate();
				createUeberpruefung.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println("Tabellen erstellt");
			}
		}


	//method that gets the entered username and password from the "regis.Controller" class to push them into the "logindaten" table
	public static void post(String benutzer, String passwort) throws Exception{
		final String var1 = benutzer;
		final String var2 = passwort;
		try {
			Connection con = getConnection();
			// Zeile nimmt die beiden String Daten var1 und var2 und speichert
			// sie verschlüsselt wegen des SHA1 in die Datenbank ab.
			// PreparedStatement posted = con.prepareStatement("INSERT INTO
			PreparedStatement posted = con.prepareStatement("INSERT INTO logindaten (username, password) VALUES ('" + var1 + "', SHA1('" + var2 + "'))");
			posted.executeUpdate();
			//Fenster erstellen
			Pane erfolgPane = (Pane) FXMLLoader.load(Main.class.getResource("regiserfolg.fxml"));
	    	Stage erfolgStage = new Stage();
	    	erfolgStage.setScene(new Scene(erfolgPane));
	    	erfolgStage.show();
	    	erfolgStage.setResizable(false);
	    	Thread.sleep(3000);  //vorgang pausiert für 3 sekunden
	    	erfolgStage.close();  //beendet das fenster
	    	//fenster ende
		} catch (Exception e) {
			System.out.println(e);
			//fenster erstellen
			Pane fehlPane = (Pane) FXMLLoader.load(Main.class.getResource("regisfehlg.fxml"));
    		Stage fehlStage = new Stage();
    		fehlStage.setScene(new Scene(fehlPane));
    		fehlStage.show();
    		fehlStage.setResizable(false);
    		Thread.sleep(3000);
    		fehlStage.close();
    		//Fenster ende
		} finally {
			System.out.println("Eingabe erfolgreich");
		}
	}


	//method that gives out the stored information from the table "logindaten" from the database "schachbenutzer"
	public static String get() throws Exception {
			try {
				//call the method getConnection() to make sure that we are connected to the database
				Connection con = getConnection();

				//a prepared statement that allows us to use MySQL commands as a String, here we use a Select Statement to get username and password from the table logindaten
				PreparedStatement statement = con.prepareStatement("SELECT passwordcheck FROM ueberpruefung");

				//gives out results as long as there are all given out
				ResultSet result = statement.executeQuery();

				//creates a new String Array for username and password
				String passwordcheck = new String();

				//as long as we have results give out the next results
				while (result.next()) {

					//prints out username
					passwordcheck = (result.getString("passwordcheck"));

				}
				//prints out that all information are repeated if all information are repeated
				//System.out.println("Alle Inhalte wurden wiedergegeben");

				//return the array list with username and passwords
				return passwordcheck;

			//if something goes wrong he get the errors from the MySQL database
			} catch (Exception e) {

				//prints out the error message from the MySQL database
				System.out.println(e);
			}
			//the method return nothing if we have an error
			return null;

		}

	public static void ueberpruefen(String pass) throws Exception{
		final String var2 = pass;
		try {
			Connection con = getConnection();
			// Zeile nimmt die beiden String Daten var1 und var2 und speichert
			// sie verschlüsselt wegen des SHA1 in die Datenbank ab.
			// PreparedStatement posted = con.prepareStatement("INSERT INTO
			PreparedStatement posted = con.prepareStatement("INSERT INTO ueberpruefung (passwordcheck) VALUES (SHA1('" + var2 + "'))");
			posted.executeUpdate();


		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static String getoriginalpassword(String user) throws Exception {
		try {
			String var1 = user;
			//call the method getConnection() to make sure that we are connected to the database
			Connection con = getConnection();

			//a prepared statement that allows us to use MySQL commands as a String, here we use a Select Statement to get username and password from the table logindaten
			PreparedStatement statement = con.prepareStatement("SELECT password FROM logindaten WHERE username = ('" + var1 + "')");

			//gives out results as long as there are all given out
			ResultSet result = statement.executeQuery();

			//creates a new String Array for username and password
			String wichtig = new String();
			
//			System.out.println("HI");
			//as long as we have results give out the next results
			while (result.next()) {

				//prints out username
				wichtig = (result.getString("password"));
				
			}
			//prints out that all information are repeated if all information are repeated
			//System.out.println("Alle Inhalte wurden wiedergegeben");

			
			
			//return the array list with username and passwords
			return wichtig;

		//if something goes wrong he get the errors from the MySQL database
		} catch (Exception e) {

			//prints out the error message from the MySQL database
			System.out.println(e);
		}
		//the method return nothing if we have an error
		return null;

	}
	
	public static void pruefinhaltloeschen() throws Exception{
	
		try {
			Connection con = getConnection();
			// Zeile nimmt die beiden String Daten var1 und var2 und speichert
			// sie verschlüsselt wegen des SHA1 in die Datenbank ab.
			// PreparedStatement posted = con.prepareStatement("INSERT INTO
			PreparedStatement posted = con.prepareStatement("TRUNCATE TABLE `ueberpruefung`");
			posted.executeUpdate();


		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}