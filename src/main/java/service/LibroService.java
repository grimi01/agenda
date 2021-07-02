package service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dal.LibroDAOImpl;
import entities.Libro;

//qui metto la logica di business
public class LibroService {
	
	//come nel DAOImpl avevo l'oggetto DB, qui ho bisogno dell'oggetto LibroDAOImpl
	//credo quindi questo oggetto:
	LibroDAOImpl libroDaoImpl = new LibroDAOImpl();
	
	//il costruttore non lo metto xk tanto di default c'è già quello vuoto.
	
	//creo il metodo che mi restituisce solo l'elenco dei titoli
	Set<String> getTitoli(){//set restituisce una lista disordinata senza doppioni, quindi lo uso.
		
		Set<String> titoli = new TreeSet();
		List<Libro> tuttiLibri = libroDaoImpl.findAll();//chiedo tutti i libri e li salvo in una variabile con tipo ArrayList
		for (Libro libro : tuttiLibri) {
			titoli.add(libro.getTitolo());
		}
		
		return titoli;
	}
}
