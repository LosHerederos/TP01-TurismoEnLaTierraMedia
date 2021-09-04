package tierraMedia;

public class PromocionAbsoluta extends Promocion {
	private int descuento;
	public PromocionAbsoluta(String nombre, Atraccion atraccion,int descuento){
		super();
		this.setNombre(nombre);
		this.setAtraccion(atraccion);
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
