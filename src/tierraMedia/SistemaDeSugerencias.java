package tierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SistemaDeSugerencias {

	private List<Atraccion> atracciones = new ArrayList<>();
	private List<Promocion> promociones = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();

	public SistemaDeSugerencias() {
		setAtracciones(Archivos.cargarAtracciones());
		setPromociones(Archivos.cargarPromociones(this.atracciones));
		setUsuarios(Archivos.cargarUsuarios());
	}


	public List<Atraccion> getAtracciones() {
		return atracciones;
	}


	public void setAtracciones(List<Atraccion> atracciones) {
		for (Atraccion atraccion : atracciones) {
			if (!this.atracciones.contains(atraccion) && atracionValida(atraccion)){
				this.atracciones.add(atraccion);
			}
		}
	}


	public List<Promocion> getPromociones() {
		return promociones;
	}


	public void setPromociones(List<Promocion> promociones) {
		for (Promocion promo : promociones) {
			if (!this.promociones.contains(promo) && promocionesValidas(promo)) {
				this.promociones.add(promo);
			}
		}
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			if (!this.usuarios.contains(usuario) && usuarioValido(usuario)){
				this.usuarios.add(usuario);
				menuSugerencias(usuario);
			}
		}
	}

	public void menuSugerencias(Usuario usuario){
		Queue<Sugeribles> sugerencias = new LinkedList<>();
		System.out.println("Bienvenido " + usuario.getNombre() + "!");
		Scanner sc = new Scanner(System.in);
		int respuesta;
		ordenarPromocionesPorPrecioYTiempo();
		System.out.println("Basandonos es sus preferencias, tenemos las siguientes promociones y atraciones vigentes");
		sugerencias = sugerirConPreferencias(usuario);
		sugerencias.addAll(sugerirSinPreferencias(usuario));
		while (usuario.getPresupuesto() > 0 && usuario.getTiempoDisponible() > 0 && !sugerencias.isEmpty()) {
			if (!usuario.estaEnElItinerario(sugerencias.peek()) && sugerenciaDisponible(sugerencias.peek(), usuario)) {
				System.out.println("Para aceptar la sugerencia ingrese un 1, en caso de rechazarla ingrese 0");
				System.out.println(sugerencias.peek().toString());
				respuesta = sc.nextInt();
				if (respuesta == 1) {
					sugerencias.peek().agregarVisitante();
					usuario.aceptarSugerencia(sugerencias.poll());
				}else{
					sugerencias.remove();
				}
			}	
		}
		
		System.out.println("Su itinerario quedo de la siguiente forma: " + usuario.getItinerario().toString());
	}
	
	private Queue<Sugeribles> sugerirConPreferencias(Usuario usuario){
		Queue<Sugeribles> sugerencias = new LinkedList<>();
		List<Sugeribles> opciones = new ArrayList<>();
		opciones.addAll(promociones);
		opciones.addAll(atracciones);
		for (Sugeribles opc : opciones) {
			if (cumplePreferenicas(opc, usuario)) {
				sugerencias.add(opc);
			}
			
		}
		
		return sugerencias;
	}

	private Queue<Sugeribles> sugerirSinPreferencias(Usuario usuario){
		Queue<Sugeribles> sugerencias = new LinkedList<>();
		List<Sugeribles> opciones = new ArrayList<>();
		opciones.addAll(promociones);
		opciones.addAll(atracciones);
		for (Sugeribles opc : opciones) {
			if (!cumplePreferenicas(opc, usuario)) {
				sugerencias.add(opc);
			}
			
		}
		return sugerencias;
	}

	public void ordenarPromocionesPorPrecioYTiempo() {
		Collections.sort(this.promociones, new OrdenadorPorPrecioYTiempo());
		Collections.sort(this.atracciones, new OrdenadorPorPrecioYTiempo());
	}

	private Boolean atracionValida(Atraccion atraccion){
		return (!atraccion.getNombre().equals("") && atraccion.getTipoDeAtraccion() != null);
	}

	private Boolean usuarioValido(Usuario usuario){
		return (!usuario.equals(new Usuario()) && usuario.getItinerario() != null &&
		!usuario.getNombre().equals("") && usuario.getTipoFavorito() != null &&
		 usuario.getPresupuesto() != 0 && usuario.getTiempoDisponible() != 0);
	}

	private Boolean promocionesValidas(Promocion promo){
		return (!promo.getAtraccion().isEmpty() && !promo.getNombre().equals("")
		 && promo.getTipoDeAtraccion() != null);
	}

	private Boolean cumplePreferenicas(Sugeribles sugerencia, Usuario usuario){
		return (sugerencia.getTipoDeAtraccion().equals(usuario.getTipoFavorito()) &&
		 sugerencia.getCosto() <= usuario.getPresupuesto() &&
		 sugerencia.getTiempo() <= usuario.getTiempoDisponible());
	}

	private Boolean sugerenciaDisponible(Sugeribles sugerencia, Usuario usuario){
		return !sugerencia.esCupoCompleto() && sugerencia.getCosto() <= usuario.getPresupuesto() 
		&& sugerencia.getTiempo() <= usuario.getTiempoDisponible();
	}

	@Override
	public String toString() {
		return "Atracciones=" + atracciones + 
		"\n Promociones=" + promociones +
		 "\n Usuarios="
				+ usuarios + "]";
	}
}	