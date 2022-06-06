package goMoku;

/**
 * Clase padre donde se crea al jugador de la partida, donde despues tendra dos
 * hijos, uno siendo la ia y otro el real.
 * 
 * @author Alejandro Aguilar Alba
 * @version 2.0
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
	 * Constructor de la clase.
	 * 
	 * @param ficha El tipo de ficha.
	 * @param nombre El tipo del nombre.
	 */
	public Jugador(Ficha ficha,String nombre ) {
		this.ficha = ficha;
		this.nombre=nombre; 
	}
	/**
	 * Constructor de la clase.
	 * 
	 * @param ficha El tipo de ficha.
	 * 
	 */
	public Jugador(Ficha ficha) {
		this.ficha=ficha;
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
	/**
	 * Metodo para devolver el nombre.  
	 * 
	 * @return nombre Devolver el nombre
	 */
	public String getNombre() {
		return nombre;
	}

}
