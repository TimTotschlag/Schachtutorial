package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Datenbank {

	public static void main(String[] args) throws Exception {
//		 createTable();
//		 post();
//		 get();
	}

	public static ArrayList<String> get() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT username, password FROM logindaten");

			ResultSet result = statement.executeQuery();

			ArrayList<String> array = new ArrayList<String>();
			while (result.next()) {
				System.out.print(result.getString("username"));
				System.out.print(" ");
				System.out.println(result.getString("password"));

				array.add(result.getString("password"));
			}
			System.out.println("Alle Inhalte wurden wiedergegeben");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public static void post(String benutzer, String passwort) throws Exception{
		final String var1 = benutzer;
		final String var2 = passwort;
		try {
			Connection con = getConnection();
			// Zeile nimmt die beiden String Daten var1 und var2 und speichert
			// sie verschlüsselt wegen des SHA1 in die Datenbank ab.
			// PreparedStatement posted = con.prepareStatement("INSERT INTO
			// logindaten (username, password) VALUES ('"+var1+"',
			// SHA1('"+var2+"'))");
			PreparedStatement posted = con.prepareStatement("INSERT INTO logindaten (username, password) VALUES ('" + var1 + "', SHA1('" + var2 + "'))");
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Eingabe erfolgreich");
		}
	}

	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS logindaten(id int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), PRIMARY KEY (id))");
			create.executeUpdate();
			System.out.println("testTableMethode");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("HalloCreateTable");
			System.out.println("Function Complete.");
		}
	}

	public static Connection getConnection() throws Exception {

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/schachbenutzer";
			String username = "root";
			String password = "";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}