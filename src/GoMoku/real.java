package GoMoku;

/**
 * Clase hija, de la clase Jugador.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 * 
 */
public class real extends Jugador {
	/**
	 * Constructor de la clase
	 * 
	 * @param ficha  El tipo de ficha
	 * @param nombre El nombre del jugador
	 * 
	 */
	public real(String nombre, ficha ficha) {
		super(ficha);
		this.nombre = nombre;
	}

	/**
	 * Dato String, donde se almacena el nombre del jugador
	 * 
	 */
	 private String nombre;

	/**
	 * Método get para saber que tipo de nombre posee el jugador
	 * 
	 * @return String El nombre del jugador
	 */
	public String getNombre() {
		return nombre;
	}
}
