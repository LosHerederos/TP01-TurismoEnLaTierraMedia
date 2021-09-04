package tierraMedia;

import tierraMedia.Atraccion.Tipo;

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
