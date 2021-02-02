package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import libreriaJUnit.Libro;
import libreriaJUnit.Main;

@RunWith(value = Parameterized.class)
public class testLibroParametro {

	
	@Parameters
	public static Iterable<Object[]> getData() {
		ArrayList<Libro> catalogo = new ArrayList<Libro>();
		return Arrays.asList(new Object[][] {{"Languages", "Kimia", catalogo},{"Historia", "Antonio", catalogo}});
	}
	
	private String titulo,autor;
	private ArrayList<Libro> catalogo;
	
	public testLibroParametro(String titulo, String autor, ArrayList<Libro> catalogo) {
		this.autor=autor;
		this.catalogo=catalogo;
		this.titulo=titulo;
	}
	
	@Test
	public void testBusquedaCatalogo() {
		Libro libro= Main.busquedaLibroCatalogo(titulo, autor, catalogo);
		assertEquals(libro, null);

	}
}
