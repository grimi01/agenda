package dal;
//qui c'è il CRUD (create/read/update/delete)

import java.util.List;

import entities.Libro;

public interface LibroDAO {
	//qui scriviaimo le query che vogliamo fare
	//facciamo una query read con cui leggiamo solo i titoli
	String FIND_ALL = "select * from libro";
	//chi usa questa query? Il metodo che indico di seguito:
	List<Libro> findAll();//il tipo è una lista di libri.
	
	//trattasi di una interfaccia, quindi nel metodo non c'è nulla e lo devo definire in una classe a se stante
	
	

}
