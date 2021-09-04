package tierraMedia;

import java.util.LinkedList;
import java.util.List;

public abstract class Promocion implements Sugeribles {
	private String nombre;
	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private TipoDeAtracciones tipoDeAtracciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAtraccion(Atraccion atraccion) {
		atracciones.add(atraccion);
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre() == this.getNombre()) {
				costoTotal += atraccion.getCosto();
			}

		}

		return (costoTotal);

	}

	@Override
	public double getTiempo() {

		int tiempoTotal = 0;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre() == this.getNombre()) {
				tiempoTotal += atraccion.getCosto();
			}

		}

		return (tiempoTotal);

	}

	@Override
	public TipoDeAtracciones getTipoDeAtracciones() {
		return (this.tipoDeAtracciones);
	}

	abstract double reduccionCostoTotal(Double valor);
}
