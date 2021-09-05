package tierraMedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAXB extends Promocion {
	List<Atraccion> AtraccionesPagas = new ArrayList<Atraccion>();

	public PromocionAXB(String nombre, List<Atraccion> atracciones) {
		super();
		super.setNombre(nombre);
		super.setAtraccion(atracciones);
		super.setTipodeAtraccion();
		
	}
	
	public List<Atraccion> getAtraccionesPagas() {
		return AtraccionesPagas;
	}


	public void setAtraccionesPagas(Atraccion atraccionesPagas) {
		AtraccionesPagas.add(atraccionesPagas);
	}


	@Override
	public double reduccionCostoTotal(Double valor) {
		return (0);
	}

}
