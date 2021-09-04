package tierraMedia;

public class Atraccion implements Sugeribles {
	
	
	private int costoVisita;
	private double tiempoParaRealizarla;
	private int cupoPersonas;
	private TipoDeAtracciones tipoDeAtraccion;
	private int visitantes;
	private String nombre;
		
	// constructor
	public Atraccion(int costo, double tiempo, int cupo, TipoDeAtracciones tipoAtraccion, String nombre ) {
		this.setCostoVisita(costo);
		this.setTiempoParaRealizarla(tiempo);
		this.setCupoPersonas(cupo); 
		this.setTipoDeAtraccion(tipoAtraccion); 
		this.visitantes = 0;
		this.nombre = nombre;	
	}
	
	@Override
	public boolean esCupoCompleto() {
		return this.visitantes == this.cupoPersonas;
	}
		
		
	public void agregarVisitante() {
		if (this.visitantes >= this.cupoPersonas) {
			Error cupoCompleto = new Error("el cupo de la atracción "+ this.nombre + " esta completo");
			throw cupoCompleto;
		}
					
		this.visitantes += 1;
	}

	// getters y setters
	@Override
	public int getCostoVisita() {	
		return this.costoVisita;
	}
		
	@Override
	public void setCostoVisita(int costoVisita) {
		if (costoVisita < 0) {
			Error costoNegativo = new Error("El costo de la atracción "+ this.nombre + " no puede ser negativo");
			throw costoNegativo;
		}
		
		this.costoVisita = costoVisita;
	}

	@Override
	public double getTiempoParaRealizarla() {
		return this.tiempoParaRealizarla;
	}

	@Override
	public void setTiempoParaRealizarla(double tiempoParaRealizarla) {
		if (tiempoParaRealizarla <= 0) {
			Error tiempoInvalido = new Error("El tiempo que insume visitar la atracción "+ this.nombre + " no puede ser cero ni negativo");
			throw tiempoInvalido;
		}
		
		this.tiempoParaRealizarla = tiempoParaRealizarla;
	}

	@Override
	public int getCupoPersonas() {	
		return this.cupoPersonas;
	}

	@Override
	public void setCupoPersonas(int cupoPersonas) {
		if (cupoPersonas <= 0) {
			Error cupoPersonasInvalido = new Error("El cupo de personas de la atracción "+ this.nombre + " no puede ser cero ni negativo");
			throw cupoPersonasInvalido;
		}
		
		this.cupoPersonas = cupoPersonas;
	}

	
	@Override
	public TipoDeAtracciones getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}
		
	// ¿Cómo valído que tipo de atracción sea de tipo enumerado correcto?
	@Override
	public void setTipoDeAtraccion(TipoDeAtracciones tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public int getVisitantes() {
		return this.visitantes;
	}

	@Override
	public void setVisitantes(int visitantes) {
		if (visitantes < 0) {
			Error visitantesNegativo = new Error("El número de visitantes de la atracción "+ this.nombre + " no puede ser negativo");
			throw visitantesNegativo;
		}
			
		this.visitantes = visitantes;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {	
		this.nombre = nombre;
	}

}
