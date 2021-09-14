package tierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromocionTest {

	@Test
	public void test() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		List<Atraccion> otrasAtracciones = new ArrayList<Atraccion>();
		Promocion promoPorcentual = new PromocionPorcentual("Mi Promo Porcentual", atracciones, 10.0);
		Promocion promoAbsoluta = new PromocionAbsoluta("Mi Promo Absoluta", atracciones, 30);
		Promocion promoAxB = new PromocionAXB("Mi Promo AxB", atracciones, otrasAtracciones);
	}

}
