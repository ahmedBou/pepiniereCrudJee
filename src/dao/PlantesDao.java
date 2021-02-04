package dao;

import java.util.List;

import metier.entities.Plantes;

public interface PlantesDao {
	// display plantes
	public Plantes save(Plantes p);
	// search plantes and return list of plantes
	public List<Plantes> nmPlantes(String nm);
	// consulter une plantes
	public Plantes getProduit(Plantes id);
	//modifier une plantes, mettre a jour l'objet plante y compris le id
	public Plantes update(Plantes p);
	//suprimer une plantes
	public void delete(long id);
	
}
