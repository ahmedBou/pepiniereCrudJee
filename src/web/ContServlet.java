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
	private PlantesDao metier;
	
	@Override
	public void init() throws ServletException {
		// ici on utilise le couplage fort		
		metier = new PlantesDaoImpl();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String path = req.getServletPath();
		System.out.println("the path is"+path);
		
		if(path.equals("/index.do")){
			//pour faire une avance vers la vue
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);
		}
		else if(path.equals("/search.do")){
			String toSearchFlower = req.getParameter("nm");
			System.out.println(toSearchFlower);
			PlantesModel modelPl = new PlantesModel();
			modelPl.setNm(toSearchFlower);
			System.out.println("set nom plante dans le model"+modelPl);
		
			
			List<Plantes> plantes = metier.nmPlantes("%"+toSearchFlower+"%");
			System.out.println("la liste de plante a chercher"+plantes.toString());
			
			modelPl.setPl(plantes);
			System.out.println("liste dans modelPlante"+modelPl);
			req.setAttribute("modelPl", modelPl);
			req.getRequestDispatcher("plantes.jsp").forward(req, resp);
		}
		else {
			resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
			}
	
	}
}
