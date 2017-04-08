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
				//get the connection and use the database "schachbenutzer"
				Connection conn = getConnection();
				
				//Statement to create table "logindaten" (3 columns) 
				PreparedStatement createTable = conn.prepareStatement("CREATE TABLE IF NOT EXISTS logindaten(id int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (id), UNIQUE (username))");
				
				//Statement to create table "ueberpruefung" (2 columns)
				PreparedStatement createUeberpruefung = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ueberpruefung(id int NOT NULL AUTO_INCREMENT, passwordcheck varchar(255), PRIMARY KEY (id))");
				
				//gives the createTable command to SQL
				createTable.executeUpdate();
				
				//gives the createUeberpruefung command to SQL
				createUeberpruefung.executeUpdate();

				//catch if there is anything wrong
			} catch (Exception e) {
				
				//prints out the SQL error message
				System.out.println(e);	
			} 
		}


	//method that gets the entered username and password from the "regis.Controller" class to insert them into the "logindaten" table
	public static void post(String benutzer, String passwort) throws Exception{
		
		//varchar with "benutzer" String from class regisController
		final String var1 = benutzer;
		
		//varchar with "passwort" String from class regisController
		final String var2 = passwort;
		
		//ties to use the code
		try {
			
			//get the connection and use the database "schachbenutzer"
			Connection conn = getConnection();
			
			//Statement posted that insert into the columns username and password from table logindaten the var1 and var2
			PreparedStatement posted = conn.prepareStatement("INSERT INTO logindaten (username, password) VALUES ('" + var1 + "', SHA1('" + var2 + "'))");
			
			//gives the posted command to SQL
			posted.executeUpdate();
			
			//open a window that shows that registration is complete
			regisController.registerComplete();
		
	    	//catch if errors
		} catch (Exception e) {
			
			//prints out the SQL error message
			System.out.println(e);
			
			//open a windows that shows that registration isn't complete
			regisController.registrationIncomplete();
		} 
	}


	//method that gives out the stored information from the table "logindaten" from the database "schachbenutzer"
	public static String get() throws Exception {
		
			//tries to use code
			try {
				//call the method getConnection() to make sure that we are connected to the database
				Connection conn = getConnection();

				//Statement that select column "passwordcheck" from table "ueberpruefung"
				PreparedStatement statement = conn.prepareStatement("SELECT passwordcheck FROM ueberpruefung");

				//give the statement command to SQL and safe the return from the SQL in result
				ResultSet result = statement.executeQuery();

				//creates a new String Array for username and password
				String passwordcheck = new String();

				//as long as we have results give out the next results
				while (result.next()) {

					//prints out username
					passwordcheck = (result.getString("passwordcheck"));

				}

				//return the passwordcheck
				return passwordcheck;

			//execute if something is wrong
			} catch (Exception e) {

				//prints out the error message from SQL
				System.out.println(e);
			}
			//the method return nothing if we have an error
			return null;

		}

	//method that stores the password from login into the "ueberpruefung" table into the column ueberpruefung
	public static void ueberpruefen(String pass) throws Exception{
		
		//var2 is the password that we got from the anmeldeController class
		final String var2 = pass;
		
		//tries to execute the code
		try {
			
			//get the connection and use the database "schachbenutzer"
			Connection conn = getConnection();

			//Statement that insert "var2" into column "passwordcheck" from "ueberpruefung" as SHA1 hash
			PreparedStatement posted = conn.prepareStatement("INSERT INTO ueberpruefung (passwordcheck) VALUES (SHA1('" + var2 + "'))");
			
			//gives the posted command to SQL
			posted.executeUpdate();

			//catch is anything is wrong
		} catch (Exception e) {
			
			//prints out the error message from SQL
			System.out.println(e);
		}
		
	}
	
	//gets the password from table logindaten from the column with the right user
	public static String getoriginalpassword(String user) throws Exception {
		try {
			
			//Saved the String user we got to var1
			String var1 = user;
			
			//call the method getConnection() to make sure that we are connected to the database
			Connection conn = getConnection();

			//a prepared statement that allows us to use MySQL commands as a String, here we use a Select Statement to get username and password from the table logindaten
			PreparedStatement statement = conn.prepareStatement("SELECT password FROM logindaten WHERE username = ('" + var1 + "')");

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
			
			//return the hashed password 
			return wichtig;

		//if something goes wrong he get the errors from the MySQL database
		} catch (Exception e) {

			//prints out the error message from the MySQL database
			System.out.println(e);
		}
		//the method return nothing if we have an error
		return null;

	}
	
	//method that delete the content in the column passwordcheck from the table ueberpruefung
	public static void pruefinhaltloeschen() throws Exception{
	
		//tries to execute the code
		try {
			
			//get the connection and use the database "schachbenutzer"
			Connection conn = getConnection();
			
			//Statement that deletes the content in column from table ueberpruefung
			PreparedStatement posted = conn.prepareStatement("TRUNCATE TABLE `ueberpruefung`");
			
			//give the posted command to SQL
			posted.executeUpdate();

			//catch if anything is wrong
		} catch (Exception e) {
			
			//prints out the error message from SQL
			System.out.println(e);
		}
		
	}
}