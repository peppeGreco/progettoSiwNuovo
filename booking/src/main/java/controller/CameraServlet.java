package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Camera;
import model.Struttura;
import service.CameraService;
import service.CameraServiceImpl;


/**
 * Servlet implementation class CameraServlet
 */
public class CameraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson = new Gson();
	private CameraService cameraService = new CameraServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CameraServlet() {
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
			
			Camera camera = new Camera();
			
			HttpSession session = request.getSession();
			
			
//			camera.setStruttura((Struttura) session.getAttribute("struttura"));
			camera.setStruttura(new Struttura());
			camera.getStruttura().setIdStruttura(Long.valueOf(request.getParameter("idStruttura")));
			camera.setNumeriPostiLetto(Integer.parseInt(request.getParameter("numeroPostiLetto")));
			camera.setNumeroMatrimoniali(Integer.parseInt(request.getParameter("numeroMatrimoniali")));
			camera.setNumeroSingoli(Integer.parseInt(request.getParameter("numeroSingole")));
			camera.setOccupata(Boolean.valueOf(request.getParameter("occupata")));
			camera.setPrezzo(Double.valueOf(request.getParameter("prezzo")));
			
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.cameraService.create(camera)) {
				out.println(HttpServletResponse.SC_CREATED);
			}
			else {
				out.println(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			
			break;
		}
		
		case "update":{
			Camera camera = new Camera();
			
			camera.setNumeriPostiLetto(Integer.parseInt(request.getParameter("numeroPostiLetto")));
			camera.setNumeroMatrimoniali(Integer.parseInt(request.getParameter("numeroMatrimoniali")));
			camera.setNumeroSingoli(Integer.parseInt(request.getParameter("numeroSingole")));
			camera.setOccupata(Boolean.valueOf(request.getParameter("occupata")));
			camera.setPrezzo(Double.valueOf(request.getParameter("prezzo")));
			
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
			if(this.cameraService.update(camera)) {
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
			
			if(this.cameraService.delete(Long.parseLong(request.getParameter("numeroCamera")))) {
				out.println("Camera eliminata");
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
