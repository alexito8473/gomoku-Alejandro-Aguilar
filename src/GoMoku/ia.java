package GoMoku;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase hija del jugador, donde se enfatizaria en la inteligencia arificial, la
 * ia.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 *
 */

public class ia extends Jugador {
	/**
	 * El constructor de la clase ia.
	 * 
	 * @param ficha Tipo de ficha
	 */
	public ia(ficha ficha) {
		super(ficha);
	}
	/**
	 * El color blanco, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String WHITE = "\u001B[37m";
	/**
	 * El color azul, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String BLUE = "\u001B[34m";
	/**
	 * El color amarillo, se utiliza para cambiar el color a las letras en la
	 * consola.
	 */
	private static final String YELLOW = "\u001B[33m";
	/**
	 * Dato de tipo String donde se almacena el nombre de la ia.
	 */
	protected static String nombre;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida.
	 */
	public static boolean ganar = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma horizontal.
	 */
	private static boolean ganarHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma vertical.
	 */
	private static boolean ganarVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma inclinada.
	 */
	private static boolean ganarInclinado = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender.
	 */
	private static boolean defensa = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * horizontal.
	 */
	private static boolean defensaHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * vertical.
	 */
	private static boolean defensaVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada.
	 */
	private static boolean defensaInclinada = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada.
	 */
	private static boolean defensaInclinada1 = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar.
	 */
	private static boolean ataque = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * horizontal.
	 */
	private static boolean ataqueHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * vertical.
	 */
	private static boolean ataqueVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * inclinado.
	 */
	private static boolean ataqueInclinado = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * inclinado.
	 */
	private static boolean ataqueInclinado1 = false;
	/**
	 * Dato int, para guardar la posicion para el array.
	 */
	private static int x = 0;
	/**
	 * Dato int, para guardar la posicion para el array.
	 */
	private static int y = 0;
	/**
	 * Llamada a la clase ramdon de java .
	 */
	private static Random ran = new Random();
	/**
	 * Utilizacion de las clase Scanner de java.
	 */
	private Scanner src = new Scanner(System.in);
	/**
	 * Numero ramdon hasta el 9
	 */
	private static int number = ran.nextInt(9);
	/**
	 * Numero ramdon hasta el 9
	 */
	private static int number2 = ran.nextInt(9);
	/**
	 * La creacion de un array unidimencional, con dos espacios .
	 */
	private static int[] numeros = new int[2];

	/**
	 * Array con nombres predeterminados para la ia
	 */
	private static String nombres[] = { "Pepe", "Jorge", "España", "Lisbania", "Me gustaria", "Francia caca",
			"Copenage", "Mordekaiser", "ElNen" };

	/**
	 * Metodo para generar un nombre para la lia, distinta por cada ficha
	 * 
	 * @param ficha Tipo de ficha
	 * @return si la ficha es 'x' te devuelve un nombre, y si la ficha es 'y' te
	 *         devuelva otro nombre
	 */
	public String nombre(ficha ficha) {

		if (ficha.equals(GoMoku.ficha.x)) {
			return nombre = nombres[number];
		} else {
			return nombre = nombres[number2];
		}
	}

	/**
	 * Metodo para retornar todos los booleanos a falso
	 */
	private void retornar() {
		ganar = false;
		ganarHorizontal = false;
		defensa = false;
		defensaHorizontal = false;
		defensaVertical = false;
		defensaInclinada = false;
		defensaInclinada = false;
		ataque = false;
		ataqueHorizontal = false;
		ataqueVertical = false;
		ataqueInclinado = false;
		ataqueInclinado1 = false;
	}

