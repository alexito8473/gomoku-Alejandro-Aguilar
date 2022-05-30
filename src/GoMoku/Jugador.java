package GoMoku;

/**
 * Clase padre donde se crea al jugador de la partida, donde despues tendra dos
 * hijos, uno siendo la ia y otro el real.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 * 
 */
public class Jugador {
	/**
	 * Dato String, donde se almacena el nombre del jugador
	 * 
	 */
	protected String nombre;
	/**
	 * Dato ficha
	 * 
	 */
	protected Ficha ficha;

	/**
	 * Constructor de la clase
	 * 
	 * @param ficha el tipo de ficha
	 * 
	 */
	public Jugador(Ficha ficha) {
		this.ficha = ficha;
	}

	/**
	 * Metodo para ver el tipo de ficha.
	 * 
	 * @return ficha Devuelve un tipo de ficha
	 * 
	 */
	public Ficha getFicha() {
		return ficha;
	}

}
