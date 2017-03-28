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
import java.util.ArrayList; 

//start with the Database class, 4 methods 
public class Datenbank {

	
	//method that connect to the MySQL database called "schachbenutzer"
	public static Connection getConnection() throws Exception {

			try {
				//loads the java MySQL connector driver
				String driver = "com.mysql.jdbc.Driver";
				
				//String that give the path where the MySQL database is saved
				String url = "jdbc:mysql://localhost/schachbenutzer";
				
				//String that gives the username of the database to get access
				String username = "root";
				
				//String that gives the password of the database to get access
				String password = "";
				
				Class.forName(driver);

				//try to connect to the database with the information (url, username, password)
				Connection conn = DriverManager.getConnection(url, username, password);
				
				//prints out that the programm is connected to the database
				System.out.println("Datenbank Verbunden");
				
				//returns the url, username and password
				return conn;
				
				//catch if there is anything wrong
			} catch (Exception e) {
				
				//calls out what the MySQL database error is
				System.out.println(e);
			}
			//return nothing if we got errors
			return null;
		}

	
	//method thats create a table into the database, called "logindaten" but only if not exist
	public static void createTable() throws Exception {
			try {
				Connection con = getConnection();
				PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS logindaten(id int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (id))");
				create.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println("Tabelle erstellt");
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
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Eingabe erfolgreich");
		}
	}

	
	//method that gives out the stored information from the table "logindaten" from the database "schachbenutzer"
	public static ArrayList<String> get() throws Exception {
			try {
				//call the method getConnection() to make sure that we are connected to the database
				Connection con = getConnection();
				
				//a prepared statement that allows us to use MySQL commands as a String, here we use a Select Statement to get username and password from the table logindaten
				PreparedStatement statement = con.prepareStatement("SELECT username, password FROM logindaten");

				//gives out results as long as there are all given out
				ResultSet result = statement.executeQuery();

				//creates a new String Array for username and password
				ArrayList<String> array = new ArrayList<String>();
				
				//as long as we have results give out the next results
				while (result.next()) {
					
					//prints out username
					System.out.print(result.getString("username"));
					
					//prints out a space between username and password
					System.out.print(" ");
					
					//prints out password
					System.out.println(result.getString("password"));

					array.add(result.getString("password"));
				}
				//prints out that all information are repeated if all information are repeated
				System.out.println("Alle Inhalte wurden wiedergegeben");
				
				//return the array list with username and passwords
				return array;

			//if something goes wrong he get the errors from the MySQL database
			} catch (Exception e) {
				
				//prints out the error message from the MySQL database
				System.out.println(e);
			}
			//the method return nothing if we have an error
			return null;

		}
}