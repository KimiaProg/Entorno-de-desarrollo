package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import libreriaJUnit.*;

public class testLibro {

	private static Libro libro;
	
	@BeforeClass
	public static void beforeClass() {
		libro = new Libro();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Fin de las pruebas");
	}

	@Before
	public void before() {
		System.out.println("Antes de cada prueba");
		libro.clear();
	}

	@After
	public void after() {
		libro.clear();
	}
	
	
	@Test
	public void testGetterSetter1() {
		libro.setAutor("Kimia");
		assertEquals(libro.getAutor(), "Kimia");
	}
	
	@Test
	public void testGetterSetter2() {
		libro.setTitulo("Languages");
		assertEquals(libro.getTitulo(),"Languages" );
	}
	

	@Test
	public void testGenero() {
		Genero g =Genero.getGenero("FICCION");
		assertEquals(g, Genero.FICCION);
	}

	@Test(expected = InputMismatchException.class)
	public void testMainOpcion() {
		Main.procesoEntrada("Kimia:150");
	}
	
	@Test(timeout = 1000)
	public void testBusquedaLibro() {
		ArrayList <Libro> catalogo= new ArrayList<Libro>();
		Main.busquedaLibroCatalogo("Languages", "Kimia", catalogo);
	}
	
	
}
