package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int descuento;
	public PromocionAbsoluta(String nombre, List<Atraccion> atracciones,int descuento){
		super();
		this.setNombre(nombre);
		this.setAtraccion((Atraccion) atracciones);
		this.setDescuento(descuento);
	}
	
	

	public int getDescuento() {
		return descuento;
	}
	private void setDescuento(int descuento) {
		this.descuento = descuento;
	
	}
	@Override
	protected double reduccionCostoTotal(Double valor) {	
		return(getDescuento());
	}
}
