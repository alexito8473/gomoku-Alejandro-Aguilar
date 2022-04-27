package GoMoku;

import java.util.Scanner;

public class Partida {

	static Tablero tabla;
	static Jugador jugador1;
	static Jugador jugador2;
	static Scanner sc = new Scanner(System.in);
	static String nombre;
	static String nombre2;
	static int resultado;

	private static void separar() {

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
		boolean comienzo = false;
		boolean salida = false;
		boolean finalidad = false;
		do {
			int tipoNumerico = 0;

			do {

				try {
					System.out.printf(
							"Tipo de juego(Seleccione un numero):\n 1 ia vs ia \n 2 ia vs jugador \n 3 jugador vs jugador \n");
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
			if (2 == tipoNumerico) {
				System.out.printf("Introduce un nombre \n");
				nombre = sc.nextLine();
			} else if (3 == tipoNumerico) {
				System.out.printf("Nombre del jugador uno \n");
				nombre = sc.nextLine();
				System.out.printf("Nombre del jugador dos \n");
				nombre2 = sc.nextLine();
			}
			// ---------------------------------------------------
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
			// ---------------------------------------------------
			do {
				int x, y;
				String arreglo;
				System.out.println(nombre + " Le toca");
				tabla.mostrarTablero();
				System.out.println("Introduca la poscion del a hasta la o");
				arreglo = sc.next();
				y = transformar(arreglo);
				System.out.println("Introduca la poscion del 1 al 15");
				x = sc.nextInt();
				Tablero.modificarTablero(x, y, ficha.x);
				tabla.mostrarTablero();
				System.out.println(nombre2 + " Le toca");
				System.out.println("Introduca la poscion del a hasta la o");
				arreglo = sc.next();
				y = transformar(arreglo);
				System.out.println("Introduca la poscion del 1 al 15");
				x = sc.nextInt();
				Tablero.modificarTablero(x, y, ficha.o);
				comienzo = tabla.win();
			} while (comienzo == false);
		} while (comienzo != false);
	}

}
