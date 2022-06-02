package GoMoku;

import java.util.Random;

/**
 * Clase hija del jugador, donde se enfatizaria en la inteligencia arificial, la
 * ia.
 * 
 * @author Alejandro Aguilar Alba
 * @version 2.0
 * @since 1.0
 *
 */

public class Ia extends Jugador {
	/**
	 * El constructor de la clase ia.
	 * 
	 * @param ficha Tipo de ficha
	 */
	public Ia(Ficha ficha) {
		super(ficha);
	}

	/**
	 * Reset de colores
	 */
	public static final String RESET = "\u001B[0m";
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
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida.
	 */
	public boolean ganar = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma horizontal.
	 */
	private boolean ganarHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma vertical.
	 */
	private boolean ganarVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar cuando se ha ganado la partida,
	 * de forma inclinada.
	 */
	private boolean ganarInclinado = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender y saber si es de gran prioridad.
	 */
	private boolean defensaMayor = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender y saber si es de poca prioridad.
	 */
	private boolean defensaMenor = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * horizontal y de gran prioridad.
	 */
	private boolean defensaMayorHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * horizontal y de poca prioridad.
	 */
	private boolean defensaMenorHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * vertical y de gran prioridad.
	 */
	private boolean defensaMayorVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * vertical y de poca prioridad.
	 */
	private boolean defensaMenorVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada y de gran prioridad.
	 */
	private boolean defensaMayorInclinada = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada y de poca prioridad.
	 */
	private boolean defensaMenorInclinada = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada y de gran prioridad.
	 */
	private boolean defensaMayorInclinada_2 = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que defender, de forma
	 * inclinada y de poca prioridad.
	 */
	private boolean defensaMenorInclinada_2 = false; 
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar.
	 */
	private boolean ataque = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * horizontal.
	 */
	private boolean ataqueHorizontal = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * vertical.
	 */
	private boolean ataqueVertical = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * inclinado.
	 */
	private boolean ataqueInclinado = false;
	/**
	 * Dato booleano que se utiliza para identificar si hay que atacar, de forma
	 * inclinado.
	 */
	private boolean ataqueInclinado1 = false;
	/**
	 * Dato int, para guardar la posicion para el array.
	 */
	private int x = 0;
	/**
	 * Dato int, para guardar la posicion para el array.
	 */
	private int y = 0;
	/**
	 * Llamada a la clase ramdon de java .
	 */
	private Random ran = new Random();
	/**
	 * Numero ramdon hasta el 9
	 */
	private int number = ran.nextInt(16);
	/**
	 * La creacion de un array unidimencional, con dos espacios .
	 */
	private int[] numeros = new int[2];

	/**
	 * Array con nombres predeterminados para la ia
	 */
	
	private String nombres[] = { "Pepe", "Jorge", "España", "Lisbania", "Me gustaria", "Francia caca", "Copenage",
			"Mordekaiser", "ElNen", "Estatico", "Dinamico","¿Me apruebas?","Te adoro","Jose no sabe programar","Wallapop","Gerardo que ya sabe programar"};

	/**
	 * Metodo para generar un nombre para la lia, distinta por cada ficha.
	 * 
	 * @return Devuelve el nombre de la ia.
	 */

	@Override
	public String getNombre() {
		return nombre = nombres[number];
	}
	/**
	 * Metodo para retornar todos los booleanos a falso
	 */
	private void retornar() {
		ganar = false;
		ganarHorizontal = false;

		defensaMayor = false;
		defensaMenor = false;

		defensaMayorHorizontal = false;
		defensaMenorHorizontal = false;

		defensaMayorVertical = false;
		defensaMenorVertical = false;

		defensaMayorInclinada = false;
		defensaMenorInclinada = false;

		defensaMayorInclinada_2 = false;
		defensaMenorInclinada_2 = false;

		ataque = false;

		ataqueHorizontal = false;
		ataqueVertical = false;
		ataqueInclinado = false;
		ataqueInclinado1 = false;
	}

