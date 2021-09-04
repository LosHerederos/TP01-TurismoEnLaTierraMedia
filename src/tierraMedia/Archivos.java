package tierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Archivos {

	final static String separador = ", ";
	final static String separadorDeArreglo = " : ";
	static Scanner sc;
	static String rutaDeArchivos = "archivos/";
	static String archivoDeUsuarios = "usuarios.in";
	static String archivoDeAtracciones = "atracciones.in";
	static String archivoDePromociones = "promociones.in";

	public static Usuario[] cargarUsuarios() {
		/*
		 * 0: Nombre : String
		 * 1: Presupuesto : int
		 * 2: Tiempo : double
		 * 3: Tipo de Atracción : enum
		 */
		String nombre;
		int presupuesto;
		double tiempoDisponible;
		TipoDeAtracciones tipoFavorito;
		
		String rutaDeArchivoDeUsuarios = rutaDeArchivos + "input/" + archivoDeUsuarios;
		String[][] datosDeUsuarios = separarDatos(leerArchivo(rutaDeArchivoDeUsuarios));
		Usuario[] usuarios = new Usuario[datosDeUsuarios.length];

		for (int i = 0; i < datosDeUsuarios.length; i++) {
			nombre = datosDeUsuarios[i][0];
			presupuesto = Integer.parseInt(datosDeUsuarios[i][1]);
			tiempoDisponible = Double.parseDouble(datosDeUsuarios[i][2]);
			tipoFavorito = TipoDeAtracciones.valueOf(datosDeUsuarios[i][3]);
			
			usuarios[i] = new Usuario(nombre, presupuesto, null, tiempoDisponible, tipoFavorito);
		}
		
		return usuarios;
	}

	public static Atraccion[] cargarAtracciones() {
		/* 
		 * 0: Nombre : String
		 * 1: Costo : int
		 * 2: Tiempo : double
		 * 3: Cupo de Personas : int
		 * 4: Tipo de Atracción : enum
		 */
		String nombre;
		int costoVisita;
		double tiempoParaRealizarla;
		int cupoPersonas;
		TipoDeAtracciones tipoDeAtraccion;
		
		String rutaDeArchivoDeAtracciones = rutaDeArchivos + "input/" + archivoDeAtracciones;
		String[][] datosDeAtracciones = separarDatos(leerArchivo(rutaDeArchivoDeAtracciones));
		Atraccion[] atracciones = new Atraccion[datosDeAtracciones.length];

		for (int i = 0; i < datosDeAtracciones.length; i++) {
			nombre = datosDeAtracciones[i][0];
			costoVisita = Integer.parseInt(datosDeAtracciones[i][1]);
			tiempoParaRealizarla = Double.parseDouble(datosDeAtracciones[i][2]);
			cupoPersonas = Integer.parseInt(datosDeAtracciones[i][3]);
			tipoDeAtraccion = TipoDeAtracciones.valueOf(datosDeAtracciones[i][4]);
			
			atracciones[i] = new Atraccion(costoVisita, tiempoParaRealizarla, cupoPersonas, tipoDeAtraccion, nombre);
		}
		
		return atracciones;
	}

	public static Promocion[] cargarPromociones(Atraccion[] todasLasAtracciones) {
		/*"
		 * 0: Tipo de Promoción : String
		 * 1: Nombre : String
		 * 2: Atracciones : Atraccion[]
		 * 3: Otros:  
		 */
		String tipoDePromocion;
		String nombre;
		Atraccion[] atracciones;
		
		String rutaDeArchivoDePromociones = rutaDeArchivos + "input/" + archivoDePromociones;
		String[][] datosDePromociones = separarDatos(leerArchivo(rutaDeArchivoDePromociones));
		Promocion[] promociones = new Promocion[datosDePromociones.length];
		
		for (int i = 0; i < datosDePromociones.length; i++) {
			tipoDePromocion = datosDePromociones[i][0];
			nombre = datosDePromociones[i][1];
			String[] nombresDeAtracciones = separarArregloEnString(datosDePromociones[i][2]);
			atracciones = buscarAtracciones(todasLasAtracciones, nombresDeAtracciones);
			
			if (tipoDePromocion == "PromocionPorcentual") {
				// double porcentajeDeDescuento = datosDePromociones[i][3];
				// promociones[i] = new PromocionPorcentual(nombre, atracciones);
			} else if (tipoDePromocion == "PromocionAbsoluta") {
				// double costoTotal = datosDePromociones[i][3];
				//promociones[i] = new PromocionAbsoluta(nombre, atracciones);
			} else if (tipoDePromocion == "PromocionAXB") {
				// Atracciones otrasAtracciones = new Atracciones[n]
				//promociones[i] = new PromocionAbsoluta(nombre, atracciones);
			}
		}
		
		return promociones;
	}
	
	public static void generarArchivoDeSalida(Object obj, String nombreDeArchivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(rutaDeArchivos + "output/" + nombreDeArchivo));
		salida.println(obj);
		salida.close();
	}
	
	private static String[] leerArchivo(String rutaDeArchivo) {
		File archivoDeEntrada = new File(rutaDeArchivo);
		String archivo = "";
		try {
			sc = new Scanner(archivoDeEntrada);
			String linea = sc.nextLine();
			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				archivo += linea + ";";
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return archivo.split(";");
	}
	
	private static String[][] separarDatos(String[] arregloDeDatosUnidos) {
		String[][] arregloDeDatosSeparados = new String[arregloDeDatosUnidos.length][];
		for (int i = 0; i < arregloDeDatosUnidos.length; i++) {
			arregloDeDatosSeparados[i] = arregloDeDatosUnidos[i].split(separador);
		}
		
		return arregloDeDatosSeparados;
	}
	
	private static String[] separarArregloEnString(String arregloEnString) {
		String[] arreglo;
		arregloEnString = arregloEnString.replaceAll("[()]", "");
		arreglo = arregloEnString.split(separadorDeArreglo);
		
		return arreglo;
	}
	
	private static Atraccion[] buscarAtracciones(Atraccion[] todasLasAtracciones, String[] nombresDeAtracciones) {
		Atraccion[] atracciones = new Atraccion[nombresDeAtracciones.length];
		int encontradas = 0;
		int i = 0;
		
		while (encontradas < atracciones.length) {
			for (Atraccion atraccion : todasLasAtracciones) {
				if (atraccion.getNombre().equals((nombresDeAtracciones[i]))) {
					atracciones[encontradas++] = atraccion;
				}
			}
			i++;
		}
		
		return atracciones;
	}
}
