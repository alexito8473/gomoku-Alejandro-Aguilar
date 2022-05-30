package GoMoku;

import java.util.concurrent.TimeUnit;

/**
 * Clase donde se extrae la tabla donde se jugara al gomoku, los metodos
 * pertinentes para la victoria del jugado, y además los métodos para modificar
 * el tablero y mostrarlo.
 * 
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 *
 */
public class Tablero {
	/**
	 * Constructor de la clase Tablero.
	 * 
	 * @see #returnTablero()
	 * @see #returnVictory()
	 */
	public Tablero() {
		returnTablero();
		returnVictory();
	}

	/**
	 * El color azul, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String BLUE = "\u001B[34m";
	/**
	 * El color blanco, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String WHITE = "\u001B[37m";
	/**
	 * El color verde, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String GREEN = "\u001B[32m";
	/**
	 * El color amarillo, se utiliza para cambiar el color a las letras en la
	 * consola.
	 */
	private static final String YELLOW = "\u001B[33m";
	/**
	 * El color rojo, se utiliza para cambiar el color del fondo de la consola
	 */
	public static final String RED_BACKGROUND = "\u001B[41m";
	/**
	 * El color amarillo, se utiliza para cambiar el color del fondo de la consola
	 */
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	/**
	 * Resetear colores
	 */
	public static final String RESET = "\u001B[0m";

