package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.AppuntamentoDAO;
import dal.AppuntamentoDAOImpl;


@WebServlet("/appuntamenti")
public class AppuntamentiCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AppuntamentiCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppuntamentoDAO ad = new AppuntamentoDAOImpl();
		try {
			ad.findAll().forEach(a->{
				try {
					response.getWriter().append("<p>" + a + "</p>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("<a href=\"form.html\"></a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
