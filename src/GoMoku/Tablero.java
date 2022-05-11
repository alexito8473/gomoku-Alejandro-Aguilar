package GoMoku;

/**
 * Clase donde se extrae la tabla donde se jugara al gomoku, los métodos
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
	 * @see #returnvictory()
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
	 * El resultado donde si es true has ganado, y si es false has perdido.
	 */
	private static boolean victoria;
	/**
	 * El tablero en cuestión, donde se forma el tablero y se juega.
	 */
	private static String españa[][] = {
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
	private static String españa2[][] = {
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
	 * Método para retornar el array principal.
	 */
	public String[][] getTablero() {
		return españa;
	}

	/**
	 * Método para pintar el array en la consola.
	 */
	public void mostrarTablero() {
		String a;
		for (int i = 0; i < españa.length; i++) {

			for (int j = 0; j < españa.length; j++) {
				a = españa[i][j];
				System.out.print(a + " ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
	}

	/**
	 * Método para dectecta en el tablero si se ha ganado, en el caso que haya una
	 * fila inclinada hacia abajo, donde la fila sea igual o mayor a 5 fichas del
	 * mismo tipo y continua.
	 * 
	 * @param ficha Tipo de ficha
	 */

	private static void inclinacion1(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && españa[i + 1][j + 1].equals(letra)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && españa[i + 2][j + 2].equals(letra)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && españa[i + 3][j + 3].equals(letra)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && españa[i + 4][j + 4].equals(letra)) {
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
	 * Método para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila inclinada hacia arriba, donde la fila sea igual o mayor a 5 fichas del
	 * mismo tipo y continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private static void inclinacion2(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if ((i + 1 < 16 && j - 1 < 16) && españa[i + 1][j - 1].equals(letra)) {
						if ((i + 2 < 16 && j - 2 < 16) && españa[i + 2][j - 2].equals(letra)) {
							if ((i + 3 < 16 && j - 3 < 16) && españa[i + 3][j - 3].equals(letra)) {
								if ((i + 4 < 16 && j - 4 < 16) && españa[i + 4][j - 4].equals(letra)) {
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
	 * Método para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila horzontal, donde la fila sea igual o mayor a 5 fichas del mismo tipo y
	 * continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private static void derecha(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < españa.length; i++) {
			for (int j = 0; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if ((j + 1 < 16) && españa[i][j + 1].equals(letra)) {
						if ((j + 2 < 16) && españa[i][j + 2].equals(letra)) {
							if ((j + 3 < 16) && españa[i][j + 3].equals(letra)) {
								if ((j + 4 < 16) && españa[i][j + 4].equals(letra)) {
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
	 * Método para dectectar en el tablero si se ha ganado, en el caso que haya una
	 * fila vertical, donde la fila sea igual o mayor a 5 fichas del mismo tipo y
	 * continua.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private static void arriba(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			letra = BLUE + "x" + WHITE;
		} else {
			letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < españa.length; i++) {

			for (int j = 0; j < españa.length; j++) {

				if (españa[i][j].equals(letra)) {
					if ((i + 1 < 16) && españa[i + 1][j].equals(letra)) {
						if ((i + 2 < 16) && españa[i + 2][j].equals(letra)) {
							if ((i + 3 < 16) && españa[i + 3][j].equals(letra)) {
								if ((i + 4 < 16) && españa[i + 4][j].equals(letra)) {
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
	 * Método para dectectar el no sobreescribir un ficha ya puesto con
	 * anteriodidad.
	 * 
	 * @param numero1 Posición del array
	 * @param numero2 Posición del array
	 * @return true: si ya existe una ficha en esa posición. false: si ya no existe ninguna ficha en esa posición.
	 */

	public boolean revision(int numero1, int numero2) {
		if ((españa[numero1][numero2] == GREEN + "o" + WHITE) || (españa[numero1][numero2] == BLUE + "x" + WHITE)
				|| (españa[numero1][numero2] == GREEN + "x" + WHITE)
				|| (españa[numero1][numero2] == YELLOW + "o" + WHITE)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para modificar el tablero, es decir elegir su posición y el tipo de
	 * ficha para sobrescribirlo, donde sera la ficha que se podra en primer lugar,
	 * es decir al realizar la jugada.
	 * 
	 * @param numero1 Posición del array
	 * @param numero2 Posición del array
	 * @param ficha   Tipo de ficha
	 */
	public void modificarTablero(int numero1, int numero2, ficha ficha) {
		if (ficha.equals(GoMoku.ficha.x)) {
			españa[numero1][numero2] = GREEN + "x" + WHITE;
		} else if (ficha.equals(GoMoku.ficha.o)) {
			españa[numero1][numero2] = GREEN + "o" + WHITE;
		}
	}

	/**
	 * Método para modificar el tablero, es decir elegir su posición y el tipo de
	 * ficha para sobrescribirlo, donde sera la ficha que se podra después de
	 * realizar la primera jugada.
	 * 
	 * @param numero1 Posición del array
	 * @param numero2 Posición del array
	 * @param ficha   Tipo de ficha
	 */
	public void modificarFicha(int numero1, int numero2, ficha ficha) {
		if (ficha.equals(GoMoku.ficha.x)) {
			españa[numero1][numero2] = BLUE + "x" + WHITE;
		} else if (ficha.equals(GoMoku.ficha.o)) {
			españa[numero1][numero2] = YELLOW + "o" + WHITE;
		}
	}

	/**
	 * Método por la cual se realiza las llamadas a los metodos para averiguar si
	 * hay una fila que de resultado para que sacar la victoria en true.
	 * 
	 * @param ficha Tipo de ficha
	 * @see #derecha(ficha)
	 * @see #arriba(ficha)
	 * @see #inclinacion1(ficha)
	 * @see #inclinacion2(ficha)
	 * @return true: has ganado. false: no has ganado.
	 */
	public boolean ganar(ficha ficha) {
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
	 * Método para reiniciar el tablero inicial, donde se utiliza el array
	 * secundario.
	 * 
	 */
	private static void returnTablero() {

		for (int i = 0; i < españa.length; i++) {
			for (int j = 0; j < españa.length; j++) {
				españa[i][j] = españa2[i][j];
			}
		}
	}

	/**
	 * Método para reiniciar el booleano victoria a false.
	 * 
	 */
	private void returnVictory() {
		victoria = false;
	}

//------------------------------------------------------------------------------------------------------

	static boolean derechaText(ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
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
	static boolean arribaText(ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
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
	static boolean inclinacionAbajoText(ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
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
	static boolean inclinacionArribaText(ficha ficha, String[][] array) {
		boolean victory = false;
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
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
