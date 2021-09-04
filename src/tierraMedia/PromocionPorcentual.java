package tierraMedia;

public class PromocionPorcentual extends Promocion {
	private final double porcentajeDeDescuento = 0.2;
	//archivo de promociones nombre de la atraccion y tipo de promocion
	private String archivo[][];
	private Atraccion atracciones[];

	@Override
	protected double reduccionCostoTotal() {
		return calculoPromocion();
	}
	
	

	private double calculoPromocion() {
		int total = 0;
		for (int i = 0; i < atracciones.length; i++) {
			if(TipoDeAtracciones.S)
			total += atracciones[i].getCostoVisita();

		}

		return total - (total * porcentajeDeDescuento);
	}

}
//Booleano con un atributo llamado esta en promocion, tipo,
//Las promociones se agregan a un array de itinerarios 