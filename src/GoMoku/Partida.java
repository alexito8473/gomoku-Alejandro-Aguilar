package GoMoku;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase donde se realiza la partida, usando parte de la clase Jugador y la
 * clase Tablero, donde se genera la partida, y se utiliza los métodos
 * pertinentes para la captación de datos.
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
	 * El color blanco, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String WHITE = "\u001B[37m";
	/**
	 * El color cian, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String CYAN = "\u001B[36m";
	/**
	 * El color azul, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String BLUE = "\u001B[34m";
	/**
	 * El color azul, se utiliza para cambiar el color a las letras en la consola.
	 */
	private static final String YELLOW = "\u001B[33m";
	/**
	 * La clase Tablero, pero sin declarar.
	 */
	private static Tablero tabla;
	/**
	 * La clase Jugador, pero sin declarar.
	 */
	private static Jugador jugador1;
	/**
	 * La clase Jugador, pero sin declarar.
	 */
	private static Jugador jugador2;

	/**
	 * La clase Scanner.
	 */
	private static Scanner sc = new Scanner(System.in);
	/**
	 * La clase Random.
	 */
	private static Random ram = new Random();

	/**
	 * variable booleana donde se sale del bucle do.while del juego.
	 */
	private static boolean exit = false;
	/**
	 * variable booleana para salir del bucle do.while de la partida.
	 */
	private static boolean ganar = false;

	/**
	 * variable String donde se capta el nombre del jugador.
	 */
	private static String nombre;
	/**
	 * variable String donde se capta el nombre del jugador2.
	 */
	private static String nombre2;
	/**
	 * variable String donde se capta el la posicion alfabetica determina, para
	 * después retornarla a un int.
	 */
	private static String transformare;

	/**
	 * variable int para captar una posición para el array.
	 */
	private static int posicion1;
	/**
	 * variable int para captar una posición para el array.
	 */
	private static int posicion2;
	/**
	 * variable int para captar el tipo de juego que se desea jugar.
	 */
	private static int tipoNumerico = 0;

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo para pausar la partida, o continuarla.
	 */
	private static void reinicio() {
		int number;
		boolean escape = false;
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
	 * Método para pausar la consola
	 */
	private static void timeOut() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Método para transformar para captar y transformas las posicines que se
	 * optienen por letras, y forzar que solo se recibe un margen de letras
	 * 
	 * @see #transformar(String)
	 */
	private static void letra() {
		do {
			System.out.println("Introduca la poscion del 'a' hasta la 'o'");
			transformare = sc.next();
			sc.nextLine();

		} while (!(transformare.equals("a") || transformare.equals("b") || transformare.equals("c")
				|| transformare.equals("d") || transformare.equals("e") || transformare.equals("g")
				|| transformare.equals("f") || transformare.equals("h") || transformare.equals("i")
				|| transformare.equals("j") || transformare.equals("k") || transformare.equals("l")
				|| transformare.equals("m") || transformare.equals("n") || transformare.equals("o")));
		transformar(transformare);
	}

	/**
	 * Método donde capta un String determinado y lo transforma en un número.
	 * 
	 * @param posicion, las letras determinadas que entraran para se transdormada en
	 *                  numero.
	 */
	public static void transformar(String posicion) {
		switch (posicion.toLowerCase()) {
		case "a":
			posicion1 = 1;
			break;
		case "b":
			posicion1 = 2;
			break;
		case "c":
			posicion1 = 3;
			break;
		case "d":
			posicion1 = 4;
			break;
		case "e":
			posicion1 = 5;
			break;
		case "f":
			posicion1 = 6;
			break;
		case "g":
			posicion1 = 7;
			break;
		case "h":
			posicion1 = 8;
			break;
		case "i":
			posicion1 = 9;
			break;
		case "j":
			posicion1 = 10;
			break;
		case "k":
			posicion1 = 11;
			break;
		case "l":
			posicion1 = 12;
			break;
		case "m":
			posicion1 = 13;
			break;
		case "n":
			posicion1 = 14;
			break;
		case "o":
			posicion1 = 15;
			break;
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Método para captar la posicion por numeros, donde solo se puede obtener una
	 * margen de numeros del 1 al 15, y rechaza cualquier otro carapteres.
	 *
	 */
	private static void numero() {
		boolean escape = false;
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
	 * Método por la cual dependiendo de lo que se haya decidido del tipo del juego,
	 * se pediera que decidas un nombre para un jugador o dos jugadores.
	 */
	private static void nombres() {
		sc.nextLine();
		if (2 == tipoNumerico) {
			System.out.printf("\n Introduce un nombre \n");
			nombre = sc.nextLine();
		} else if (3 == tipoNumerico) {
			System.out.printf("\n Nombre del jugador uno \n");
			nombre = sc.nextLine();
			System.out.printf("\n Nombre del jugador dos \n");
			nombre2 = sc.nextLine();
		}
	}

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Método por la cual se decid el tipo de juego que se va ha escoger, ia vs ia,
	 * ia vs jugador, jugador vs jugador.
	 */
	private static void comienzos() {
		boolean salida = false;
		do {

			try {
				System.out.printf(
						"Tipo de juego(Seleccione un numero): \n 1 %sia vs ia %s \n%s 2 %sia vs jugador \n%s 3 %sjugador vs jugador %s \n",
						CYAN, WHITE, WHITE, CYAN, WHITE, CYAN, WHITE);
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

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Método por la cual se realiza el juego extrayendo las clases Tablero y
	 * Jugador, y sus métodos.
	 *
	 * @see #comienzos()
	 * @see #nombres()
	 * @see #timeOut()
	 * @see #letra()
	 * @see #numero()
	 * @see #reinicio()
	 */
	public static void Comenzar() {
		System.out.println("Gomoku");
		do {
			tabla = new Tablero();
			comienzos();
			nombres();
			// ---------------------------------------------------
			if (tipoNumerico == 3) {
				jugador1 = new real(nombre, ficha.x);
				jugador2 = new real(nombre2, ficha.o);
				tabla.mostrarTablero();
				do {
					System.out.printf("\n---------------------------------------------\n   " + BLUE
							+ ((real) jugador1).getNombre() + WHITE
							+ " le toca \n---------------------------------------------\n\n");

					do {
						letra();
						numero();
						if (tabla.revision(posicion2, posicion1)) {
							System.out.println(RED + " \n Introducelo en otra ubicación \n" + WHITE);
						}
					} while (tabla.revision(posicion2, posicion1));

					tabla.modificarTablero(posicion2, posicion1, ficha.x);
					tabla.mostrarTablero();
					tabla.modificarFicha(posicion2, posicion1, ficha.x);
					ganar = tabla.ganar(ficha.x);
					if (!ganar) {
						System.out.printf("\n---------------------------------------------\n   " + YELLOW
								+ ((real) jugador2).getNombre() + WHITE
								+ " le toca \n---------------------------------------------\n \n");
						do {
							letra();
							numero();
							if (tabla.revision(posicion2, posicion1)) {
								System.out.println(RED + " \n Introducelo en otra ubicación \n" + WHITE);
							}
						} while (tabla.revision(posicion2, posicion1));

						tabla.modificarTablero(posicion2, posicion1, ficha.o);
						tabla.mostrarTablero();
						tabla.modificarFicha(posicion2, posicion1, ficha.o);
						ganar = tabla.ganar(ficha.o);
					}

				} while (!ganar);
			} else if (tipoNumerico == 1) {
				jugador1 = new ia(ficha.x);
				jugador2 = new ia(ficha.o);
				do {
					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n" + BLUE
							+ ((ia) jugador1).nombre(ficha.x) + WHITE
							+ " le toca \n---------------------------------------------\n\n");

					do {
						((ia) jugador1).jugadas(tabla.getTablero(), ficha.x);

						posicion1 = ((ia) jugador1).getPosición1();
						posicion2 = ((ia) jugador1).getPosición2();
					} while (tabla.revision(posicion2, posicion1));

					tabla.modificarTablero(posicion2, posicion1, ficha.x);
					tabla.mostrarTablero();
					tabla.modificarFicha(posicion2, posicion1, ficha.x);
					ganar = tabla.ganar(ficha.x);
					timeOut();
					if (!ganar) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
								+ YELLOW + ((ia) jugador2).nombre(ficha.o) + WHITE
								+ " le toca \n---------------------------------------------\n\n");

						do {
							((ia) jugador2).jugadas(tabla.getTablero(), ficha.o);

							posicion1 = ((ia) jugador2).getPosición1();
							posicion2 = ((ia) jugador2).getPosición2();
						} while (tabla.revision(posicion2, posicion1));

						tabla.modificarTablero(posicion2, posicion1, ficha.o);
						tabla.mostrarTablero();
						tabla.modificarFicha(posicion2, posicion1, ficha.o);
						ganar = tabla.ganar(ficha.o);
						timeOut();
					}
				} while (!ganar);
			} else if (tipoNumerico == 2) {
				tabla.mostrarTablero();
				jugador1 = new real(nombre, ficha.x);
				jugador2 = new ia(ficha.o);
				do {

					System.out.printf("\n---------------------------------------------\n   " + BLUE + nombre + WHITE
							+ " le toca \n---------------------------------------------\n\n");
					do {
						letra();
						numero();
						if (tabla.revision(posicion2, posicion1)) {
							System.out.println(RED + " \n Introducelo en otra ubicación \n" + WHITE);
						}
					} while (tabla.revision(posicion2, posicion1));

					tabla.modificarTablero(posicion2, posicion1, ficha.x);
					tabla.mostrarTablero();
					tabla.modificarFicha(posicion2, posicion1, ficha.x);
					ganar = tabla.ganar(ficha.x);
					timeOut();
					if (!ganar) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
								+ YELLOW + ((ia) jugador2).nombre(ficha.o) + WHITE
								+ " le toca \n---------------------------------------------\n\n");

						do {
							((ia) jugador2).jugadas(tabla.getTablero(), ficha.o);

							posicion1 = ((ia) jugador2).getPosición1();
							posicion2 = ((ia) jugador2).getPosición2();
						} while (tabla.revision(posicion2, posicion1));

						tabla.modificarTablero(posicion2, posicion1, ficha.o);
						tabla.mostrarTablero();
						tabla.modificarFicha(posicion2, posicion1, ficha.o);
						ganar = tabla.ganar(ficha.o);

					}
				} while (!ganar);
			}
			System.out.println(RED + " \n BUENA PARTIDA <3 \n" + WHITE);
			System.out.println(RED + " \n ¿Desea jugar otra partida? \n" + WHITE);
			reinicio();

		} while (exit);
		System.out.println(RED + " \n Espero que lo haya disfrutado \n" + WHITE);
	}

}
