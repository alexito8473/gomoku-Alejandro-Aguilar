package GoMoku;

import java.util.Random;
import java.util.Scanner;

public class ia extends Jugador {

	public static final String WHITE = "\u001B[37m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";

	public static String resultado;

	public static boolean ganar = false;
	private static boolean ganarHorizontal = false;
	private static boolean ganarVertical = false;
	private static boolean ganarInclinado = false;
	private static boolean defensa = false;
	private static boolean defensaHorizontal = false;
	private static boolean defensaVertical = false;
	private static boolean defensaInclinada = false;
	private static boolean defensaInclinada1 = false;

	static int x;
	static int y;

	static Random ran = new Random();

	static int number = ran.nextInt(9);
	static int number2 = ran.nextInt(9);

	static int[] numeros = new int[2];

	public ia(ficha ficha) {
		super(ficha);
	}

	Scanner src = new Scanner(System.in);
	private static String nombres[] = { "Pepe", "Jorge", "España", "Lisbania", "Me gustaria", "Francia caca",
			"Copenage", "Mordekaiser", "ElNen" };

	public static String nombre(ficha ficha) {
		if (ficha == ficha.x) {
			return resultado = nombres[number];
		} else {
			return resultado = nombres[number2];
		}
	}

	private static void retornar() {
		ganar = false;
		ganarHorizontal = false;
		defensa = false;
		defensaHorizontal = false;
		defensaVertical = false;
		defensaInclinada = false;
		defensaInclinada = false;
	}

