package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.AppuntamentoDAO;
import dal.AppuntamentoDAOImpl;
import model.Appuntamento;


@WebServlet("/add")
public class AggiungiAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppuntamentoDAO ad; 
	
       
    
    public AggiungiAppuntamento() {
        super();
        this.ad = new AppuntamentoDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("add", ad.findAll());
			request.getRequestDispatcher("form.html").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		Date data = Date.valueOf(request.getParameter("data"));
		Time oraInizio = Time.valueOf(request.getParameter("oraInizio"));
		Time OraFine = Time.valueOf(request.getParameter("OraFine"));
		String argomento = request.getParameter("argomento");
		
		Appuntamento nuovoApp = new Appuntamento(0, idUtente, data, oraInizio, OraFine, argomento);
		ad.addAppuntamento(nuovoApp);
		
		
		doGet(request, response);
	}

}
