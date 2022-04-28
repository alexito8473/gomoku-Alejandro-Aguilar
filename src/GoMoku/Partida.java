package GoMoku;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Partida {

	public static final String RED = "\u001B[31m";
	public static final String WHITE = "\u001B[37m";
	public static final String CYAN = "\u001B[36m";
	public static final String PURPLE = "\u001B[35m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";

	static Tablero tabla;
	static Jugador jugador1;
	static Jugador jugador2;

	static Scanner sc = new Scanner(System.in);
	static Random ram = new Random();
	static boolean comienzo = false;
	static String nombre;
	static String nombre2;
	static int resultado;
	static String transformare;
	static int numero;
	static boolean scape = false;
	static boolean ganar = false;
	static int tipoNumerico = 0;

	private static void timeOut() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static void verificación() {
		do {
			letra();
			numero();
			if (Tablero.revision(numero, resultado)) {
				System.out.println(RED + " \n Introducelo en otra ubicación \n" + WHITE);
			}
		} while (Tablero.revision(numero, resultado));
	}

	private static void nombres() {
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

	private static void crear() {
		if (1 == tipoNumerico) {
			jugador1 = new ia(ficha.x);
			jugador2 = new ia(ficha.o);
		} else if (2 == tipoNumerico) {
			jugador1 = new real(nombre, ficha.x);
			jugador2 = new ia(ficha.o);
		} else if (3 == tipoNumerico) {
			jugador1 = new real(nombre, ficha.x);
			jugador2 = new real(nombre2, ficha.o);
		}
	}

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

	private static void numero() {
		do {
//almeria
			try {

				do {
					System.out.println("Introduca la poscion del 1 al 15");
					numero = sc.nextInt();
				} while (!(numero < 0) && !(numero <= 15));

				if (numero > 0 && numero <= 15) {
					scape = true;
				}
			} catch (Exception InputMismatchException) {
				scape = false;
				sc.nextLine();
			}

		} while (scape == false);
	}

	public static void transformar(String posicion) {
		switch (posicion.toLowerCase()) {
		case "a":
			resultado = 1;
			break;
		case "b":
			resultado = 2;
			break;
		case "c":
			resultado = 3;
			break;
		case "d":
			resultado = 4;
			break;
		case "e":
			resultado = 5;
			break;
		case "f":
			resultado = 6;
			break;
		case "g":
			resultado = 7;
			break;
		case "h":
			resultado = 8;
			break;
		case "i":
			resultado = 9;
			break;
		case "j":
			resultado = 10;
			break;
		case "k":
			resultado = 11;
			break;
		case "l":
			resultado = 12;
			break;
		case "m":
			resultado = 13;
			break;
		case "n":
			resultado = 14;
			break;
		case "o":
			resultado = 15;
			break;
		}
	}

	public static void Comenzar() {
		System.out.println("Gomoku");
		boolean salida = false;
		boolean finalidad = false;
		do {

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

			} while (salida == false);

			nombre = sc.nextLine();

			// --------------------------------------------------
			nombres();
			crear();
			// ---------------------------------------------------
			if (tipoNumerico == 3) {
				do {
					System.out.printf("\n---------------------------------------------\n   " + BLUE + nombre + WHITE
							+ " le toca \n---------------------------------------------\n\n");
					tabla.mostrarTablero();
					verificación();
					Tablero.modificarTablero(numero, resultado, ficha.x);
					tabla.mostrarTablero();
					ganar = tabla.ganar();
					if (!ganar) {
						System.out.printf("\n---------------------------------------------\n   " + YELLOW + nombre2
								+ WHITE + " le toca \n---------------------------------------------\n \n");
						verificación();
						Tablero.modificarTablero(numero, resultado, ficha.o);
						tabla.mostrarTablero();
						ganar = tabla.ganar();
					}

				} while (ganar == false);
			} else if (tipoNumerico == 1) {

				do {
					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n" + BLUE
							+ ((ia) jugador1).nombre(ficha.x) + WHITE
							+ " le toca \n---------------------------------------------\n\n");

					do {
						numero = 0;
						resultado = 0;
						numero = (int) (Math.random() * 15 + 1);
						;
						resultado = (int) (Math.random() * 15 + 1);
						;
					} while (Tablero.revision(numero, resultado) == true);

					Tablero.modificarTablero(numero, resultado, ficha.x);
					tabla.mostrarTablero();
					ganar = tabla.ganar();
					timeOut();
					if (!ganar) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------------\n"
								+ YELLOW + ((ia) jugador2).nombre(ficha.o) + WHITE
								+ " le toca \n---------------------------------------------\n\n");

						do {
							numero = 0;
							resultado = 0;
							numero = (int) (Math.random() * 15 + 1);
							;
							resultado = (int) (Math.random() * 15 + 1);
							;
						} while (Tablero.revision(numero, resultado) == true);
						Tablero.modificarTablero(numero, resultado, ficha.o);

						tabla.mostrarTablero();
						ganar = tabla.ganar();
						timeOut();
					}
				} while (ganar == false);
			}
			System.out.println(RED + " \n BUENA PARTIDA <3 \n" + WHITE);
			System.out.println(RED + " \n ¿Desea jugar otra partida? \n" + WHITE);

		} while (comienzo != false);
	}

}
