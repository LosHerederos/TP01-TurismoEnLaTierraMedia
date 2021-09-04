package tierraMedia;

import java.io.IOException;

public class SistemaDeSugerencias {

	String mensaje = "A la Tierra Media!";

	public SistemaDeSugerencias() {
		Usuario usuario = new Usuario();
		System.out.println(mensaje);
		Archivos.cargarUsuarios();
		Archivos.cargarAtracciones();
		Archivos.cargarPromociones();
		
		try {
			Archivos.generarArchivoDeSalida(usuario, "miArchivo.out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
