package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Utente;
import service.UtenteService;
import service.UtenteServiceImpl;

/**
 * Servlet implementation class UtenteServlet       
 */

public class UtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Gson gson = new Gson();
	private UtenteService utenteService = new UtenteServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action) {
		
		case "login": {
			
			Utente utente = this.utenteService.login(request.getParameter("email"), request.getParameter("password"));
			
		    String utenteString = this.gson.toJson(utente);
		    
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(utenteString);
	        out.flush();
			
			break;
		}
		
		case "signin": {
			
			// localhost:8080/booking/UtenteServlet?action=signin&cartaDiCredito=1&civico=2&cognome=Greco&comune=Diamante&dataNascita=29-06-1993&email=greco@hotmail.it&nazionalita=italiana&nome=Giuseppe&numeroTelefono=1234&password=peppe&regione=Calabria&via=Via Fornaro
			Utente utente = new Utente();
			utente.setCartaDiCredito(Integer.parseInt(request.getParameter("cartaDiCredito")));
			utente.setCivico(request.getParameter("civico"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setComune(request.getParameter("comune"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	        Date date = null;
			try {
				date = formatter.parse(request.getParameter("dataNascita"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			utente.setDataNascita(date);
			
			utente.setEmail(request.getParameter("email"));
			utente.setNazionalita(request.getParameter("nazionalita"));
			utente.setNome(request.getParameter("nome"));
			utente.setNumeroTelefono(Integer.parseInt(request.getParameter("numeroTelefono")));
			utente.setPassword(request.getParameter("password"));
			utente.setRegione(request.getParameter("regione"));
			utente.setVia(request.getParameter("via"));
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.utenteService.registra(utente)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			
			break;
		}
		
		case "update":{
			Utente utente = new Utente();
			utente.setCartaDiCredito(Integer.parseInt(request.getParameter("cartaDiCredito")));
			utente.setCivico(request.getParameter("civico"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setComune(request.getParameter("comune"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	        Date date = null;
			try {
				date = formatter.parse(request.getParameter("dataNascita"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			utente.setDataNascita(date);
			
			utente.setEmail(request.getParameter("email"));
			utente.setNazionalita(request.getParameter("nazionalita"));
			utente.setNome(request.getParameter("nome"));
			utente.setNumeroTelefono(Integer.parseInt(request.getParameter("numeroTelefono")));
			utente.setPassword(request.getParameter("password"));
			utente.setRegione(request.getParameter("regione"));
			utente.setVia(request.getParameter("via"));
			utente.setIdUtente (Long.parseLong(request.getParameter("idUtente")));
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.utenteService.update(utente)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			
			break;
		}
		
		case "delete":{
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.utenteService.delete(Long.parseLong(request.getParameter("idUtente")))) {
				out.println("Utente eliminato");
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			break;
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
