package dal;

import java.sql.SQLException;
import java.util.List;

import model.Appuntamento;

public interface AppuntamentoDAO {
	
	String TROVA_TUTTI = "select * from appuntamento where data = ? order by oraInizio";
	List<Appuntamento> findAll() throws SQLException;
	
	String AGGIUNGI_APPUNTAMENTO = "insert into appuntamento (idUtente, data, oraInizio, OraFine, argomento) values (?, ?, ?, ?, ?)";
	void addAppuntamento(Appuntamento nuovoApp); 

}
