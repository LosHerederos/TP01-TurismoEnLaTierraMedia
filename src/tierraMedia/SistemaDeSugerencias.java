package tierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
				sugerirPromociones(usuario);
			}
		}
	}

	public void sugerirPromociones(Usuario usuario){
		System.out.println("Bienvenido " + usuario.getNombre() + "!");
		Queue<Promocion> sugerencias = new PriorityQueue<>();
		ordenarPromocionesPorPrecioYTiempo();
		for (Promocion promo : promociones) {
			if (cumplePreferenicas(promo, usuario)) {
				sugerencias.add(promo);
			}
		}
		Scanner sc = new Scanner(System.in);
		int respuesta;
		System.out.println("Basandonos es sus preferencias, tenemos las siguientes promociones vigentes");
		while (usuario.poseeRecursos() && !sugerencias.isEmpty()) {
			System.out.println("Para aceptar la sugenecia ingrese un 1, en caso de rechazarla ingrese 0");
			System.out.println(sugerencias.peek().toString());
			respuesta = sc.nextInt();
			if (respuesta == 1) {
				usuario.aceptarSugerencia(sugerencias.poll());
			}else{
				sugerencias.remove();
			}
		}
		System.out.println("Su itinerario: " + usuario.getItinerario().toString());
	}


	public void ordenarPromocionesPorPrecioYTiempo() {
		Collections.sort(this.promociones, new OrdenadorPorPrecioYTiempo());
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

	private Boolean cumplePreferenicas(Promocion promo, Usuario usuario){
		return (promo.getTipoDeAtraccion().equals(usuario.getTipoFavorito()) &&
		 promo.getCosto() <= usuario.getPresupuesto() && promo.getTiempo() <= usuario.getTiempoDisponible()  
		 && !usuario.poseeAtraccion(atracciones));
	}

	@Override
	public String toString() {
		return "Atracciones=" + atracciones + 
		"\n Promociones=" + promociones +
		 "\n Usuarios="
				+ usuarios + "]";
	}
	
}