	/**
	 * El resultado donde si es true has ganado, y si es false has perdido.
	 */
	private boolean victoria;
	/**
	 * El tablero en cuestio  	 n, donde se forma el tablero y se juega.
	 */
	private String tabla[][] = {
			{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
			{ "01", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "02", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "03", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "04", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "05", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
	/**
	 * El tablero secundario, se utiliza para el reinicio del array principal
	 */
	private static String tablaRepuesto[][] = {
			{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
			{ "01", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "02", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "03", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "04", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "05", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };

	/**
	 * Metodo para retornar el array principal.
	 * @return String[][] Retorna el tablero
	 */
	public String[][] getTablero() {
		return tabla;
	}

	/**
	 * Metodo para pintar el array en la consola.
	 */
	public void mostrarTablero() {
		System.out.print(WHITE);
		String a;
		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla.length; j++) {
				a = tabla[i][j];
				System.out.print(a + " ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
	}

	/**
	 * Metodo para dectecta en el tablero si se ha ganado, en el caso que haya una
	 * fila inclinada hacia abajo, donde la fila sea igual o mayor a 5 fichas del
	 * mismo tipo y continua.
	 * 
	 * @param ficha Tipo de ficha
	 */

	private void inclinacion1(Ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < tabla.length; i++) {
			for (int j = 1; j < tabla.length; j++) {
				if (tabla[i][j].equals(letra)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && tabla[i + 1][j + 1].equals(letra)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && tabla[i + 2][j + 2].equals(letra)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && tabla[i + 3][j + 3].equals(letra)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && tabla[i + 4][j + 4].equals(letra)) {
									victoria = true;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila inclinada hacia arriba, donde la fila sea igual o mayor a 5 fichas del
	 * mismo tipo y continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private void inclinacion2(Ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < tabla.length; i++) {
			for (int j = 1; j < tabla.length; j++) {
				if (tabla[i][j].equals(letra)) {
					if ((i + 1 < 16 && j - 1 < 16) && tabla[i + 1][j - 1].equals(letra)) {
						if ((i + 2 < 16 && j - 2 < 16) && tabla[i + 2][j - 2].equals(letra)) {
							if ((i + 3 < 16 && j - 3 < 16) && tabla[i + 3][j - 3].equals(letra)) {
								if ((i + 4 < 16 && j - 4 < 16) && tabla[i + 4][j - 4].equals(letra)) {
									victoria = true;

								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila horzontal, donde la fila sea igual o mayor a 5 fichas del mismo tipo y
	 * continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private void derecha(Ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i][j].equals(letra)) {
					if ((j + 1 < 16) && tabla[i][j + 1].equals(letra)) {
						if ((j + 2 < 16) && tabla[i][j + 2].equals(letra)) {
							if ((j + 3 < 16) && tabla[i][j + 3].equals(letra)) {
								if ((j + 4 < 16) && tabla[i][j + 4].equals(letra)) {
									victoria = true;

								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila vertical, donde la fila sea igual o mayor a 5 fichas del mismo tipo y
	 * continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private void arriba(Ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < tabla.length; i++) {

			for (int j = 0; j < tabla.length; j++) {

				if (tabla[i][j].equals(letra)) {
					if ((i + 1 < 16) && tabla[i + 1][j].equals(letra)) {
						if ((i + 2 < 16) && tabla[i + 2][j].equals(letra)) {
							if ((i + 3 < 16) && tabla[i + 3][j].equals(letra)) {
								if ((i + 4 < 16) && tabla[i + 4][j].equals(letra)) {
									victoria = true;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para dectectar el no sobreescribir un ficha ya puesto con
	 * anteriodidad.
	 * 
	 * @param numero1 Posicion del array
	 * @param numero2 Posicion del array
	 * @return true: si ya existe una ficha en esa posicion. false: si ya no existe ninguna ficha en esa posicion.
	 */

	public boolean revision(int numero1, int numero2) {
		if ((tabla[numero1][numero2] == GREEN + "o" + WHITE) || (tabla[numero1][numero2] == BLUE + "x" + WHITE)
				|| (tabla[numero1][numero2] == GREEN + "x" + WHITE)
				|| (tabla[numero1][numero2] == YELLOW + "o" + WHITE)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para modificar el tablero, es decir elegir su posicion y el tipo de
	 * ficha para sobrescribirlo, donde sera la ficha que se podra en primer lugar,
	 * es decir al realizar la jugada.
	 * 
	 * @param numero1 Posicion del array
	 * @param numero2 Posicion del array
	 * @param ficha   Tipo de ficha
	 */
	public void modificarTablero(int numero1, int numero2, Ficha ficha) {
		if (ficha.equals(GoMoku.Ficha.x)) {
			tabla[numero1][numero2] = GREEN + "x" + WHITE;
		} else if (ficha.equals(GoMoku.Ficha.o)) {
			tabla[numero1][numero2] = GREEN + "o" + WHITE;
		}
	}

	/**
	 * Metodo para modificar el tablero, es decir elegir su posicion y el tipo de
	 * ficha para sobrescribirlo, donde sera la ficha que se podra despues de
	 * realizar la primera jugada.
	 * 
	 * @param numero1 Posicion del array
	 * @param numero2 Posicion del array
	 * @param ficha   Tipo de ficha
	 */
	public void modificarFicha(int numero1, int numero2, Ficha ficha) {
		if (ficha.equals(GoMoku.Ficha.x)) {
			tabla[numero1][numero2] = BLUE + "x" + WHITE;
		} else if (ficha.equals(GoMoku.Ficha.o)) {
			tabla[numero1][numero2] = YELLOW + "o" + WHITE;
		}
	}

	/**
	 * Metodo por la cual se realiza las llamadas a los metodos para averiguar si
	 * hay una fila que de resultado para que sacar la victoria en true.
	 * 
	 * @param ficha Tipo de ficha
	 * @see #derecha(Ficha)
	 * @see #arriba(Ficha)
	 * @see #inclinacion1(Ficha)
	 * @see #inclinacion2(Ficha)
	 * @return true: has ganado. false: no has ganado.
	 */
	public boolean ganar(Ficha ficha) {
		derecha(ficha);
		arriba(ficha);
		inclinacion1(ficha);
		inclinacion2(ficha);
		if (victoria) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para reiniciar el tablero inicial, donde se utiliza el array
	 * secundario.
	 * 
	 */
	private void returnTablero() {

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				tabla[i][j] = tablaRepuesto[i][j];
			}
		}
	}

	/**
	 * Metodo para reiniciar el booleano victoria a false.
	 * 
	 */
	private void returnVictory() {
		victoria = false;
	}
	
	/**
	 * Metodo para pausar la consola
	 */
	public void timeOut() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para pintar el final de una partida.
	 */
	public void pintarBandera() {
		timeOut();
		System.out.print("\n" + RED_BACKGROUND);
		timeOut();
		System.out.print("  _____   _________   ___   __  \n");
		timeOut();
		System.out.print(" |   __| |___   ___| |   \\ |  | \n" + YELLOW_BACKGROUND);
		timeOut();
		System.out.print(" |  |__      | |     |    \\|  | \n");
		timeOut();
		System.out.print(" |   __|  ___| |___  |  |\\    | \n" + RED_BACKGROUND);
		timeOut();
		System.out.print(" |__|    |_________| |__| \\___| \n");
		timeOut();
		System.out.print("                                " + RESET);
	}

//------------------------------------------------------------------------------------------------------
	/**
	 * Metodo de texteo horizontal
	 * @param ficha	Tipo de ficha
	 * @param array  Un tablero
	 * @return true: si se encuentra un patron
	 * 			false:si no encontramos el patron
	 */
        boolean derechaText(Ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = "x";
		} else {
			letra = "o";
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j].equals(letra)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(letra)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(letra)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(letra)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(letra)) {
									victory = true;
								}
							}
						}
					}
				}
			}
		}
		return victory;
	}

	// ------------------------------------------------------------------------------------------------------
	/**
	 * Metodo de texteo vertical
	 * @param ficha	Tipo de ficha
	 * @param array  Un tablero
	 * @return true: si se encuentra un patron
	 * 			false:si no encontramos el patron
	 */
	 boolean arribaText(Ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = "x";
		} else {
			letra = "o";
		}
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {

				if (array[i][j].equals(letra)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(letra)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(letra)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(letra)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(letra)) {
									victory = true;
								}
							}
						}
					}
				}

			}
		}
		return victory;
	}

	// ------------------------------------------------------------------------------------------------------
	/**
	 * Metodo de texteo inclinado de abajo
	 * @param ficha	Tipo de ficha
	 * @param array  Un tablero
	 * @return true: si se encuentra un patron
	 * 			false:si no encontramos el patron
	 */
	 boolean inclinacionAbajoText(Ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = "x";
		} else {
			letra = "o";
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[i][j].equals(letra)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(letra)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(letra)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(letra)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(letra)) {
									victory = true;
								}
							}
						}
					}
				}
			}
		}
		return victory;
	}

	// ------------------------------------------------------------------------------------------------------
	/**
	 * Metodo de texteo inclinado de arriba
	 * @param ficha	Tipo de ficha
	 * @param array  Un tablero
	 * @return true: si se encuentra un patron
	 * 			false:si no encontramos el patron
	 */
	 boolean inclinacionArribaText(Ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.Ficha.x)) {
			letra = "x";
		} else {
			letra = "o";
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[i][j].equals(letra)) {
					if ((i + 1 < 16 && j - 1 < 16) && array[i + 1][j - 1].equals(letra)) {
						if ((i + 2 < 16 && j - 2 < 16) && array[i + 2][j - 2].equals(letra)) {
							if ((i + 3 < 16 && j - 3 < 16) && array[i + 3][j - 3].equals(letra)) {
								if ((i + 4 < 16 && j - 4 < 16) && array[i + 4][j - 4].equals(letra)) {
									victory = true;

								}
							}
						}
					}
				}
			}
		}
		return victory;
	}

}
