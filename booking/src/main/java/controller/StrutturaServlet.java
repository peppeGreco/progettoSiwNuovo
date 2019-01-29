package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Struttura;
import model.UtenteStruttura;
import service.StrutturaService;
import service.StrutturaServiceImpl;


/**
 * Servlet implementation class StrutturaServlet
 */
public class StrutturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson = new Gson();
	private StrutturaService strutturaService = new StrutturaServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StrutturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		switch(action) {
				
		case "create": {
			
			Struttura struttura = new Struttura();
			
			HttpSession session = request.getSession();
			session.setAttribute("struttura", struttura);
		
			struttura.setUtenteStruttura((UtenteStruttura) session.getAttribute("utenteStruttura"));
			struttura.setNome(request.getParameter("nome"));
			struttura.setCitta(request.getParameter("citta"));
			
			String strutturaString = this.gson.toJson(struttura);
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.strutturaService.create(struttura)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			
			break;
		}
		
		case "update":{
			Struttura struttura = new Struttura();
			
			struttura.setNome(request.getParameter("nome"));
			struttura.setCitta(request.getParameter("citta"));
			struttura.setIdStruttura (Long.parseLong(request.getParameter("idStruttura")));
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.strutturaService.update(struttura)) {
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
			
			if(this.strutturaService.delete(Long.parseLong(request.getParameter("idStruttura")))) {
				out.println("Struttura eliminata");
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
