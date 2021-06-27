package model;

public class Utente {
	
	private int id;
	private String password, nome, cognome;
	
	public Utente() {}
	
	public Utente(int id, String password, String nome, String cognome) {
		this.id = id;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}
