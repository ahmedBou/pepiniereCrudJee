package dao;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Plantes;

public interface PlantesDao {
	// display plantes
	public Plantes save(Plantes p);
	// search plantes and return list of plantes
	public List<Plantes> nmPlantes(String nm);
	// consulter une plantes
	public Plantes getPlante(Plantes id);
	//consulter tous les plantes
	public ArrayList<Plantes> getPlantes();
	//modifier une plantes, mettre a jour l'objet plante y compris le id
	public void update(Plantes p);
	//suprimer une plantes
	public void delete(long id);
	
}
