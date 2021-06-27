package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appuntamento {
	
	private int idAppuntamento;
	private int idUtente;
	private Date data;
	private Time oraInizio, oraFine;
	private String argomento;
	
	
	
	
	public Appuntamento() {
		super();
	}
	public Appuntamento(int idAppuntamento, int idUtente, Date data, Time oraInizio, Time oraFine, String argomento) {
		super();
		this.idAppuntamento = idAppuntamento;
		this.idUtente = idUtente;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.argomento = argomento;
	}
	
	public int getIdAppuntamento() {
		return idAppuntamento;
	}
	public void setIdAppuntamento(int idAppuntamento) {
		this.idAppuntamento = idAppuntamento;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(Time oraInizio) {
		this.oraInizio = oraInizio;
	}
	public Time getOraFine() {
		return oraFine;
	}
	public void setOraFine(Time oraFine) {
		this.oraFine = oraFine;
	}
	public String getArgomento() {
		return argomento;
	}
	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	@Override
	public String toString() {
		return "Appuntamento [idAppuntamento=" + idAppuntamento + ", idUtente=" + idUtente + ", data=" + data
				+ ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", argomento=" + argomento + "]";
	}
	

}
