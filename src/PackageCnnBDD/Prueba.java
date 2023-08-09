package PackageCnnBDD;

public class Prueba {

	public static void main(String[] args) throws InterruptedException {
		Pool.crearPool(5);//se crea un pool de n conexiones
		int nHilos = 10;
		long timeEspera = 1;
		
		System.out.println("---INICIO DE CONSULTAS---");
		int i = 0;
		while(i < nHilos) {
			ConexionBDD cnn = Pool.getPool();
			if(cnn != null) {
				Hilos h = new Hilos();
				h.setCon(cnn, i+1, i * timeEspera);
				h.start();
				i++;
			}
			else {
				System.out.println("Conexion ocupada, Hilo " + (i+1) + " esperando...");
				Thread.sleep(100);
			}
		}
		System.out.println("Fin del Programa Principal");
	}
	
}
