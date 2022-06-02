package GoMoku;

import java.util.Scanner;

/**
 * 
 * Clase donde se realiza la partida usando la clase Jugador, la
 * clase Tablero y metodos propios de la clase.
 * 
 * @author Alejandro Aguilar Alba
 * @version 2.0
 * @since 1.0
 * 
 */
public class Partida {
	/**
	 * El color rojo, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String RED = "\u001B[31m";
	/**
	 * El color cian, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String CYAN = "\u001B[36m";
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
	 * El color morado, se utiliza para cambiar el color a las letras en la consola
	 */
	public static final String PURPLE = "\u001B[35m";
	/**
	 * El color rojo, se utiliza para cambiar el color del fondo de la consola
	 */
	public static final String RED_BACKGROUND = "\u001B[41m";
	/**
	 * El color amarillo, se utiliza para cambiar el color del fondo de la consola
	 */
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	/**
	 * Reseteo de colores
	 */
	public static final String RESET = "\u001B[0m";

	/**
	 * La clase Tablero, pero sin declarar.
	 */
	private Tablero tabla;
	/**
	 * La clase Jugador, pero sin declarar.
	 */
	private Jugador jugador1;
	/**
	 * La clase Jugador, pero sin declarar.
	 */
	private Jugador jugador2;

	/**
	 * Variable booleana donde se sale del bucle do.while del juego.
	 */
	private boolean exit = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarJugadorvsJugador1 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarJugadorvsJugador2 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarJugadorvsIa1 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarJugadorvsIa2 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarIarvsIa1 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganarIarvsIa2 = false;
	/**
	 * Variable booleana para salir del bucle do.while de la partida y decir que es por un empate.
	 */
	private boolean empate = false;
	/**
	 * variable String donde se capta el nombre del jugador.
	 */
	private String nombre;
	/**
	 * variable String donde se capta el nombre del jugador2.
	 */
	private String nombre2;
	/**
	 * variable int para captar una posicion para el array.
	 */
	private int posicion1;
	/**
	 * variable int para captar una posicion para el array.
	 */
	private int posicion2;
	/**
	 * variable int para captar el tipo de juego que se desea jugar.
	 */
	private int tipoNumerico = 0;
	/**
	 * variable Ficha para captar el tipo de ficha que va ha tener el jugador1 en concreto.
	 */
	private Ficha player1;
	/**
	 * variable Ficha para captar el tipo de ficha que va ha tener el jugador2 en concreto.
	 */
	private Ficha player2;
	/**
	 * variable int para decidir el tipo de ficha que va tener el jugador.
	 */
	private int playerNumber;

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para parar la partida, o continuarla.
	 */
	@SuppressWarnings("resource")
	private void reinicio() {
		int number;
		boolean escape = false;
		Scanner sc = new Scanner(System.in);
		do {

			try {

				do {
					System.out.println("\n 1- Seguir \n 2- Parar\n ");
					 number = sc.nextInt();
				} while (!(number < 0) && !(number <= 2));

				if (number == 1) {
					escape = true;
					exit = true;
				} else {
					escape = true;
					exit = false;
				}
			} catch (Exception InputMismatchException) {
				System.out.println("\n Introduce un numero del 1 al 2 \n ");
				escape = false;
				sc.nextLine();
			}

		} while (!escape);
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para sacar una posicion del tablero.
	 * 
	 */
	@SuppressWarnings("resource")
	private void letra() {
		char transformar;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Introduca la poscion del 'a' hasta la 'o', \nsolo detectara el primer caracter introducido");
			transformar = sc.next().charAt(0);
			sc.nextLine();
			posicion1 = transformar - 96;
		} while (!(posicion1 > 0 && posicion1 < 16));
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para captar la posicion por numeros, donde solo se puede obtener una
	 * margen de numeros del 1 al 15, y rechaza cualquier otro caracter.
	 *
	 */
	@SuppressWarnings("resource")
	private void numero() {
		boolean escape = false;
		Scanner sc = new Scanner(System.in);
		do {
//almeria
			try {

				do {
					System.out.println("Introduca la poscion del 1 al 15");
					posicion2 = sc.nextInt();
				} while (!(posicion2 < 0) && !(posicion2 <= 15));

				if (posicion2 > 0 && posicion2 <= 15) {
					escape = true;
				}
			} catch (Exception InputMismatchException) {
				escape = false;
				sc.nextLine();
			}

		} while (!escape);
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo que recoge el nombre del jugador Real, donde dependiendo del modo escogera pedira ningun nombre, un nombre o dos nombres.
	 * 
	 */
	@SuppressWarnings("resource")
	private void nombres() {
		Scanner sc = new Scanner(System.in);
		if (2 == tipoNumerico) {
			do {
				System.out.printf("\n Introduce un nombre \n");
				nombre = sc.nextLine();
			} while (nombre.length() == 0);
		} else if (3 == tipoNumerico) {
			do {
				System.out.printf("\n Nombre del jugador uno \n");
				nombre = sc.nextLine();
			} while (nombre.length() == 0);
			do {
				System.out.printf("\n Nombre del jugador dos \n");
				nombre2 = sc.nextLine();
			} while (nombre2.length() == 0);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo por la cual se decide el tipo de juego que se va ha escoger, ia vs ia,
	 * ia vs jugador, jugador vs jugador.
	 */
	@SuppressWarnings("resource")
	private void comienzos() {
		boolean salida = false;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.printf(
						"Tipo de juego(Seleccione un numero): \n 1 %sia vs ia %s(Inteligencia artificial contra Inteligencia artificial)%s \n%s 2 %sia vs jugador %s(Inteligencia artificial contra Jugador real)\n%s 3 %sjugador vs jugador %s(Jugador real contra Jugador real)%s \n",
						CYAN, PURPLE, RESET, RESET, CYAN, PURPLE, RESET, CYAN, PURPLE, RESET);
				tipoNumerico = sc.nextInt();
				if (tipoNumerico > 0 && tipoNumerico <= 3) {
					salida = true;
				} else {
					System.out.printf("Introduce un valor entre 1 al 3 \n");
					sc.nextLine();
				}
			} catch (Exception e) {
				System.out.printf("Introduce un valor entre 1 al 3 \n");
				sc.nextLine();
			}

		} while (!salida);
	}
	/**
	 * Metodo para captar el tipo de ficha que va ha tener cada jugador
	 */
	@SuppressWarnings("resource")
	private void tipoFicha() {
		boolean salida = false;
		Scanner sc = new Scanner(System.in);
		System.out.printf(
				"\nIdentifica el tipo de ficha para el jugador 1, se le dara al jugador la ficha opuesta a la escogida\n\n Selecione%s 1%s para escoger la %sficha x%s y el %s2 %spara la%s ficha o%s\n\n",RED,RESET,BLUE,RESET,RED,RESET,YELLOW,RESET);
		do {
			try {
				playerNumber = sc.nextInt();
				if (playerNumber > 0 && playerNumber <= 2) {
					salida = true;
				} else {
					System.out.printf(RED + "Introduce un valor entre 1 al 2 \n" + RESET);
					sc.nextLine();
				}
			} catch (Exception e) {
				System.out.printf(RED + "Introduce un valor entre 1 al 2 \n" + RESET);
				sc.nextLine();
			}

		} while (!salida);

		if (playerNumber == 1) {
			player1 = Ficha.x;
			player2 = Ficha.o;
		} else {
			player1 = Ficha.o;
			player2 = Ficha.x;
		}
	}
	/**
 	* Metodo para pintar en consola el nombre del jugador 1
 	*/
	private void pintarNombreJugador_1() {
		if (playerNumber == 1) {
			System.out.printf(RESET + "\n\n---------------------------------------------\n   " + BLUE + "   "
					+ jugador1.getNombre() + RESET + " le toca \n---------------------------------------------\n\n");
		} else {
			System.out.printf(RESET + "\n\n---------------------------------------------\n   " + YELLOW + "   "
					+ jugador1.getNombre() + RESET + " le toca \n---------------------------------------------\n\n");

		}
	}
	/**
 	* Metodo para pintar en consola el nombre del jugador 2
 	*/
	private void pintarNombreJugador_2() {
		if (playerNumber == 1) {
			System.out.printf(RESET + "\n\n---------------------------------------------\n   " + YELLOW + "   "
					+ jugador2.getNombre() + RESET + " le toca \n---------------------------------------------\n\n");
		} else {
			System.out.printf(RESET + "\n\n---------------------------------------------\n   " + BLUE + "   "
					+ jugador2.getNombre() + RESET + " le toca \n---------------------------------------------\n\n");

		}
	}

	/**
	 * Metodo donde se realiza todas las instrucciones necesarias del jugador real.
	 * 
	 * @param ficha Tipo de ficha
	 */
	private void jugdorReal(Ficha ficha) {
		
		do {
			letra();
			numero();
			if (tabla.revision(posicion2, posicion1)) {
				System.out.println(RED + " \n Introducelo en otra ubicación \n" + RESET);
			}
		} while (tabla.revision(posicion2, posicion1));

	}
	/**
	 * Metodo donde saca por pantalla el ganador de la partida, o si han quedado empate
	 */
	private void resultado() {
		if (ganarIarvsIa1) {
			
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
			
			
		} else if (ganarIarvsIa2) {
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
		} else if (ganarJugadorvsIa1) {
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
		} else if (ganarJugadorvsIa2) {
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
		} else if (ganarJugadorvsJugador1) {
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador1.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
		} else if (ganarJugadorvsJugador2) {
			switch (playerNumber) {
			case 1:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + YELLOW + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;

			default:
				System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
						+ "   Ha ganado el jugador ->   " + BLUE + jugador2.getNombre() + RESET
						+ "\n---------------------------------------------\n\n");
				break;
			}
		} else if (empate) {
			System.out.printf(RESET + "\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n" + RED
					+ "   Empate ninguno gano" + RESET + "\n---------------------------------------------\n\n");
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 *  Metodo por la cual se realiza el juego extrayendo las clases Tablero y
	 * Jugador, y sus metodos.
	 * 
	 * @see #comienzos()
	 * @see #nombres()
	 * @see #tipoFicha()
	 * @see #pintarNombreJugador_1()
	 * @see #pintarNombreJugador_2()
	 * @see #resultado()
	 * @see #reinicio()
	 */
	public void comenzar() {
		System.out.println("  ____     ______    ___    ___    ______    ___   ___   __    __       ________              _______\n"
				+ " |  __|   |  __  |  |   |  |   |  |  __  |  |   | /  /  |  |   |  |    /   __   \\            |   _   |\n"
				+ " | |  _   | |  | |  |   \\__/   |  | |  | |  |   |/  /   |  |   |  |    \\__|  /  /            |  | |  |\n"
				+ " | |_| |  | |__| |  |          |  | |__| |  |       \\   |  \\___/  |      ___/  /___    __    |  |_|  |\n"
				+ " |_____|  |______|  |__|\\__/|__|  |______|  |___|\\___\\  |_________|     |__________|  |__|   |_______|\n");
		do {
			tabla = new Tablero();
			comienzos();
			nombres();
			tipoFicha();
			// ---------------------------------------------------
			if (tipoNumerico == 3) {
				jugador1 = new Real(player1,nombre );
				jugador2 = new Real(player2,nombre2 );
				tabla.mostrarTablero();
				do {
					pintarNombreJugador_1();
					jugdorReal(jugador1.getFicha());
					ganarJugadorvsJugador1 = tabla.pintar(posicion2, posicion1, jugador1.getFicha());
					empate = tabla.empate();
					if (!ganarJugadorvsJugador1 && !empate) {
						pintarNombreJugador_2();
						jugdorReal(jugador2.getFicha());
						ganarJugadorvsJugador2 = tabla.pintar(posicion2, posicion1, jugador2.getFicha());
						empate = tabla.empate();
					}
				} while (!ganarJugadorvsJugador2 && !ganarJugadorvsJugador1 & !empate);
			} else if (tipoNumerico == 1) {
				jugador1 = new Ia(player1);
				jugador2 = new Ia(player2);
				do {
					pintarNombreJugador_1();

					do {
						((Ia) jugador1).jugadas(tabla.getTablero(), jugador1.getFicha());
						posicion1 = ((Ia) jugador1).getPosicion1();
						posicion2 = ((Ia) jugador1).getPosicion2();
					} while (tabla.revision(posicion2, posicion1));

					ganarIarvsIa1 = tabla.pintar(posicion2, posicion1, jugador1.getFicha());
					empate = tabla.empate();
					tabla.timeOut();
					if (!ganarIarvsIa1 && !empate) {
						pintarNombreJugador_2();

						do {
							((Ia) jugador2).jugadas(tabla.getTablero(), jugador2.getFicha());
							posicion1 = ((Ia) jugador2).getPosicion1();
							posicion2 = ((Ia) jugador2).getPosicion2();
						} while (tabla.revision(posicion2, posicion1));

						ganarIarvsIa2 = tabla.pintar(posicion2, posicion1, jugador2.getFicha());

						empate = tabla.empate();
						tabla.timeOut();
					}

				} while (!ganarIarvsIa2 && !ganarIarvsIa1 && !empate);

			} else if (tipoNumerico == 2) {
				tabla.mostrarTablero();
				jugador1 = new Real(player1,nombre);
				jugador2 = new Ia(player2);
				do {

					pintarNombreJugador_1();

					jugdorReal(jugador1.getFicha());
					ganarJugadorvsIa1 = tabla.pintar(posicion2, posicion1, jugador1.getFicha());

					empate = tabla.empate();
					tabla.timeOut();

					if (!ganarJugadorvsIa1 && !empate) {
						pintarNombreJugador_2();

						do {
							((Ia) jugador2).jugadas(tabla.getTablero(), jugador2.getFicha());

							posicion1 = ((Ia) jugador2).getPosicion1();
							posicion2 = ((Ia) jugador2).getPosicion2();
						} while (tabla.revision(posicion2, posicion1));
						
						ganarJugadorvsIa2 = tabla.pintar(posicion2, posicion1, jugador2.getFicha());
						empate = tabla.empate();
						tabla.timeOut();
					}

				} while (!ganarJugadorvsIa1 && !ganarJugadorvsIa2 && !empate);

			}
			resultado();
			tabla.pintarBandera();
			System.out.println(RED + " \n ¿Desea jugar otra partida? \n" + RESET);
			reinicio();

		} while (exit);
		System.out.println(RED + " \n Espero que lo haya disfrutado \n" + RESET);
	}

}
