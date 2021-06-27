package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Appuntamento;

public class AppuntamentoDAOImpl implements AppuntamentoDAO {

	DB db = new DB();
	Statement stat; 
	PreparedStatement ps; 
	ResultSet rs;
	
	@Override
	public List<Appuntamento> findAll() throws SQLException {
		List<Appuntamento> appuntamenti = new LinkedList<>();
		ps = db.getConn().prepareStatement(TROVA_TUTTI);
		LocalDate ld = LocalDate.now();
		java.sql.Date date = java.sql.Date.valueOf(ld);
		ps.setDate(1, date);
//		LocalDate ld = LocalDate.now();
//		ZoneId zi = ZoneId.systemDefault();
//		Date d = Date.from(ld.atStartOfDay(zi).toInstant());
//		ps.setDate(1, (java.sql.Date) d);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			Appuntamento a = new Appuntamento();
			a.setIdAppuntamento(rs.getInt("idAppuntamento"));
			a.setIdUtente(rs.getInt("idUtente"));
			a.setData(rs.getDate("data"));
			a.setOraInizio(rs.getTime("oraInizio"));
			a.setOraFine(rs.getTime("oraFine"));
			a.setArgomento(rs.getString("argomento"));
			
			appuntamenti.add(a);
		}
		
		return appuntamenti;
	}

	@Override
	public void addAppuntamento(Appuntamento nuovoApp) {
		
			try {
				ps = db.getConn().prepareStatement(AGGIUNGI_APPUNTAMENTO);
				ps.setInt(1, nuovoApp.getIdUtente());
				ps.setDate(2, nuovoApp.getData());
				ps.setTime(3, nuovoApp.getOraInizio());
				ps.setTime(4, nuovoApp.getOraFine());
				ps.setString(5, nuovoApp.getArgomento());

				Boolean ok = ps.execute();
				if (ok == true) {
					System.out.println("Appuntamento aggiunto");
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	
	
	
		
			
		
	

}
