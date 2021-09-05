package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private double porcentaje;

	public PromocionPorcentual(String nombre, List<Atraccion> atracciones, double porcentaje) {
		super.setNombre(nombre);
		super.setAtraccion(atracciones);
		super.setTipodeAtraccion();
		this.setPorcentaje(porcentaje);
	}
	
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	private double getPorcentaje() {
		return(this.porcentaje);
	}

	@Override
	public double reduccionCostoTotal(Double valor) {
		return calculoPromocion(valor);
	}

	private double calculoPromocion(Double procentaje) {
		double total = 0;
		total += super.getCosto();
		return total - (total * getPorcentaje());
	}

}
