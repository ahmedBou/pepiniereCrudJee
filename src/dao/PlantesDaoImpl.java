package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Plantes;

public class PlantesDaoImpl implements PlantesDao{
	// quand on implement une interface il faut redefinir les methodes
	
	@Override
	public Plantes save(Plantes p) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(""
					+ "INSERT INTO plantes(nom,quantité, prix)VALUES(?,?,?)");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement(""
					+ "SELECT MAX(id) as MAX_ID FROM plantes");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			
			// fermer l'objet preparedStatement
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}

	@Override
	public List<Plantes> nmPlantes(String nm) {
		List <Plantes> plantes = new ArrayList<Plantes>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(""
					+ "SELECT * FROM plantes WHERE nom LIKE ?");
			ps.setString(1, nm);
			// execute la requette
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Plantes p = new Plantes();
				p.setId(rs.getLong("id"));
				p.setNom(rs.getString("nom"));
				p.setQuantite(rs.getInt("quantité"));
				p.setPrix(rs.getDouble("prix"));
				plantes.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// apres la creation du plantes et le stockage je retourne la liste des plantes
		return plantes;
	}

	@Override
	public Plantes getPlante(Plantes id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	@Override
	public void delete(long id) {
Connection connection = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(""
					+ "delete from plantes where id= ?");
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

	@Override
	public ArrayList<Plantes> getPlantes() {
		ArrayList<Plantes> plantes = new ArrayList<Plantes>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement sp = connection.prepareStatement("select * from plantes");
			ResultSet rs = sp.executeQuery();
			while(rs.next()) {
				int a = rs.getInt(1);
				String d = rs.getString(2);
				int c = rs.getInt(3);
				double b = rs.getDouble(4);
				Plantes  p = new Plantes(d, b, c);
				plantes.add(p);	
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantes;
	}

	@Override
	public void update(Plantes p) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"UPDATE plantes SET nom =? , quantité= ?, prix= ? WHERE id = ?");
	        
			ps.setString(1, p.getNom());
	        ps.setLong(2, p.getQuantite());
	        ps.setDouble(3, p.getPrix());
	        ps.setLong(4, p.getId());
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
