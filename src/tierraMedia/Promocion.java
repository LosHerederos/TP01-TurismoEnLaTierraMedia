package tierraMedia;

// Comentario
public abstract class Promocion implements Sugeribles {
	private String nombre;
	private Atraccion atracciones[];
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return (0);
	}

	public double getTiempo() {
		return (0);
	}

	public TipoDeAtracciones getTipoDeAtraccion() {
		return null;
	}

	abstract double reduccionCostoTotal();
}
