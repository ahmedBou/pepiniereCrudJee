package metier.entities;


public class Plantes {

	
	private long id;
	private String nom;
	private double prix;
	private int quantite;
	
	public Plantes() {
		super();
	}
	public Plantes(long id, String nom, double prix, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Plantes(String nom, double prix, int quantite) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Plantes [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	
	
}
