package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int descuento;

	public PromocionAbsoluta(String nombre, List<Atraccion> atracciones, int descuento) {
		super();
		super.setNombre(nombre);
		super.setAtraccion(atracciones);
		super.setTipodeAtraccion();
		this.setDescuento(descuento);
	}

	public int getDescuento() {
		return descuento;
	}

	private void setDescuento(int descuento) {
		this.descuento = descuento;

	}

	@Override
	protected String reduccionCostoTotal() {
		return (super.getNombre()+ ":" + super.getAtraccion() + " " + "a monedas" + this.getDescuento() );
	}
}
