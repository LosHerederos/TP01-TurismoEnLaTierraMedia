package tierraMedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void test() {
		Usuario usuario = new Usuario("Pedro", 100, 10.0, TipoDeAtracciones.AVENTURA);
		Atraccion atraccion = new Atraccion(25, 2.5, 10, TipoDeAtracciones.AVENTURA, "Una aventura como ninguna");
		usuario.aceptarSugerencia(atraccion);
	}

}
