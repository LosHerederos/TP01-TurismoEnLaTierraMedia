package tierraMedia;
import java.util.Comparator;

public class OrdenadorPorPrecioYTiempo implements Comparator<Promocion> {

	@Override
	public int compare(Promocion promocion, Promocion otroPromocion) {
		if (Integer.compare(promocion.getCosto(),otroPromocion.getCosto()) == 0){
			return Double.compare(promocion.getTiempo(), otroPromocion.getTiempo()) * -1;
		}
		return Integer.compare(promocion.getCosto(), 
				otroPromocion.getCosto()) * -1;
	}

}
