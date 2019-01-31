package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;

import model.Camera;
import model.Prenotazione;
import model.ServiziAutorizzazioniPagamento;
import model.Struttura;
import model.Utente;
import service.CameraService;
import service.CameraServiceImpl;
import service.PrenotazioneService;
import service.PrenotazioneServiceImpl;


/**
 * Servlet implementation class PrenotazioneServlet
 */
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Gson gson = new Gson();
	private PrenotazioneService prenotazioneService = new PrenotazioneServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");
		
		switch(action) {
				
		case "create": {
			
			Prenotazione prenotazione = new Prenotazione();
			
			Set<Camera> camere = new HashSet<>();
			double totale=0;
			
			Camera c1= new Camera();
			c1.setNumeroCamera((long) 3);
			c1.setNumeriPostiLetto(4);
			c1.setNumeroMatrimoniali(1);
			c1.setNumeroSingoli(2);
			c1.setOccupata(false);
			c1.setPrezzo(99.99);
			totale+=c1.getPrezzo();
			Struttura s = new Struttura();
			s.setIdStruttura((long) 1);
			c1.setStruttura(s);
			camere.add(c1);
			
			c1=new Camera();
			c1.setNumeroCamera((long) 4);
			c1.setNumeriPostiLetto(1);
			c1.setNumeroMatrimoniali(0);
			c1.setNumeroSingoli(1);
			c1.setOccupata(false);
			c1.setPrezzo(10.00);
			totale+=c1.getPrezzo();
			c1.setStruttura(s);
			camere.add(c1);
			
			prenotazione.setCamere(camere);
			
			prenotazione.setTotale(totale);
			
			HttpSession session = request.getSession();
			session.setAttribute("prenotazione", prenotazione);
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	        Date date = null;
			try {
				date = formatter.parse(request.getParameter("dataCheckIn"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			prenotazione.setCheckIn(date);
			

			date = null;
			try {
				date = formatter.parse(request.getParameter("dataCheckOut"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			prenotazione.setCheckOut(date);
			
			prenotazione.setUtente((Utente) session.getAttribute("utente"));
		
			Calendar c = Calendar.getInstance();
			
			if(c.getTime().before(prenotazione.getCheckIn())) {
				prenotazione.setScadenzaModifica(false);
			}
			else prenotazione.setScadenzaModifica(true);
			
			prenotazione.setServizioAutorizzazioniPagamento(new ServiziAutorizzazioniPagamento());
			prenotazione.getServizioAutorizzazioniPagamento().setIdServizioAutorizzazionePagamento((long) 1);
			
			
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.prenotazioneService.create(prenotazione)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			CameraService cs = new CameraServiceImpl();
			
			for (Camera camera : prenotazione.getCamere()) {
				camera.setPrenotazione((Prenotazione) session.getAttribute("prenotazione"));
				System.out.println(camera.getPrenotazione().getIdPrenotazione());
				cs.update(camera);
				
			}
			
			
			
			break;
		}
		
//		case "update":{
//			
//			Prenotazione prenotazione = new Prenotazione();
//			
//			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//	        Date date = null;
//			try {
//				date = formatter.parse(request.getParameter("dataCheckIn"));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			
//			prenotazione.setCheckIn(date);
//			
//
//			date = null;
//			try {
//				date = formatter.parse(request.getParameter("dataCheckOut"));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			
//			prenotazione.setCheckOut(date);
//			
//			Calendar c = Calendar.getInstance();
//			
//			if(c.getTime().before(prenotazione.getCheckIn())) {
//				prenotazione.setScadenzaModifica(false);
//			}
//			else prenotazione.setScadenzaModifica(true);			
//			
//			PrintWriter out = response.getWriter();
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("UTF-8");
//			
//			if(this.prenotazioneService.update(prenotazione)) {
//				out.println(HttpServletResponse.SC_CREATED);
//			}
//			else {
//				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			}
//			
//			
//			break;
//		}
//		
//		case "delete":{
//			
//			PrintWriter out = response.getWriter();
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("UTF-8");
//			
//			if(this.cameraService.delete(Long.parseLong(request.getParameter("numeroCamera")))) {
//				out.println("Camera eliminata");
//			}
//			else {
//				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			}
//			
//			break;
//		}
//		
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
