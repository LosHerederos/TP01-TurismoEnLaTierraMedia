package tierraMedia;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	
	public Itinerario() {
		this.atracciones = new ArrayList<>();
		this.promociones = new ArrayList<>();
	}
	
	public Itinerario(List<Atraccion> atracciones, List<Promocion> promociones) {
		super();
		this.atracciones = atracciones;
		this.promociones = promociones;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarSugerencia(Sugeribles sugerencia){
		if (sugerencia.getClass().equals(Atraccion.class)) {
			this.atracciones.add((Atraccion) sugerencia);
		} else {
			agregarPromocion((Promocion) sugerencia);
		}
		sugerencia.agregarVisitante();
	}
	
	private void agregarPromocion(Promocion promo) {
		this.promociones.add(promo);
		this.atracciones.addAll(promo.getAtraccion());
	}
	
	public double horasNecesarias() {
		double horas = 0;
		for (Promocion promo : promociones) {
			horas += promo.getTiempo();
		}
		return horas;
	}
	
	public int costoTotal() {
		int total = 0;
		for (Promocion promo : promociones) {
			total+=promo.getCosto();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Itinerario [atracciones=" + atracciones.toString() + ", promociones=" + promociones.toString() + "]";
	}
	
	
	
}