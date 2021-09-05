package tierraMedia;


/*
 * 
 * Revisar
public interface Sugeribles {
	
	public static int costo=0;
	
	public static double Tiempo=0;	
		
	
	public int getCosto();
	
	public double getTiempo();
	
	public TipoDeAtracciones getTipoDeAtraccion();
*/
	



public interface Sugeribles {
	//public boolean esCupoCompleto(); 
	//public void agregarVisitante(); 
	abstract public int getCosto(); 
	//public void setCostoVisita(int costoVisita); 
	abstract public double getTiempo();
	//public void setTiempoParaRealizarla(double tiempoParaRealizarla);
	//public int getCupoPersonas();
	//public void setCupoPersonas(int cupoPersonas); 
	//public int getVisitantes();
	//public void setVisitantes(int visitantes);
    //public String getNombre();
    //public void setNombre(String nombre);
	abstract TipoDeAtracciones getTipoDeAtracciones();
	//void setTipoDeAtraccion(TipoDeAtracciones tipoDeAtraccion);	
	//TipoDeAtracciones getTipoDeAtracciones();
    
}

