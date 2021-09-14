package tierraMedia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PromocionAXB extends Promocion {
	List<Atraccion> atraccionesPagas = new ArrayList<Atraccion>();

	public PromocionAXB(String nombre, List<Atraccion> atracciones, List<Atraccion> atraccionesPagas) {
		super(nombre, atracciones);
		this.setAtraccionesPagas(atraccionesPagas);

	}

	public List<Atraccion> getAtraccionesPagas() {
		return this.atraccionesPagas;
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : atraccionesPagas) {
			costoTotal += atraccion.getCosto();
		}
		return (costoTotal);
	}

	public void setAtraccionesPagas(List<Atraccion> atraccionesPagas) {
		this.atraccionesPagas.addAll(atraccionesPagas);
	}

	@Override
	public double getTiempo() {
		double tiempoTotal = 0;
		for (Atraccion atraccion : atraccionesPagas) {
			tiempoTotal += atraccion.getTiempo();
		}
		tiempoTotal += super.getTiempo();
		return (tiempoTotal);
	}
	@Override
	public void agregarVisitante() {
		if (!this.esCupoCompleto()) {
			for (Atraccion atraccion : atraccionesPagas) {
				atraccion.agregarVisitante();
			}

		}
	}
	@Override
	public boolean esCupoCompleto() {
		boolean cupoCompleto = false;

		Iterator<Atraccion> atraccion = atraccionesPagas.listIterator();
		while (atraccion.hasNext()) {
			if (atraccion.next().esCupoCompleto()) {
				cupoCompleto = true;
			}
		}
		return cupoCompleto;
	}
	@Override
	public String reduccionCostoTotal() {
		return (super.getNombre() + ":" + "Comprando " + getAtraccionesPagas() + super.getAtraccion() + "gratis");
	}

}
