package tierraMedia;

import tierraMedia.Atraccion.Tipo;

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
	public boolean esCupoCompleto(); 
	public void agregarVisitante(); 
	public int getCostoVisita(); 
	public void setCostoVisita(int costoVisita); 
	public int getTiempoParaRealizarla();
	public void setTiempoParaRealizarla(int tiempoParaRealizarla);
	public int getCupoPersonas();
	public void setCupoPersonas(int cupoPersonas); 
	public Tipo getTipoDeAtraccion();
	public void setTipoDeAtraccion(Tipo tipoDeAtraccion);
	public int getVisitantes();
	public void setVisitantes(int visitantes);
    public String getNombre();
    public void setNombre(String nombre);	
    
}

