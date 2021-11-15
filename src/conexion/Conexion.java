package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Conexion instance;
	private Connection cnn;
	
	private Conexion() {
		try {
			cnn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/biblioteca?", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public synchronized static Conexion saberEstado() {
		if(instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	public Connection getCnn() {
		return cnn;
	}
	
	public void cerrarConexion() {
		instance = null;
	}

}
