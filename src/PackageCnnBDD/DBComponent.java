package PackageCnnBDD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DBComponent {
	private ArrayList<Params> arrayParams = new ArrayList<Params>();
	private Properties queries = null;
	private ConexionBDD conexion;
	
	public DBComponent(ConexionBDD conexion) {
		this.conexion = conexion;
		queries = new Properties();
		try {
			queries.load(new FileInputStream(new File("src/queries.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public DBComponent(String ruta_bdd, String ruta_queries) {
		setConexion(new ConexionBDD(ruta_bdd));
	}
	
	public ConexionBDD getConexion() {
		return conexion;
	}
	
	public void setConexion(ConexionBDD conexion) {
		this.conexion = conexion;
	}
	
	public void append(String valor, String tipo) {
		Params p = new Params();
		
		p.setParmsValue(""+valor);
		p.setParamsType(tipo);
		arrayParams.add(p);
	}
	
	public ResultSet execute(String nQuery) {
		String nmQuery = queries.getProperty(nQuery);
		
		try {
			for (int i = 0; i < arrayParams.size(); i++) {
				nmQuery = nmQuery.replace("?", arrayParams.get(i).getParmsValue());
			}
		
			Statement stmt = this.conexion.getConexion().createStatement();
			stmt.executeQuery(nmQuery);
			return stmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
