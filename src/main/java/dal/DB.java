package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private final String DB_NAME = "prenotazione";
	private final String HOST = "jdbc:mysql://localhost:8889/" + DB_NAME;//host completo
	private final String USER = "appuntamento";
	private final String PASS = "appuntamento_2021";

	
	private Connection conn = null;//è la connessione al db
//	private Statement stat = null;//contenitore di istruzioni
//	private ResultSet rs = null;
	
	/*
	 *Metodo connetti: deve essere chiamato per connettere il db
	 */
	private void connetti() {
		if (this.conn==null) {
			try {
			this.conn = DriverManager.getConnection(HOST, USER, PASS);//gestore di driver
		}catch(SQLException e) {
			System.err.println("Si è verificato un problema nell connessione: " + e.getMessage());
			//e.printStackTrace();
			}	
		}
	}
	
	public void disconnetti() throws SQLException {
		if (this.conn != null) {
			this.conn.close();
		}
	}
	
	public Connection getConn() {
		connetti();
		
			return conn;
		}
		
	public static void main(String[] args) {
		
	}
}
