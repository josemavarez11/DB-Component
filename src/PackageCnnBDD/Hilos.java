
package PackageCnnBDD;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;

public class Hilos extends Thread{
	private ConexionBDD con;
	private int idhilo;
	private long espera;
	
	public void setCon(ConexionBDD con, int idhilo, long espera) {
		this.con = con;
		this.idhilo = idhilo;
		this.espera = espera;
	}
	
	public void run() {
		System.out.println("Consulta hilo #" + this.idhilo + " activo");
		try {
			this.con.setOcupada(true);
			
			DBComponent dbc = new DBComponent(con);
			dbc.append("flo", "strlike");
			
			ResultSet rs = dbc.execute("selectid");
			int i = 1;
			while(rs.next()) {
				Thread.sleep(this.espera);
				System.out.println("HILO: " + this.idhilo + "--" + (i++) + "--" + rs.getString(1) + "--"  + rs.getString(2));
			}
			System.out.println("Fin del hilo #" + this.idhilo);
			rs.close();
			this.con.setOcupada(false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

