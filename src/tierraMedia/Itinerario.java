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
	
	public double horasNecesarias() {
		double horas = 0;
		for (Promocion promo : promociones) {
		//	horas += promo.getTiempo;
		}
		return horas;
	}
	
	public int costoTotal() {
		int total = 0;
		for (Promocion promo : promociones) {
		//	total+=promo.getCosto();
		}
		return total;
	}
	
	private boolean atracionIncluida(Atraccion atraccion) {
		return atracciones.contains(atraccion);
	}

	@Override
	public String toString() {
		return "Itinerario [atracciones=" + atracciones + ", promociones=" + promociones + "]";
	}
	
	
	
}