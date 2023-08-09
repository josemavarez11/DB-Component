package PackageCnnBDD;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;

public class ConexionBDD {
	private boolean ocupada;
	private Connection con = null;
	private Properties config = null;
	
	public ConexionBDD(String ruta_bdd) {
		try {
			this.config = new Properties();
			this.config.load(new FileInputStream(new File(ruta_bdd)));
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://"+config.getProperty("HOST")+":"+config.getProperty("PORT")+"/"+config.getProperty("BD"), config.getProperty("USER"), config.getProperty("PASS"));
			this.setOcupada(false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		return con;
	}

	public boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
}