	private static void defensaHorizontal(String[][] array, GoMoku.ficha fichas) {
		boolean continuar = true, continuar1 = true, continuar2 = true, continuar3 = true;

		String eleccion;

		if (fichas == fichas.x) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
								defensaHorizontal = true;
								defensa = true;
								y = i;
								x = j + 3;
								continuar = false;
								continuar1 = false;
							}
						}
					}
				}
			}
		}
		if (continuar) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(".")) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									defensaHorizontal = true;
									defensa = true;
									y = i;
									x = j;
									continuar1 = false;
								}
							}
						}
					}
				}
			}
		}
		if (continuar1) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(eleccion)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
										defensaHorizontal = true;
										defensa = true;
										y = i;
										x = j + 2;
									}
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

	private static void defensavertical(String[][] array, ficha fichas) {
		boolean continuar = true, continuar1 = true;

		String eleccion;

		if (fichas == fichas.x) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
							if ((i + 4 < 16) && array[i + 4][j].equals(".")) {

								defensa = true;
								defensaVertical = true;
								y = i + 4;
								x = j;
								continuar = false;
								continuar1 = false;
							}
						}
					}
				}
			}
		}
		if (continuar) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(".")) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {

									defensa = true;
									defensaVertical = true;
									y = i;
									x = j;
									continuar1 = false;
								}
							}
						}
					}
				}
			}
		}
		if (continuar1) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(eleccion)) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
									if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {

										defensa = true;
										defensaVertical = true;
										y = i + 2;
										x = j;
									}
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
	private static void defensaInclinado(String[][] array, ficha fichas) {
		boolean continuar = true;
		boolean continuar3 = true;
		String eleccion;

		if (fichas == fichas.x) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								defensa = true;
								defensaInclinada = true;
								y = i + 3;
								x = j + 3;
								continuar = false;
								continuar3 = false;

							}
						}
					}
				}
			}
		}
		if (continuar) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									defensa = true;
									defensaInclinada = true;
									y = i;
									x = j;
									continuar3 = false;

								}
							}
						}
					}
				}
			}
		}

		if (continuar3) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
										defensa = true;
										defensaInclinada = true;
										y = i + 2;
										x = j + 2;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private static void defensaInclinado1(String[][] array, ficha fichas) {
		boolean continuar = true;
		boolean continuar1 = true;
		String eleccion;

		if (fichas == fichas.x) {
			eleccion = YELLOW + "o" + WHITE;

		} else {
			eleccion = BLUE + "x" + WHITE;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
						if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
							if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(".")) {
								defensa = true;
								defensaInclinada1 = true;
								y = i + 3;
								x = j - 3;
								continuar = false;
								continuar1 = false;
							}
						}
					}
				}
			}
		}

		if (continuar) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16 && j > 0) && array[i][j].equals(".")) {
						if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
							if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
								if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
									defensa = true;
									defensaInclinada1 = true;
									y = i;
									x = j;
									continuar1 = false;
								}
							}
						}
					}
				}
			}

			if (continuar1) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
							if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
								if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
									if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
										if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
											defensa = true;
											defensaInclinada1 = true;
											y = i + 2;
											x = j - 2;
										}
									}
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
	private static void ganarHorizontal(String[][] array, ficha fichas) {
		boolean continuar = true, continuar1 = true, continuar2 = true, continuar3 = true;
		String eleccion;
		if (fichas == fichas.x) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(eleccion)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(".")) {
									ganar = true;
									ganarHorizontal = true;
									y = i;
									x = j + 4;
									continuar = false;
									continuar1 = false;
									continuar2 = false;
									continuar3 = false;
								}
							}
						}
					}
				}
			}
		}
		if (continuar) {

			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(".")) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
										ganar = true;
										ganarHorizontal = true;

										y = i;
										x = j;
										continuar1 = false;
										continuar2 = false;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar1) {
			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(eleccion)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
										ganar = true;
										ganarHorizontal = true;

										y = i;
										x = j + 1;
										continuar2 = false;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar2) {
			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(eleccion)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
								if ((j + 3 < 16) && array[i][j + 3].equals(eleccion)) {
									if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
										ganar = true;
										ganarHorizontal = true;

										y = i;
										x = j + 2;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar3) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((j < 16) && array[i][j].equals(eleccion)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(eleccion)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(eleccion)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
									if ((j + 4 < 16) && array[i][j + 4].equals(eleccion)) {
										ganar = true;
										ganarHorizontal = true;

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
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void ganarVertical(String[][] array, ficha fichas) {
		boolean continuar = true, continuar1 = true, continuar2 = true, continuar3 = true;
		String eleccion;

		if (fichas == fichas.x) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(eleccion)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(".")) {
									ganar = true;
									ganarVertical = true;

									y = i + 4;
									x = j;
									continuar = false;
									continuar1 = false;
									continuar2 = false;
									continuar3 = false;
								}
							}
						}
					}
				}
			}
		}
		if (continuar) {
			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(".")) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
									if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
										ganar = true;
										ganarVertical = true;

										y = i;
										x = j;
										continuar1 = false;
										continuar2 = false;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar1) {

			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(eleccion)) {
						if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
							if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
									if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
										ganar = true;
										ganarVertical = true;

										y = i + 2;
										x = j;
										continuar2 = false;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar2) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(eleccion)) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
								if ((i + 3 < 16) && array[i + 3][j].equals(eleccion)) {
									if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
										ganar = true;
										ganarVertical = true;

										y = i + 2;
										x = j;
										continuar3 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar3) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16) && array[i][j].equals(eleccion)) {
						if ((i + 1 < 16) && array[i + 1][j].equals(eleccion)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(eleccion)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(".")) {
									if ((i + 4 < 16) && array[i + 4][j].equals(eleccion)) {
										ganar = true;
										ganarVertical = true;

										y = i + 3;
										x = j;
									}
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
	private static void ganarInclinado(String[][] array, ficha fichas) {
		boolean continuar = true, continuar1 = true, continuar2 = true, continuar3 = true, continuar4 = true,
				continuar5 = true, continuar6 = true, continuar7 = true, continuar8 = true;
		String eleccion;
		if (fichas == fichas.x) {
			eleccion = BLUE + "x" + WHITE;
		} else {
			eleccion = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")) {
									ganar = true;
									ganarInclinado = true;

									y = i + 4;
									x = j + 4;
									continuar = false;
									continuar1 = false;
									continuar2 = false;
									continuar3 = false;
									continuar4 = false;
									continuar5 = false;
									continuar6 = false;
									continuar7 = false;
									continuar8 = false;
								}
							}
						}
					}
				}
			}
		}
		if (continuar) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
									if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i + 3;
										x = j + 3;
										continuar1 = false;
										continuar2 = false;
										continuar3 = false;
										continuar4 = false;
										continuar5 = false;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar1) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i + 2;
										x = j + 2;
										continuar2 = false;
										continuar3 = false;
										continuar4 = false;
										continuar5 = false;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar2) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(eleccion)) {
						if (((i + 1 < 16) && (j + 2 < 16)) && array[i + 1][j + 1].equals(".")) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i + 1;
										x = j + 1;
										continuar3 = false;
										continuar4 = false;
										continuar5 = false;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar3) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
						if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(eleccion)) {
							if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(eleccion)) {
								if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(eleccion)) {
									if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i;
										x = j;
										continuar4 = false;
										continuar5 = false;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar4) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16 && j > 0) && array[i][j].equals(".")) {
						if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
							if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
								if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
									if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i;
										x = j;
										continuar5 = false;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (continuar5) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
						if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(".")) {
							if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
								if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
									if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
										ganar = true;
										ganarInclinado = true;

										y = i + 1;
										x = j - 1;
										continuar6 = false;
										continuar7 = false;
										continuar8 = false;
									}
								}
							}
						}
					}
				}
			}
			if (continuar6) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
							if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
								if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(".")) {
									if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
										if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
											ganar = true;
											ganarInclinado = true;
											y = i + 2;
											x = j - 2;
											continuar7 = false;
											continuar8 = false;
										}
									}
								}
							}
						}
					}
				}
			}
			if (continuar7) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
							if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
								if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
									if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(".")) {
										if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(eleccion)) {
											ganar = true;
											ganarInclinado = true;
											y = i + 3;
											x = j - 3;
											continuar8 = false;
										}
									}
								}
							}
						}
					}
				}
			}
			if (continuar8) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if ((i < 16 && j > 0) && array[i][j].equals(eleccion)) {
							if ((i + 1 < 16 && j - 1 > 0) && array[i + 1][j - 1].equals(eleccion)) {
								if ((i + 2 < 16 && j - 2 > 0) && array[i + 2][j - 2].equals(eleccion)) {
									if ((i + 3 < 16 && j - 3 > 0) && array[i + 3][j - 3].equals(eleccion)) {
										if ((i + 4 < 16 && j - 4 > 0) && array[i + 4][j - 4].equals(".")) {
											ganar = true;
											ganarInclinado = true;
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
		}
	}

	public static void jugada1(String[][] array, ficha fichas) {
		retornar();
		ganarHorizontal(array, fichas);
		ganarInclinado(array, fichas);
		ganarVertical(array, fichas);
		defensaInclinado(array, fichas);
		defensaInclinado1(array, fichas);
		defensaHorizontal(array, fichas);
		defensavertical(array, fichas);
		if (ganar) {
			if (ganarHorizontal) {
				numeros[0] = x;
				numeros[1] = y;
			} else if (ganarVertical) {
				numeros[0] = x;
				numeros[1] = y;
			} else if (ganarInclinado) {
				numeros[0] = x;
				numeros[1] = y;
			}
		} else if (defensa) {
			if (defensaHorizontal) {
				numeros[0] = x;
				numeros[1] = y;
			} else if (defensaVertical) {
				numeros[0] = x;
				numeros[1] = y;
			} else if (defensaInclinada) {
				numeros[0] = x;
				numeros[1] = y;

			} else if (defensaInclinada1) {
				numeros[0] = x;
				numeros[1] = y;

			}
		} else {
			numeros[0] = ran.nextInt(15) + 1;
			numeros[1] = ran.nextInt(15) + 1;
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static int getPosoción1() {
		return numeros[0];
	}

	public static int getPosoción2() {
		return numeros[1];
	}

}
