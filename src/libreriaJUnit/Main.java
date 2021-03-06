package libreriaJUnit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public Main() {
		
	}
	public static void main(String[] args) {
		ArrayList<Libro> catalogo = new ArrayList<Libro>();
		while (true) {
			int opcion = menu();
			switch (opcion) {
			case 1:
				alta(catalogo);
				break;
			case 2:
				listaLibro(catalogo);
				break;
			case 3:
				bajaLibro(catalogo);
				break;
			case 4:
				busquedaLibro(catalogo);
				break;
			case 5:
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Menu
	 * 
	 * @return
	 */
	private static int menu() {
		int opcion = 0;
		do {
			System.out.println("Opciones:");
			System.out.println("1. Alta de Libro");
			System.out.println("2. Lista de Libros");
			System.out.println("3. Baja de Libros");
			System.out.println("4. Búsqueda de Libros");
			System.out.println("5. Ordenacion de Libros");
			System.out.println("Introduce la opcion:");
			opcion = leerOpcion(5);
		} while (opcion <= 0);

		return opcion;
	}

	/**
	 * Lee la opcion seleccionada
	 * 
	 * @param max
	 * @return
	 */
	public static int leerOpcion(int max) {
		int opcion = -1;
		Scanner sc = new Scanner(System.in);
		try {
			opcion = sc.nextInt();
			if (opcion > max) {
				opcion = 1;
			}
		} catch (InputMismatchException e) {
			System.out.println("Opcion incorrecta");
		}
		return opcion;
	}

	/**
	 * Obtiene los datos por consola
	 * 
	 * @return
	 */
	public static String obtenerDatosLibro() {
		String datos = null;
		boolean validado = false;
		while (!validado) {
			System.out.println("Introduce los datos de los libros");
			System.out.println("Usa el formato \" \" titulo:isbn:genero:autor:paginas");
			try {
				datos = leerCadena();
				if (true) {
					validado = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Datos de entrada no válidos.");
			}

		}
		return datos;
	}

	/**
	 * Convertir los datos libros recogidos po consola en un objeto Libro
	 * 
	 * @param entrada
	 * @return
	 */
	public static Libro procesoEntrada(String entrada) {
		Libro libro = null;
		// Separando los datos del libro y Hacer el libro del cliente
		String[] datos = entrada.split(":");
		if(datos.length!=5) {
			throw new InputMismatchException("falta información. ");
		}
		// catalogo.add(new Libro(datos[0], datos[1], gen, datos[3], paginasInt));
		libro = new Libro(datos[0], datos[1], Genero.getGenero(datos[2]), datos[3], Integer.parseInt(datos[4]));

		return libro;

	}

	/**
	 * lee la cadena
	 * 
	 * @return
	 */
	private static String leerCadena() {
		String opcion = null;
		Scanner sc = new Scanner(System.in);
		try {
			opcion = sc.next();
			// TODO validar la entrada
		} catch (InputMismatchException e) {
			System.out.println("Opcion incorrecta");
		}
		return opcion;
	}

	/**
	 * El método para dar de alta a un libro
	 * 
	 * @param catalogo
	 */
	private static void alta(ArrayList<Libro> catalogo) {
		String datosLibro = obtenerDatosLibro();
		catalogo.add(procesoEntrada(datosLibro));
	}

	/**
	 * Para listar los libros existentes
	 * 
	 * @param catalogo
	 */
	private static void listaLibro(ArrayList<Libro> catalogo) {

		for (int i = 0; i < catalogo.size(); i++) {
			System.out.println("Libro " + i + ": " + catalogo.get(i).toString());
		}
	}

	/**
	 * El método para dar de baja a un libro
	 * 
	 * @param catalogo
	 */
	private static void bajaLibro(ArrayList<Libro> catalogo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("A qué libro quieres dar de baja? (Escribe el "
				+ "título y el nombre del autor del libro con este formato: titulo:autor)");
		String entrada = sc.next();
		String[] datos = entrada.split(":");
		String titulo = datos[0];
		String autor = datos[1];
		Libro libro = busquedaLibroCatalogo(titulo, autor, catalogo);
		if (libro != null) {
			catalogo.remove(libro);
			System.out.println("Se ha dado de baja al libro satisfactoriamente");
		} else {
			System.out.println("No existe este libro en el catálogo.");
		}

	}

	/**
	 * El método para buscar un libro y mostrarlo por pantalla
	 * 
	 * @param catalogo
	 */
	private static void busquedaLibro(ArrayList<Libro> catalogo) {
		System.out.println("Qué libro deseas buscar?");
		System.out.println("Escribe el título y el nombre del autor del libro con este formato: titulo:autor");
		Scanner sc = new Scanner(System.in);
		String entrada = sc.next();
		String[] datos = entrada.split(":");
		String titulo = datos[0];
		String autor = datos[1];

		Libro libro = busquedaLibroCatalogo(titulo, autor, catalogo);
		if (libro != null) {
			System.out.println("El libro se ha encontrado satisfactoriamente");
			System.out.println("Aquí lo tienes: " + libro.toString());
		} else {
			System.out.println("No existe este libro en el catálogo.");
		}
	}

	/**
	 * Busca un libro en el catalogo
	 * 
	 * @param titulo
	 * @param autor
	 * @param catalogo
	 * @return
	 */
	public static Libro busquedaLibroCatalogo(String titulo, String autor, ArrayList<Libro> catalogo) {
		Libro libro = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getAutor().equalsIgnoreCase(autor)
					&& catalogo.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				libro = catalogo.get(i);
				break;
			}
		}
		return libro;
	}

	/**
	 * Ordena los libros
	 * 
	 * @param catalogo
	 * @return
	 */
	private static ArrayList<Libro> ordenarLibro(ArrayList<Libro> catalogo) {
		return catalogo;
	}

}
