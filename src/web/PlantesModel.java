package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Plantes;

// le model permet de stocker les données qu'on va saisir
public class PlantesModel {

	// on va saisir le nom
	private String nm;
	
	// et on affiche comme resultat une liste de plantes
	private List<Plantes> pl = new ArrayList<Plantes>();

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public List<Plantes> getPl() {
		return pl;
	}

	public void setPl(List<Plantes> pl) {
		this.pl = pl;
	}

	@Override
	public String toString() {
		return "PlantesModel [nm=" + nm + ", pl=" + pl + "]";
	}
	
	
	
}