	/**
	 * Metodo para detectar las jugadas horizontales defensivas de mayor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva horizontal.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaPrioridadHorizontal(String[][] array, GoMoku.Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
									defensaMayorHorizontal = true;
									defensaMayor = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(".")) {
									defensaMayorHorizontal = true;
									defensaMayor = true;
									exit = true;
									y = i;
									x = j + 4;
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
									defensaMayorHorizontal = true;
									defensaMayor = true;
									exit = true;
									y = i;
									x = j;
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
									defensaMayorHorizontal = true;
									defensaMayor = true;
									exit = true;
									y = i;
									x = j + 1;
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
									defensaMayorHorizontal = true;
									defensaMayor = true;
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
	}
	/**
	 * Metodo para detectar las jugadas horizontales defensivas de menor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva horizontal.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMenorHorizontal(String[][] array, GoMoku.Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								defensaMenorHorizontal = true;
								defensaMenor = true;
								exit = true;
								y = i;
								x = j + 2;

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
								defensaMenorHorizontal = true;
								defensaMenor = true;
								exit = true;
								y = i;
								x = j + 1;
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
								defensaMenorHorizontal = true;
								defensaMenor = true;
								exit = true;
								y = i;
								x = j + 3;
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
								defensaMenorHorizontal = true;
								defensaMenor = true;
								exit = true;
								y = i;
								x = j;
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
	 * Metodo para detectar las jugadas verticales defensivas de mayor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva vertical.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaPrioridadVertical(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorVertical = true;
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
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(".")) {
									defensaMayor = true;
									defensaMayorVertical = true;
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
									defensaMayor = true;
									defensaMayorVertical = true;
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
									defensaMayor = true;
									defensaMayorVertical = true;
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

	}
	/**
	 * Metodo para detectar las jugadas verticales defensivas de menor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva vertical.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMenorVertical(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorVertical = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorVertical = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(".")) {
								defensaMenor = true;
								defensaMenorVertical = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorVertical = true;
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
	 * Metodo para detectar las jugadas inclinadas defensivas de mayor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMayorInclinado(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada = true;
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
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")) {
									defensaMayor = true;
									defensaMayorInclinada = true;
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
				if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada = true;
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
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada = true;
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
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada = true;
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

	}
	/**
	 * Metodo para detectar las jugadas inclinadas defensivas de menor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMenorInclinado(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								defensaMenor = true;
								defensaMenorInclinada = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada = true;
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
	 * Metodo para detectar las jugadas inclinadas defensivas de mayor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMayorInclinado1(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada_2 = true;
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
				if ((i < 16 && j > 0) && array[i][j].equals(".")) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada_2 = true;
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
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(".")) {
									defensaMayor = true;
									defensaMayorInclinada_2 = true;
									y = i + 4;
									x = j - 4;
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
									defensaMayor = true;
									defensaMayorInclinada_2 = true;
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
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(".")) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
									defensaMayor = true;
									defensaMayorInclinada_2 = true;
									y = i + 1;
									x = j - 1;
									exit = true;
								}
							}
						}
					}
				}
			}
		}

	}
	/**
	 * Metodo para detectar las jugadas inclinadas defensivas de menor prioridad.
	 * 
	 * @param array  El tablero donde se decide la jugada defensiva inclinada.
	 * @param fichas Tipo de ficha para usar en el tablero.
	 */
	private void defensaMenorInclinado1(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = YELLOW + "o" + RESET;

		} else {
			eleccion = BLUE + "x" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(".")) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada_2 = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada_2 = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(".")) {
								defensaMenor = true;
								defensaMenorInclinada_2 = true;
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
			for (int j = 0; j < array.length && !exit; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(".")) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
								defensaMenor = true;
								defensaMenorInclinada_2 = true;
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
	private void ganarHorizontal(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
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
	private void ganarVertical(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
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
	private void ganarInclinado(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
		}
		for (int i = 0; i < array.length && !exit; i++) {
			for (int j = 0; j < array.length && !exit; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")) {
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
	private void ataqueVertical(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
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
	private void ataqueInclinado(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
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
	private void ataqueInclinado1(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;

		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;

		} else {
			eleccion = YELLOW + "o" + RESET;
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
	private void ataqueHorizontal(String[][] array, Ficha fichas) {
		boolean exit = false;
		String eleccion;
		if (fichas.equals(GoMoku.Ficha.x)) {
			eleccion = BLUE + "x" + RESET;
		} else {
			eleccion = YELLOW + "o" + RESET;
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
	 * @see #ganarHorizontal(String[][], Ficha)
	 * @see #ganarInclinado(String[][], Ficha)
	 * @see #ganarVertical(String[][], Ficha)
	 * @see #defensaMayorInclinado(String[][], Ficha)
	 * @see #defensaMayorInclinado1(String[][], Ficha)
	 * @see #defensaPrioridadHorizontal(String[][], Ficha)
	 * @see #defensaPrioridadVertical(String[][], Ficha)
	 * @see	#defensaMenorInclinado(String[][], Ficha)
	 * @see	#defensaMenorInclinado1(String[][], Ficha)
	 * @see	#defensaMenorHorizontal(String[][], Ficha)
	 * @see	#defensaMenorVertical(String[][], Ficha)
	 * @see #ataqueVertical(String[][], Ficha)
	 * @see #ataqueHorizontal(String[][], Ficha)
	 * @see #ataqueInclinado(String[][], Ficha)
	 * @see #ataqueInclinado1(String[][], Ficha)
	 * @see #retornar()
	 */
	public void jugadas(String[][] array, Ficha fichas) {
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
			defensaMayorInclinado(array, fichas);
			defensaMayorInclinado1(array, fichas);
			defensaPrioridadHorizontal(array, fichas);
			defensaPrioridadVertical(array, fichas);
			if (defensaMayor) {
				if (defensaMayorInclinada) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaMayorInclinada_2) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaMayorVertical) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				} else if (defensaMayorHorizontal) {
					numeros[0] = x;
					numeros[1] = y;
					retornar();
				}
			} else {
				defensaMenorInclinado(array, fichas);
				defensaMenorInclinado1(array, fichas);
				defensaMenorHorizontal(array, fichas);
				defensaMenorVertical(array, fichas);
				if (defensaMenor) {
					if (defensaMenorInclinada) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (defensaMenorInclinada_2) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (defensaMenorVertical) {
						numeros[0] = x;
						numeros[1] = y;
						retornar();
					} else if (defensaMenorHorizontal) {
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
