package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Libro;

//questa classe è un'implementazione dell'interfaccia, quindi devo scrivere implements LibroDAO  
public class LibroDAOImpl implements LibroDAO {
	
	//proprietà private di questa classe, che ha bisogno di un db, di una connessione, di un st e di un risultato 
	private DB db = new DB();//creo nuovo oggetto db
	private Connection conn;//oggetto che permette la connessione con un db specifico (conn me lo da db).
	private Statement st;//(st me lo da conn)
	private ResultSet rs; 
	
	
	//implemento il metodo
	@Override
	public List<Libro> findAll() {
		List<Libro> listaLibri = new ArrayList();//List è un'interfaccia, quindi devo scegliere un tipo (in questo caso ArrayList)
		conn = db.getConn();//prendo connessione
		try {
			st = conn.createStatement();//creo st e surround con try/catch
			rs= st.executeQuery(FIND_ALL);//eseguo la query che restituirà un risultato(che sarà in sql) che salvo in rs.
			
			//traduco questo risultato sql in oggetti java-> uso la lista che ho creato sopra
			//la lista l'ho creata fuori dal try/catch perchè anche il return è fuori
			
			//siccome non so quante righe di rs ho, come faccio a trasformare queste righe in oggetti java?
			//lo faccio con un ciclo while
			
			while (rs.next()) {//next: cioè fino a quando rs ha delle righe, cioè non finiscono le righe nel rs
				//leggo una riga e la trasformo in un libro:
				Libro nuovoLibro = new Libro();//ho costruito un libro e il metodo costruttore restituisce il riferimento nella ram
				nuovoLibro.setId(rs.getInt("id"));//prendi l'int id di rs e settalo in nuovoLibro
				nuovoLibro.setTitolo(rs.getString("titolo"));//idem come sopra
				listaLibri.add(nuovoLibro);//aggiungo i libri trasformati nella lista creata
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return listaLibri;//restituisce la lista
	}
	
}
