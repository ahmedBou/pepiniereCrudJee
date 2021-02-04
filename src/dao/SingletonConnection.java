package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	// pour l orm ,il faut la class singleton(pour ne pas creer une connexion a chaque requette , qui sera lourd pr le serveur)
	// une seule connection qlque soit le nbre d'utilisateur, ce qui va permettre d'economiser les ressource au niveau de 
	// serveur ainsi qu'aux db.
	
	// creer un objet static de type connection
	private static Connection connection;
	
	// quand une class est chargée au mémoire, c'est le bloc static qui s'execute le premier
	static {
		//pr creer la connection, j'ai besoin de charger le pilote jdbc
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creer la connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pepiniere?autoReconnect=true&useSSL=false","root", "root");
		} catch (Exception e) { // si le pilote n'existe pas
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// methode qui retourner l'objet connection qui deja creer au moment de chargment de la class au memoire
	public static Connection getConnection() {
		return connection;
	}
	
	
	
}
