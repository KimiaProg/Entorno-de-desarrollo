package libreriaJUnit;

public enum Genero {
	NOVELA, POESIA, FICCION;

	private static Genero seleccionado = null;
	
	public static Genero getGenero(String genero) {
	
		switch (genero.toUpperCase()) {
		case "NOVELA":
			seleccionado = Genero.NOVELA;
			break;
		case "POESIA":
			seleccionado = Genero.POESIA;
			break;
		case "FICCION":
			seleccionado = Genero.FICCION;
			break;
		}
		return seleccionado;
	}
	
}
