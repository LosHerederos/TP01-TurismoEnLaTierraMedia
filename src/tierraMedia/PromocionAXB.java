package tierraMedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAXB extends Promocion {
	List<Atraccion> atraccionesPagas = new ArrayList<Atraccion>();

	public PromocionAXB(String nombre, List<Atraccion> atracciones, List<Atraccion> atraccionesPagas) {
		super(nombre, atracciones);
		this.setAtraccionesPagas(atraccionesPagas);

	}

	//public String getAtraccionesPagas() {
	public List<Atraccion> getAtraccionesPagas() {
//		String nombreAtraccion = "";
//		for (Atraccion atracciones : atraccionesPagas) {
//			nombreAtraccion = atracciones.getNombre();
//		}
//		return (nombreAtraccion);
		return this.atraccionesPagas;
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atracciones : atraccionesPagas) {
			costoTotal = atracciones.getCosto();
		}
		return (costoTotal);
	}

	public void setAtraccionesPagas(List<Atraccion> atraccionesPagas) {
		this.atraccionesPagas.addAll(atraccionesPagas);
	}

	@Override
	public String reduccionCostoTotal() {
		return (super.getNombre() + ":" + "Comprando " + getAtraccionesPagas() + super.getAtraccion() + "gratis");
	}

}