	/**
	 * Metodo para detectar las jugadas horizontales defensivas.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva horizontal.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void defensaHorizontal(String[][] array, GoMoku.ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									defensaHorizontal = true;
									defensa = true;
									exit = true;
									y = i;
									x = j + 2;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								defensaHorizontal = true;
								defensa = true;
								exit = true;
								y = i;
								x = j+1;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								defensaHorizontal = true;
								defensa = true;
								exit = true;
								y = i;
								x = j+2;
							}
						}
					}
				}
			}
		}
			for (int i = 0; i < array.length && !exit; i++) {
				for (int j = 0; j < array.length&& !exit; j++) {
					if ((j < 16) && array[i][j].equals(".")) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									defensaHorizontal = true;
									defensa = true;
									exit = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < array.length && !exit; i++) {
				for (int j = 0; j < array.length&& !exit; j++) {
					if ((j < 16) && array[i][j].equals(eleccion)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
									defensaHorizontal = true;
									defensa = true;
									exit = true;
									y = i;
									x = j + 3;
								}
							}
					}
				}
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para detectar las jugadas verticales defensivas.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva vertical.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void defensaVertical(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									defensa = true;
									defensaVertical = true;
									y = i + 2;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								defensa = true;
								defensaVertical = true;
								y = i + 2;
								x = j;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16) && array[i ][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								defensa = true;
								defensaVertical = true;
								y = i + 1;
								x = j;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16) && array[i ][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(".")) {
								defensa = true;
								defensaVertical = true;
								y = i + 3;
								x = j;
								exit = true;
							}
						}
					}
				}
			}
		}
			for (int i = 0; i < array.length && !exit; i++) {
				for (int j = 0; j < array.length&& !exit; j++) {
					if ((i < 16) && array[i][j].equals(".")) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
									defensa = true;
									defensaVertical = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}

	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para detectar las jugadas inclinadas defensivas.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void defensaInclinado(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									defensa = true;
									defensaInclinada = true;
									y = i + 2;
									x = j + 2;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								defensa = true;
								defensaInclinada = true;
								y = i + 1;
								x = j + 1;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								defensa = true;
								defensaInclinada = true;
								y = i + 2;
								x = j + 2;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								defensa = true;
								defensaInclinada = true;
								y = i + 3;
								x = j + 3;
								exit = true;
							}
						}
					}
				}
			}
		}
			for (int i = 0; i < array.length && !exit; i++) {
				for (int j = 0; j < array.length&& !exit; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									defensa = true;
									defensaInclinada = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}

	}

	/**
	 * Metodo para detectar las jugadas inclinadas defensivas.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void defensaInclinado1(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									defensa = true;
									defensaInclinada1 = true;
									y = i + 2;
									x = j - 2;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(".")) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								defensa = true;
								defensaInclinada1 = true;
								y = i + 1;
								x = j - 1;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								defensa = true;
								defensaInclinada1 = true;
								y = i + 2;
								x = j - 2;
								exit = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length&& !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(".")) {
								defensa = true;
								defensaInclinada1 = true;
								y = i + 3;
								x = j - 3;
								exit = true;
							}
						}
					}
				}
			}
		}

			for (int i = 0; i < array.length && !exit; i++) {
				for (int j = 0; j < array.length&& !exit; j++) {
					if ((i < 16 && j > 0) && array[i][j].equals(".")) {
						if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
							if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
								if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
									defensa = true;
									defensaInclinada1 = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}


		}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para detectar las jugadas horizontales ganadoras.
	 * 
	 * @param array  El tablero donde se decide las jugadas ganadoras de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ganarHorizontal(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(".")) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j + 4;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(".")) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j + 1;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j + 2;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j + 3;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para detectar las jugadas verticales ganadoras.
	 * 
	 * @param array  El tablero donde se decide las jugadas ganadoras de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ganarVertical(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(".")) {
									ganar = true;
									ganarVertical = true;
									y = i + 4;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									ganar = true;
									ganarVertical = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									ganar = true;
									ganarVertical = true;
									y = i + 1;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									ganar = true;
									ganarVertical = true;
									y = i + 2;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(".")) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									ganar = true;
									ganarVertical = true;
									y = i + 3;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para detectar las jugadas inclinadas ganadoras.
	 * 
	 * @param array  El tablero donde se decide las jugadas ganadoras de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ganarInclinado(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)){
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")){
									ganar = true;
									ganarInclinado = true;
									y = i + 4;
									x = j + 4;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i + 3;
									x = j + 3;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i + 2;
									x = j + 2;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 2 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i + 1;
									x = j + 1;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(".")) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i;
									x = j;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(".")) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									exit = true;
									y = i + 1;
									x = j - 1;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i + 2;
									x = j - 2;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(".")) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									ganar = true;
									ganarInclinado = true;
									y = i + 3;
									x = j - 3;
									exit = true;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(".")) {
									ganar = true;
									ganarInclinado = true;
									exit = true;
									y = i + 4;
									x = j - 4;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para detectar las jugadas verticales atacantes.
	 * 
	 * @param array  El tablero donde se decide las jugadas atacantes de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ataqueVertical(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							ataqueVertical = true;
							ataque = true;
							y = i + 1;
							x = j;
							exit = true;

						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							ataqueVertical = true;
							ataque = true;
							y = i;
							x = j;
							exit = true;

						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							ataqueVertical = true;
							ataque = true;
							y = i + 2;
							x = j;
							exit = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para detectar las jugadas inclindas atacantes.
	 * 
	 * @param array  El tablero donde se decide las jugadas atacantes de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ataqueInclinado(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;

		} else {
			eleccion = YELLOW + "o" + WHITE;
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							ataque = true;
							ataqueInclinado = true;
							y = i + 1;
							x = j + 1;
							exit = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							ataque = true;
							ataqueInclinado = true;
							y = i;
							x = j;
							exit = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							ataque = true;
							ataqueInclinado = true;
							y = i + 2;
							x = j + 2;
							exit = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para detectar las jugadas inclindas atacantes.
	 * 
	 * @param array  El tablero donde se decide las jugadas atacantes de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ataqueInclinado1(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;

		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j - 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j - 2].equals(eleccion)) {
							ataque = true;
							ataqueInclinado1 = true;
							y = i + 1;
							x = j - 1;
							exit = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j > 0)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j - 1 > 0)) && array[i + 1][j - 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j - 2 > 0)) && array[i + 2][j - 2].equals(eleccion)) {
							ataque = true;
							ataqueInclinado1 = true;
							y = i;
							x = j;
							exit = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j - 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j - 2].equals(".")) {
							ataque = true;
							ataqueInclinado1 = true;
							y = i + 2;
							x = j - 2;
							exit = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para detectar las jugadas horizontales atacantes.
	 * 
	 * @param array  El tablero donde se decide las jugadas atacantes de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private static void ataqueHorizontal(String[][] array, ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.ficha.x)) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							ataqueHorizontal = true;
							ataque = true;
							y = i;
							x = j + 1;
							exit = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							ataqueHorizontal = true;
							ataque = true;
							y = i;
							x = j + 2;
							exit = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(".")) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							ataqueHorizontal = true;
							ataque = true;
							y = i;
							x = j;
							exit = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo que llama a todos los metodos de ataque, defensa y ganar, ordenandolos
	 * por prioridad y decidiendo cual sera el resultado de la ia.
	 * 
	 * @param array  El tablero donde se decide las jugadas atacantes de la partida.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 * 
	 * @see #ganarHorizontal(String[][], ficha)
	 * @see #ganarInclinado(String[][], ficha)
	 * @see #ganarVertical(String[][], ficha)
	 * @see #defensaHorizontal(String[][], ficha)
	 * @see #defensaInclinado(String[][], ficha)
	 * @see #defensaInclinado1(String[][], ficha)
	 * @see #defensaVertical(String[][], ficha)
	 * @see #ataqueVertical(String[][], ficha)
	 * @see #ataqueHorizontal(String[][], ficha)
	 * @see #ataqueInclinado(String[][], ficha)
	 * @see #ataqueInclinado1(String[][], ficha)
	 * @see #retornar()
	 */
	public void jugadas(String[][] array, ficha fichas) {
		retornar();
		ganarHorizontal(array, fichas);
		ganarInclinado(array, fichas);
		ganarVertical(array, fichas);

		if (ganar) {
			if (ganarHorizontal) {
				numeros[0] = x;
				numeros[1] = y;
				retornar();
			} else if (ganarVertical) {
				numeros[0] = x;
				numeros[1] = y;
				retornar();
			} else if (ganarInclinado) {
				numeros[0] = x;
				numeros[1] = y;
				retornar();
			}
		} else {
			retornar();
			defensaInclinado(array, fichas);
			defensaInclinado1(array, fichas);
			defensaHorizontal(array, fichas);
			defensaVertical(array, fichas);
			if (defensa) {
				if (defensaInclinada) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaInclinada1) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaVertical) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaHorizontal) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				}
			} else {
				retornar();
				ataqueHorizontal(array, fichas);
				ataqueVertical(array, fichas);
				ataqueInclinado(array, fichas);
				ataqueInclinado1(array, fichas);
				if (ataque) {
					if (ataqueHorizontal) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (ataqueVertical) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (ataqueInclinado) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (ataqueInclinado1) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					}
				} else {
					numeros[0] = ran.nextInt(15) + 1;
					numeros[1] = ran.nextInt(15) + 1;
				}
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para sacar la posicion resultante.
	 * 
	 * @return int Retornar posicion
	 */
	public int getPosicion1() {
		return numeros[0];

	}

	/**
	 * Metodo para sacar la posicion resultante.
	 * 
	 * @return int Retornar posicion
	 */
	public int getPosicion2() {
		return numeros[1];
	}

}
