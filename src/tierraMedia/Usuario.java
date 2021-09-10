package tierraMedia;

import java.util.Objects;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private Itinerario itinerario;
	private double tiempoDisponible;
	private TipoDeAtracciones tipoFavorito;
	
	public Usuario() {
		this.nombre = "";
		this.presupuesto = 0;
		this.itinerario = null;
		this.tiempoDisponible = 0;
		this.tipoFavorito = null;
	}
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible,
			TipoDeAtracciones tipoFavorito) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.itinerario = new Itinerario();
		this.tiempoDisponible = tiempoDisponible;
		this.tipoFavorito = tipoFavorito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoDeAtracciones getTipoFavorito() {
		return tipoFavorito;
	}

	public void setTipoFavorito(TipoDeAtracciones tipoFavorito) {
		this.tipoFavorito = tipoFavorito;
	}
	
	public void aceptarSugerencia(Promocion promo) {
		this.itinerario.getPromociones().add(promo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipoFavorito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && tipoFavorito == other.tipoFavorito;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\t\tTipo de Atracción: " + this.tipoFavorito;
	}
	
	

}
