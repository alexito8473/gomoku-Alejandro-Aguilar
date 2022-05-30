package GoMoku;

import java.util.Scanner;

/**
 * Clase donde se realiza la partida, usando parte de la clase Jugador y la
 * clase Tablero, donde se genera la partida, y se utiliza los metodos
 * pertinentes para la captacion de datos.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
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
	 * Resetear colores
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
	 * variable booleana donde se sale del bucle do.while del juego.
	 */
	private boolean exit = false;
	/**
	 * variable booleana para salir del bucle do.while de la partida.
	 */
	private boolean ganar = false;

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
	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para pausar la partida, o continuarla.
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
	 * Metodo para................................
	 * 
	 * @see #transformar(String)
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
	 * margen de numeros del 1 al 15, y rechaza cualquier otro carapteres.
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
	 * Metodo por la cual dependiendo de lo que se haya decidido del tipo del juego,
	 * se pediera que decidas un nombre para un jugador o dos jugadores.
	 */
	@SuppressWarnings("resource")
	private void nombres() {
		Scanner sc = new Scanner(System.in);
		if (2 == tipoNumerico) {
			do {
			System.out.printf("\n Introduce un nombre \n");
			nombre = sc.nextLine();
			}while(nombre.length()==0);
		} else if (3 == tipoNumerico) {
			do {
			System.out.printf("\n Nombre del jugador uno \n");
			nombre = sc.nextLine();
			}while(nombre.length()==0);
			do {
			System.out.printf("\n Nombre del jugador dos \n");
			nombre2 = sc.nextLine();
			}while(nombre2.length()==0);
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo por la cual se decid el tipo de juego que se va ha escoger, ia vs ia,
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
	 * Metodo donde se realiza todas las instrucciones necesarias del jugador
	 * 
	 * @param ficha Tipo de ficha
	 */
	private void jugdorReal(Ficha ficha) {
		do {
			letra();
			numero();
			if (tabla.revision(posicion2, posicion1)) {
				System.out.println(RED + " \n Introducelo en otra ubicación \n" +  RESET);
			}
		} while (tabla.revision(posicion2, posicion1));

	}

	/**
	 * Metodo donde se realiza todas las instrucciones necesarias del pintar el
	 * tablero
	 * 
	 * @param ficha Tipo ficha
	 */
	private void pintar(Ficha ficha) {
		tabla.modificarTablero(posicion2, posicion1, ficha);
		tabla.mostrarTablero();
		tabla.modificarFicha(posicion2, posicion1, ficha);
		ganar = tabla.ganar(ficha);
	}



	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo por la cual se realiza el juego extrayendo las clases Tablero y
	 * Jugador, y sus metodos.
	 *
	 * @see #comienzos()
	 * @see #nombres()
	 * @see #timeOut()
	 * @see #letra()
	 * @see #numero()
	 * @see #reinicio()
	 */
	public void comenzar() {
		System.out.println("  ____     ______    ___    ___    ______    ___   ___   __     __  \n"
				+ " |  __|   |  __  |  |   |  |   |  |  __  |  |   | /  /  |  |   |  | \n"
				+ " | |  _   | |  | |  |   \\__/   |  | |  | |  |   |/  /   |  |   |  | \n"
				+ " | |_| |  | |__| |  |          |  | |__| |  |       \\   |  \\___/  | \n"
				+ " |_____|  |______|  |__|\\__/|__|  |______|  |___|\\___\\  |_________| \n");
		do {
			tabla = new Tablero();
			comienzos();
			nombres();
			// ---------------------------------------------------
			if (tipoNumerico == 3) {
				jugador1 = new Real(nombre, Ficha.x);
				jugador2 = new Real(nombre2, Ficha.o);
				tabla.mostrarTablero();
				do {
					System.out.printf( RESET+"\n---------------------------------------------\n   " + BLUE
							+ ((Real) jugador1).getNombre() + RESET
							+ " le toca \n---------------------------------------------\n\n");

					jugdorReal(Ficha.x);
					pintar(Ficha.x);
					if (!ganar) {
						System.out.printf(RESET+"\n---------------------------------------------\n   " + YELLOW
								+ ((Real) jugador2).getNombre() + RESET
								+ " le toca \n---------------------------------------------\n \n");
						jugdorReal(Ficha.o);
						pintar(Ficha.o);
					}
				} while (!ganar);
			} else if (tipoNumerico == 1) {
				jugador1 = new Ia(Ficha.x);
				jugador2 = new Ia(Ficha.o);
				do {
					System.out.printf(RESET+"\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n" + BLUE
							+ ((Ia) jugador1).nombre() + RESET
							+ " le toca \n---------------------------------------------\n\n");

					do {
						((Ia) jugador1).jugadas(tabla.getTablero(), Ficha.x);
						posicion1 = ((Ia) jugador1).getPosicion1();
						posicion2 = ((Ia) jugador1).getPosicion2();
					} while (tabla.revision(posicion2, posicion1));
					
					pintar(Ficha.x);
					tabla.timeOut();
					
					if (!ganar) {
						System.out.printf(RESET+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
								+ YELLOW + ((Ia) jugador2).nombre() + RESET
								+ " le toca \n---------------------------------------------\n\n");

						do {
							((Ia) jugador2).jugadas(tabla.getTablero(), Ficha.o);
							posicion1 = ((Ia) jugador2).getPosicion1();
							posicion2 = ((Ia) jugador2).getPosicion2();
						} while (tabla.revision(posicion2, posicion1));

						pintar(Ficha.o);
						tabla.timeOut();
					}
				} while (!ganar);
			} else if (tipoNumerico == 2) {
				tabla.mostrarTablero();
				jugador1 = new Real(nombre, Ficha.x);
				jugador2 = new Ia(Ficha.o);
				do {

					System.out.printf(RESET+"\n---------------------------------------------\n   " + BLUE + nombre + RESET
							+ " le toca \n---------------------------------------------\n\n");
					jugdorReal(Ficha.x);
					pintar(Ficha.x);
					tabla.timeOut();
					if (!ganar) {
						System.out.printf(RESET+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
								+ YELLOW + ((Ia) jugador2).nombre() + RESET
								+ " le toca \n---------------------------------------------\n\n");

						do {
							((Ia) jugador2).jugadas(tabla.getTablero(), Ficha.o);

							posicion1 = ((Ia) jugador2).getPosicion1();
							posicion2 = ((Ia) jugador2).getPosicion2();
						} while (tabla.revision(posicion2, posicion1));
						pintar(Ficha.o);

					}
				} while (!ganar);
			}
			tabla.pintarBandera();
			System.out.println(RED + " \n ¿Desea jugar otra partida? \n" + RESET);
			reinicio();

		} while (exit);
		System.out.println(RED + " \n Espero que lo haya disfrutado \n" + RESET);
	}

}
