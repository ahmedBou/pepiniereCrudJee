package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlantesDao;
import dao.PlantesDaoImpl;
import metier.entities.Plantes;


public class ContServlet extends HttpServlet{
	// ici on utilise le couplage faible, si l'interface est modifié alors on risque rien
	//private PlantesDao metier;
	PlantesDaoImpl	metier = new PlantesDaoImpl();
	@Override
	public void init() throws ServletException {
		// ici on utilise le couplage fort		
	
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		System.out.println("the path is"+path);
		
		if(path.equals("/index.do")){
			
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);
		}
		else if(path.equals("/search.do")){
			String toSearchFlower = req.getParameter("nm");
			System.out.println(toSearchFlower);
			//PlantesModel modelPl = new PlantesModel();
			//modelPl.setNm(toSearchFlower);
			//System.out.println("set nom plante dans le model"+modelPl);
		
			
			List<Plantes> plantes = metier.nmPlantes("%"+toSearchFlower+"%");
			System.out.println("la liste de plante a chercher"+plantes.toString());
			
			//modelPl.setPl(plantes);
			//System.out.println("liste dans modelPlante"+modelPl);
			req.setAttribute("plantes", plantes);
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);
		}
		else if(path.equals("/getId.do")) {
			String modId = req.getParameter("id");
			long id = Long.parseLong(modId);
			req.setAttribute("id", id);		
			req.getRequestDispatcher("modPlantes.jsp").forward(req, resp);
			
		}else if(path.equals("/delete.do")){
			long id = Long.parseLong(req.getParameter("id"));
			System.out.println("the id to be deleted is: "+id);
			metier.delete(id);
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);
		}
		else {
			resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println("the path is"+path);
		if(path.equals("/add.do")) {
			String addPl = req.getParameter("nm");
			String addQt = req.getParameter("qt");
			String addPx = req.getParameter("px");
			
			Plantes p = new Plantes(addPl,Double.parseDouble(addPx), Integer.parseInt(addQt));
			
			metier.save(p);
			req.setAttribute("p", p);
			req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
			
		}else if(path.equals("/modify.do")) {
			String modPl = req.getParameter("nm");
			String modQt = req.getParameter("qt");
			String modPx = req.getParameter("px");
			String modId = req.getParameter("id");
			Plantes modP = new Plantes(Long.parseLong(modId) ,modPl,Double.parseDouble(modPx), Integer.parseInt(modQt));
		
			metier.update(modP);
			req.setAttribute("p", modP);
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);	
		}	
		
	}
	
}
