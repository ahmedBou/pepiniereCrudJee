package dao;

import java.util.List;

import metier.entities.Plantes;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlantesDaoImpl dao = new PlantesDaoImpl();
		Plantes p1 = dao.save(new Plantes("spathiphyllum", 1, 150));
		Plantes p2 = dao.save(new Plantes("lierre", 1, 120));
		try {
			System.out.println(p1.toString());
			
		}catch(NullPointerException e){
			System.out.println("NullPointerException thrown!");
		}
		System.out.println(p2.toString());
		
		List<Plantes> pl = dao.nmPlantes("spathiphyllum");
		System.out.println(pl);
		
		for(Plantes p: pl) {
			System.out.println(p);
		}
		
		
		
	}

}
