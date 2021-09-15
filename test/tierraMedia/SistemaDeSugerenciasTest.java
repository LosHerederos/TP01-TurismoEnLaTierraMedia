package tierraMedia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaDeSugerenciasTest {
	
	@Before
	public void setup() {
		
		Archivos.rutaDeArchivos = "archivos/test/";
		Archivos.archivoDeUsuarios = "usuariosTest2.in";
		Archivos.archivoDeAtracciones = "atraccionesTest2.in";
		Archivos.archivoDePromociones = "promocionesTest2.in";
		Archivos.prefijoDeArchivoDeSalida = "%sTest2.out";
		
	}

	@Test
	public void test() {
		SistemaDeSugerencias sistema = new SistemaDeSugerencias();
	}

}
