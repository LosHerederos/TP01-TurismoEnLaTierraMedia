package tierraMedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAXB extends Promocion {
	List<Atraccion> atraccionesPagas = new ArrayList<Atraccion>();

	public PromocionAXB(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);
//		super.setNombre(nombre);
//		super.setAtraccion(atracciones);
//		super.setTipodeAtraccion();
		
	}
	
	public String getAtraccionesPagas() {
		String nombreAtraccion ="";
		for(Atraccion atracciones : atraccionesPagas) {
			nombreAtraccion = atracciones.getNombre();
		}
		return(nombreAtraccion);
			
	}


	public void setAtraccionesPagas(Atraccion atraccionesPagas) {
		this.atraccionesPagas.add(atraccionesPagas);
	}


	@Override
	public String reduccionCostoTotal() {
		return (super.getNombre()+ ":" + "Comprando "+ getAtraccionesPagas() + super.getAtraccion() + "gratis");
	}

}
