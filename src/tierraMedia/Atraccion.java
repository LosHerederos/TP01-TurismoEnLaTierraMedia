package tierraMedia;

public class Atraccion implements Sugeribles {
	enum Tipo {Aventura, Paisaje, Degustaci�n, terror};
	
	private int costoVisita;
	private int tiempoParaRealizarla;
	private int cupoPersonas;
	private Tipo tipoDeAtraccion;
	private int visitantes;
	private String nombre;
		
	// constructor
	public Atraccion(int costo, int tiempo, int cupo, Tipo tipoAtraccion, String nombre ) {
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
			Error cupoCompleto = new Error("el cupo de la atracci�n "+ this.nombre + " esta completo");
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
		if (this.costoVisita < 0) {
			Error costoNegativo = new Error("El costo de la atracci�n "+ this.nombre + " no puede ser negativo");
			throw costoNegativo;
		}
		
		this.costoVisita = costoVisita;
	}

	@Override
	public int getTiempoParaRealizarla() {
		return this.tiempoParaRealizarla;
	}

	@Override
	public void setTiempoParaRealizarla(int tiempoParaRealizarla) {
		if (this.tiempoParaRealizarla <= 0) {
			Error tiempoInvalido = new Error("El tiempo que insume visitar la atracci�n "+ this.nombre + " no puede ser cero ni negativo");
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
		if (this.cupoPersonas <= 0) {
			Error cupoPersonasInvalido = new Error("El cupo de personas de la atracci�n "+ this.nombre + " no puede ser cero ni negativo");
			throw cupoPersonasInvalido;
		}
		
		this.cupoPersonas = cupoPersonas;
	}

	@Override
	public Tipo getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}
		
	// �C�mo val�do que tipo de atracci�n sea de tipo enumerado correcto?
	@Override
	public void setTipoDeAtraccion(Tipo tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public int getVisitantes() {
		return this.visitantes;
	}

	@Override
	public void setVisitantes(int visitantes) {
		if (this.visitantes < 0) {
			Error visitantesNegativo = new Error("El n�mero de visitantes de la atracci�n "+ this.nombre + " no puede ser negativo");
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
