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
	static Scanner sc;
	static String rutaDeArchivos = "archivos/";
	static String archivoDeUsuarios = "usuarios.in";
	static String archivoDeAtracciones = "atracciones.in";
	static String archivoDePromociones = "promociones.in";

	public static void cargarUsuarios() {
		String rutaDeArchivoDeUsuarios = rutaDeArchivos + "input/" + archivoDeUsuarios;
		String[] datosDeUsuarios = leerArchivo(rutaDeArchivoDeUsuarios);
		String[] datos;
		for (String datosDeUsuario : datosDeUsuarios) {
			datos = separarDatos(datosDeUsuario);
			System.out.println("Nombre: "+datos[0]+", Presupuesto: " + datos[1] + ", Tiempo: " + datos[2] + ", Tipo de Atracción: " + datos[3]);
		}
	}

	public static void cargarAtracciones() {
		String rutaDeArchivoDeAtracciones = rutaDeArchivos + "input/" + archivoDeAtracciones;
		String[] datosDeAtracciones = leerArchivo(rutaDeArchivoDeAtracciones);
		String[] datos;
		for (String datosDeAtraccion : datosDeAtracciones) {
			datos = separarDatos(datosDeAtraccion);
			System.out.println("Nombre: "+datos[0]+", Costo: " + datos[1] + ", Tiempo: " + datos[2] + ", Cupo de Personas: " + datos[3] + ", Tipo de Atracción: " + datos[4]);
		}
	}

	public static void cargarPromociones() {
		String rutaDeArchivoDePromociones = rutaDeArchivos + "input/" + archivoDePromociones;
		String[] datosDePromociones = leerArchivo(rutaDeArchivoDePromociones);
		String[] datos;
		for (String datosDePromocion : datosDePromociones) {
			datos = separarDatos(datosDePromocion);
			System.out.println("Tipo de Promoción: " + datos[0] +", Nombre: "+datos[1]+", Atracciones: " + datos[2] + ", Otros: " + datos[3]);
		}
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
	
	private static String[] separarDatos(String datosUnidos) {
		return datosUnidos.split(separador);
	}
}
