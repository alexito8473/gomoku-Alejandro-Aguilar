package GoMoku;

/**
 * Clase hija, de la clase Jugador.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 * 
 */
public class Real extends Jugador {
	/**
	 * Constructor de la clase.
	 * 
	 * @param ficha  El tipo de ficha
	 * @param nombre El nombre del jugador
	 * 
	 */
	public Real(String nombre, Ficha ficha) {
		super(ficha,nombre);
	}

}
