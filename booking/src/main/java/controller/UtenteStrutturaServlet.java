package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.UtenteStruttura;
import service.UtenteStrutturaService;
import service.UtenteStrutturaServiceImpl;

/**
 * Servlet implementation class UtenteStrutturaServlet
 */
public class UtenteStrutturaServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UtenteStrutturaService utenteStrutturaService = new UtenteStrutturaServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtenteStrutturaServlet() {
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
			
			UtenteStruttura utenteStruttura = this.utenteStrutturaService.login(request.getParameter("email"), request.getParameter("password"));
		    
			HttpSession session = request.getSession();
			session.setAttribute("utenteStruttura", utenteStruttura);
			
		    String utenteStrutturaString = this.gson.toJson(utenteStruttura);
		    
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(utenteStrutturaString);
	        out.flush();
			
			break;
		}
		
		case "signin": {
			
			UtenteStruttura utenteStruttura = new UtenteStruttura();
			
			utenteStruttura.setEmail(request.getParameter("email"));
			utenteStruttura.setNumeroTelefono(Integer.parseInt(request.getParameter("numeroTelefono")));
			utenteStruttura.setPassword(request.getParameter("password"));
			
			HttpSession session = request.getSession();
			session.setAttribute("utenteStruttura", utenteStruttura);
			
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.utenteStrutturaService.registra(utenteStruttura)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			
			break;
		}
		
		case "update":{
			UtenteStruttura utenteStruttura = new UtenteStruttura();
			
			utenteStruttura.setEmail(request.getParameter("email"));
			utenteStruttura.setNumeroTelefono(Integer.parseInt(request.getParameter("numeroTelefono")));
			utenteStruttura.setPassword(request.getParameter("password"));
			utenteStruttura.setIdUtenteStruttura (Long.parseLong(request.getParameter("idUtenteStruttura")));
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.utenteStrutturaService.update(utenteStruttura)) {
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
			
			if(this.utenteStrutturaService.delete(Long.parseLong(request.getParameter("idUtenteStruttura")))) {
				out.println("UtenteStruttura eliminato");
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
		doGet(request, response);
	}

}
