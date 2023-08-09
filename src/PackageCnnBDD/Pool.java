package PackageCnnBDD;

import java.util.ArrayList;

public class Pool {
	private static ArrayList<ConexionBDD> pool = new ArrayList<ConexionBDD>();
	private static int nCnn;

	public static ConexionBDD getPool() throws InterruptedException {
		int idConex = -1;
		
		for(int cnn = 0; cnn < nCnn; cnn++) {
			if(!((ConexionBDD)pool.get(cnn)).getOcupada()) {
				idConex = cnn;
			}
			else {
				System.out.println("No hay conexiones disponibles, reintente...");
				Thread.sleep(100);
			}
		}
		if (idConex != -1)
			return (ConexionBDD)pool.get(idConex);
		else 
			return null;
	}
	
	public static void crearPool(int nCn) {
		nCnn = nCn;

		for(int cnn = 0; cnn < nCnn; cnn++) {
			pool.add(new DBComponent("src/config.properties", "src/queries.porperties").getConexion());
			System.out.println("Conexion " + (cnn+1));
		}
	}
}
