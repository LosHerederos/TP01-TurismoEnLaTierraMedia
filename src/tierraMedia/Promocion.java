package tierraMedia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Promocion implements Sugeribles {
	protected String nombre;
	private List<Atraccion> atracciones = new ArrayList<>();
	private TipoDeAtracciones tipoDeAtraccion;

	public Promocion(String nombre, List<Atraccion> atracciones) {
		this.setNombre(nombre);
		this.setAtraccion(atracciones);
		this.setTipodeAtraccion();
	}

	public Promocion() {
		this.setNombre(null);
//		this.setAtraccion(null);
		this.setTipodeAtraccion();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAtraccion(List<Atraccion> atracciones) {
		this.atracciones.addAll(atracciones);
	}

	public List<Atraccion> getAtraccion() {
		return (atracciones);
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : atracciones) {

			costoTotal += atraccion.getCosto();

		}

		return (costoTotal);

	}

	@Override
	public double getTiempo() {

		double tiempoTotal = 0;
		for (Atraccion atraccion : atracciones) {

			tiempoTotal += atraccion.getTiempo();

		}

		return (tiempoTotal);

	}

	@Override
	public void agregarVisitante() {
		if (!this.esCupoCompleto()) {
			for (Atraccion atraccion : atracciones) {
				atraccion.agregarVisitante();
			}

		}
	}

	@Override
	public boolean esCupoCompleto() {
		boolean cupoCompleto = false;

		Iterator<Atraccion> atraccion = atracciones.listIterator();
		while (atraccion.hasNext())  {
			 if(atraccion.next().esCupoCompleto()) {
			cupoCompleto = atraccion.next().esCupoCompleto();
			 }
		}
		return cupoCompleto;

	}

	public String getNombreDeAtraccion() {
		String nombreAtraccion = "";
		for (Atraccion atraccion : atracciones) {
			nombreAtraccion += atraccion.getNombre() +"\t\n";
		}
		return nombreAtraccion;

	}

	public void setTipodeAtraccion() {
		this.tipoDeAtraccion = atracciones.get(0).getTipoDeAtraccion();
	}

	@Override
	public TipoDeAtracciones getTipoDeAtraccion() {
		return (this.tipoDeAtraccion);
	}

	abstract String reduccionCostoTotal();

	@Override
	public String toString() {
		return this.nombre + "\t\t\t" + this.tipoDeAtraccion + "\t" + this.getCosto() + "\t" + this.getTiempo() + "\t"
				+ this.getNombreDeAtraccion();
	}
}
