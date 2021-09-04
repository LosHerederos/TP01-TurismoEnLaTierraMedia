package tierraMedia;

public class PromocionPorcentual extends Promocion {
	
	@Override
	public double reduccionCostoTotal(Double valor) {
		return calculoPromocion(valor);
	}
	
	

	private double calculoPromocion(Double procentaje) {
		double total = 0;
			total += this.getCosto();
			return total - (total *  procentaje);
		}

		
	}

