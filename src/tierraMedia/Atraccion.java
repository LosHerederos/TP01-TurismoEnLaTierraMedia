package tierraMedia;

import java.util.Objects;

public class Atraccion implements Sugeribles {

	private int costoVisita;
	private double tiempoParaRealizarla;
	private int cupoPersonas;
	private TipoDeAtracciones tipoDeAtracciones;
	private int visitantes;
	private String nombre;

	// constructor
	public Atraccion(int costo, double tiempo, int cupo, TipoDeAtracciones tipoAtraccion, String nombre) {
		this.setCostoVisita(costo);
		this.setTiempoParaRealizarla(tiempo);
		this.setCupoPersonas(cupo);
		this.setTipoDeAtraccion(tipoAtraccion);
		this.visitantes = 0;
		this.nombre = nombre;
	}

	public boolean esCupoCompleto() {
		return this.visitantes == this.cupoPersonas;
	}

	public void agregarVisitante() {
		if (this.visitantes >= this.cupoPersonas) {
			Error cupoCompleto = new Error("el cupo de la atracci�n " + this.nombre + " esta completo");
			throw cupoCompleto;
		}

		this.visitantes += 1;
	}

	// getters y setters
	@Override
	public int getCosto() {
		return this.costoVisita;
	}

	public void setCostoVisita(int costoVisita) {
		if (costoVisita < 0) {
			Error costoNegativo = new Error("El costo de la atracci�n " + this.nombre + " no puede ser negativo");
			throw costoNegativo;
		}

		this.costoVisita = costoVisita;
	}

	@Override
	public double getTiempo() {
		return this.tiempoParaRealizarla;
	}

	public void setTiempoParaRealizarla(double tiempoParaRealizarla) {
		if (tiempoParaRealizarla <= 0) {
			Error tiempoInvalido = new Error(
					"El tiempo que insume visitar la atracci�n " + this.nombre + " no puede ser cero ni negativo");
			throw tiempoInvalido;
		}

		this.tiempoParaRealizarla = tiempoParaRealizarla;
	}

	public int getCupoPersonas() {
		return this.cupoPersonas;
	}

	public void setCupoPersonas(int cupoPersonas) {
		if (cupoPersonas <= 0) {
			Error cupoPersonasInvalido = new Error(
					"El cupo de personas de la atracci�n " + this.nombre + " no puede ser cero ni negativo");
			throw cupoPersonasInvalido;
		}

		this.cupoPersonas = cupoPersonas;
	}

	// �C�mo val�do que tipo de atracci�n sea de tipo enumerado correcto?
	@Override
	public TipoDeAtracciones getTipoDeAtraccion() {
		return (this.tipoDeAtracciones);
	}
	
	public void setTipoDeAtraccion(TipoDeAtracciones tipoDeAtraccion) {
		this.tipoDeAtracciones = tipoDeAtraccion;
	}

	public int getVisitantes() {
		return this.visitantes;
	}

	public void setVisitantes(int visitantes) {
		if (visitantes < 0) {
			Error visitantesNegativo = new Error(
					"El n�mero de visitantes de la atracci�n " + this.nombre + " no puede ser negativo");
			throw visitantesNegativo;
		}

		this.visitantes = visitantes;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
		
	@Override
	public int hashCode() {
		return Objects.hash(costoVisita, cupoPersonas, nombre, tiempoParaRealizarla, tipoDeAtracciones, visitantes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costoVisita == other.costoVisita && cupoPersonas == other.cupoPersonas
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoParaRealizarla) == Double.doubleToLongBits(other.tiempoParaRealizarla)
				&& tipoDeAtracciones == other.tipoDeAtracciones && visitantes == other.visitantes;
	}

	@Override
	public String toString() {
		return this.nombre
				+ "\t\t\t" + this.tipoDeAtracciones
				+ "\t\t" + this.costoVisita
				+ "\t" + this.tiempoParaRealizarla;
	}

}