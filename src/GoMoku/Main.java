package GoMoku;

/**
 * Clase main, donde se le llama a la clase Partida para comenzar tantas
 * partidas como se le desee.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 * 
 */
public class Main {
	/**
	 * Metodo main
	 * 
	 * @param args la partida
	 */
	public static void main(String[] args) {
		/**
		 * Llamada de la clase partida.
		 */
		Partida partida;
		/**
		 * Construimos la partida.
		 */
		partida = new Partida();
		/**
		 * Comenzamos la partida.
		 */
		partida.comenzar();
	}

}
