package tierraMedia;

public class PromocionAbsoluta extends Promocion {
	private int descuento;
	PromocionAbsoluta(int descuento){
		this.setDescuento(descuento);
	}
	PromocionAbsoluta(){
		super();
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
