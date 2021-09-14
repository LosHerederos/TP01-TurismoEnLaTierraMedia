package tierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeSugerencias {

	private List<Atraccion> atracciones = new ArrayList<>();
	private List<Promocion> promociones = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();

	public SistemaDeSugerencias() {
		setAtracciones(Archivos.cargarAtracciones());
		setPromociones(Archivos.cargarPromociones(this.atracciones));
		setUsuarios(Archivos.cargarUsuarios());
		try {
			Archivos.generarArchivosDeSalida(this.usuarios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		ordenarPorPrecioYTiempo();
		System.out.println("________________________________________________________________________________________________________");
		System.out.println("Bienvenido " + usuario.getNombre() + "!");
		System.out.println("Basandonos es sus preferencias, tenemos las siguientes promociones y atraciones vigentes");
		mostrarOpciones(enlistarSugerencias(usuario, false), usuario);
		if (usuario.poseeRecursosSuficientes(0, 0)) {
			System.out.println("Ademas tenemos las siguientes promociones y atraciones vigentes");
			mostrarOpciones(enlistarSugerencias(usuario, true), usuario);
		}
		System.out.println("Su itinerario quedo de la siguiente forma: " + usuario.getItinerario().toString());
	}

	private LinkedList<Sugeribles> enlistarSugerencias(Usuario usuario, Boolean preferencias){
		LinkedList<Sugeribles> sugerencias = new LinkedList<>();
		sugerencias.addAll(this.promociones);
		sugerencias.addAll(this.atracciones);
		sugerencias.removeIf(sugerencia -> cumplePreferencias(sugerencia, usuario).equals(preferencias));
		return sugerencias;
	}

	private void mostrarOpciones(LinkedList<Sugeribles> sugerencias, Usuario usuario){
		int respuesta;
		while (usuario.poseeRecursosSuficientes(0, 0) && !sugerencias.isEmpty()) {
			if (!usuario.estaEnElItinerario(sugerencias.getFirst()) && sugerenciaDisponible(sugerencias.getFirst(), usuario)) {
				System.out.println("Para aceptar la sugerencia ingrese un 1, en caso de rechazarla ingrese 0");
				System.out.println(sugerencias.getFirst().toString());
				respuesta = new Scanner(System.in).nextInt();
				if (respuesta == 1) {
					sugerencias.getFirst().agregarVisitante();
					usuario.aceptarSugerencia(sugerencias.getFirst());
				}
			}
			sugerencias.removeFirst();
		}
	}

	public void ordenarPorPrecioYTiempo() {
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

	private Boolean cumplePreferencias(Sugeribles sugerencia, Usuario usuario){
		return (sugerencia.getTipoDeAtraccion().equals(usuario.getTipoFavorito()));
	}

	private Boolean sugerenciaDisponible(Sugeribles opc, Usuario usuario){
		return !opc.esCupoCompleto() && usuario.poseeRecursosSuficientes(opc.getCosto(), opc.getTiempo());
	}

	@Override
	public String toString() {
		return "Atracciones=" + atracciones + 
		"\n Promociones=" + promociones +
		 "\n Usuarios="
				+ usuarios + "]";
	}
}
