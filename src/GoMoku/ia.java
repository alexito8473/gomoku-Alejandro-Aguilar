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
	private static boolean jugadaHorizontal = false;
	private static boolean jugadaHorizontal2 = false;
	private static boolean jugadaHorizontal3 = false;
	private static boolean jugadaHorizontal4 = false;
	private static boolean jugadaHorizontal5 = false;

	private static boolean ganarVertical = false;
	private static boolean jugadaVertical = false;
	private static boolean jugadaVertical2 = false;
	private static boolean jugadaVertical3 = false;
	private static boolean jugadaVertical4 = false;
	private static boolean jugadaVertical5 = false;

	private static boolean ganarInclinado = false;
	private static boolean jugadaInclinado = false;
	private static boolean jugadaInclinado2 = false;
	private static boolean jugadaInclinado3 = false;
	private static boolean jugadaInclinado4 = false;
	private static boolean jugadaInclinado5 = false;
	private static boolean jugadaInclinado6 = false;
	private static boolean jugadaInclinado7 = false;
	private static boolean jugadaInclinado8 = false;
	private static boolean jugadaInclinado9 = false;
	private static boolean jugadaInclinado10 = false;

	private static boolean defensa = false;

	private static boolean defensaHorizontal = false;
	private static boolean jugadaHorizontaldef = false;
	private static boolean jugadaHorizontaldef2 = false;
	private static boolean jugadaHorizontaldef3 = false;

	private static boolean defensaVertical = false;
	private static boolean jugadaVerticaldef = false;
	private static boolean jugadaVerticaldef2 = false;
	private static boolean jugadaVerticaldef3 = false;

	private static boolean defensaInclinada = false;
	private static boolean jugadaInclinadadef = false;
	private static boolean jugadaInclinadadef2 = false;
	private static boolean jugadaInclinadadef3 = false;

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

	private static void returns() {
		ganar = false;

		ganarHorizontal = false;
		jugadaHorizontal = false;
		jugadaHorizontal2 = false;
		jugadaHorizontal3 = false;
		jugadaHorizontal4 = false;
		jugadaHorizontal5 = false;

		ganarVertical = false;
		jugadaVertical = false;
		jugadaVertical2 = false;
		jugadaVertical3 = false;
		jugadaVertical4 = false;
		jugadaVertical5 = false;

		ganarInclinado = false;
		jugadaInclinado = false;
		jugadaInclinado2 = false;
		jugadaInclinado3 = false;
		jugadaInclinado4 = false;
		jugadaInclinado5 = false;

		defensa = false;

		defensaHorizontal = false;
		jugadaHorizontaldef = false;
		jugadaHorizontaldef2 = false;
		jugadaHorizontaldef3 = false;

		defensaVertical = false;
		jugadaVerticaldef = false;
		jugadaVerticaldef2 = false;
		jugadaVerticaldef3 = false;

		defensaInclinada = false;
		jugadaInclinadadef = false;
		jugadaInclinadadef2 = false;
		jugadaInclinadadef3 = false;
	}

	private static void defensaHorizontal(String[][] array) {
		boolean continuar = true;
		boolean continuar1 = true;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
								jugadaHorizontaldef = true;
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
						if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
								if ((j + 3 < 16) && array[i][j + 3].equals(YELLOW + "o" + WHITE)) {
									jugadaHorizontaldef2 = true;
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
					if ((j < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
						if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
							if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
								if ((j + 3 < 16) && array[i][j + 3].equals(YELLOW + "o" + WHITE)) {
									if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
										jugadaHorizontaldef3 = true;
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

	private static void defensavertical(String[][] array) {
		boolean continuar = true;
		boolean continuar1 = true;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
							if ((i + 4 < 16) && array[i + 4][j].equals(".")) {
								jugadaVerticaldef = true;
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
						if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(YELLOW + "o" + WHITE)) {
								if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
									jugadaVerticaldef2 = true;
									defensa = true;
									defensaVertical = true;
									y = i ;
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
					if ((i < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
							if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
								if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
									if ((i + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
										jugadaVerticaldef3 = true;
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
	private static void defensaInclinado(String[][] array) {
		boolean continuar = true;
		boolean continuar1 = true;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
					if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
						if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
							if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
								if (((i + 5 < 16) && (j + 5 < 16)) && array[i + 5][j + 5].equals(".")) {
									defensa= true;
									defensaInclinada = true;
									jugadaInclinadadef = true;
									y = i + 5;
									x = j + 5;
									continuar = false;
									continuar1 = false;
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
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									if (((i + 5 < 16) && (j + 5 < 16))
											&& array[i + 5][j + 5].equals(YELLOW + "o" + WHITE)) {
										defensa= true;
										defensaInclinada = true;
										jugadaInclinadadef2 = true;
										y = i + 1;
										x = j + 1;
										continuar1 = false;
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
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									if (((i + 5 < 16) && (j + 5 < 16))
											&& array[i + 5][j + 5].equals(YELLOW + "o" + WHITE)) {
										defensa= true;
										defensaInclinada = true;
										jugadaInclinadadef3 = true;
										y = i + 3;
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
	private static void ganarHorizontal(String[][] array) {
		boolean continuar = true,continuar1 = true, continuar2=true,continuar3=true;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(".")) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal = true;
									y = i;
									x = j + 4;
									continuar=false;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		if(continuar) {
				
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(".")) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal2 = true;
									y = i;
									x = j;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
	}
		if(continuar1) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
						if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal3 = true;
									y = i;
									x = j + 1;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
	}
		if(continuar2) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal4 = true;
									y = i;
									x = j + 2;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
	}
		if(continuar3) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
					if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
						if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
							if ((j + 4 < 16) && array[i][j + 4].equals(".")) {
								if ((j + 5 < 16) && array[i][j + 5].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									jugadaHorizontal5 = true;
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
	private static void ganarVertical(String[][] array) {
		boolean continuar = true,continuar1 = true, continuar2=true,continuar3=true;
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
							if ((i + 4 < 16) && array[i + 4][j].equals(BLUE + "x" + WHITE)) {
								if ((i + 5 < 16) && array[i + 5][j].equals(".")) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical = true;
									y = i + 5;
									x = j;
									continuar=false;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		if(continuar) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical2 = true;
									y = i;
									x = j;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar1) {
			
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(".")) {
						if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical3 = true;
									y = i + 2;
									x = j;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar2) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical4 = true;
									y = i + 2;
									x = j;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar3) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
							if ((j + 4 < 16) && array[i + 4][j].equals(".")) {
								if ((i + 5 < 16) && array[i + 5][j].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical5 = true;
									y = i + 4;
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
	private static void ganarInclinado(String[][] array) {
		boolean continuar = true,continuar1 = true, continuar2=true,continuar3=true;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i ][j ].equals(BLUE + "x" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado = true;
									y = i + 4;
									x = j + 4;
									continuar=false;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		if(continuar) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i  < 16) && (j  < 16)) && array[i][j ].equals(BLUE + "x" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado2 = true;
									y = i + 3;
									x = j + 3;
									continuar1=false;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar1) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j  < 16)) && array[i ][j ].equals(BLUE + "x" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 3 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado3 = true;
									y = i + 2;
									x = j + 2;
									continuar2=false;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar2) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i< 16) && (j  < 16)) && array[i ][j].equals(BLUE + "x" + WHITE)) {
					if (((i + 1 < 16) && (j + 2 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado4 = true;
									y = i + 1;
									x = j + 1;
									continuar3=false;
								}
							}
						}
					}
				}
			}
		}
		}
		if(continuar3) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j  < 16)) && array[i ][j ].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado5 = true;
									y = i ;
									x = j ;
								}
							}
						}
					}
				}
			}
		}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(".")) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(BLUE + "x" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(BLUE + "x" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado6 = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(".")) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(BLUE + "x" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado7 = true;
									y = i+1;
									x = j+1;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(".")) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado8 = true;
									y = i+2;
									x = j+2;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(BLUE + "x" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(".")) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(BLUE + "x" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado9 = true;
									y = i+3;
									x = j+3;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(BLUE + "x" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(BLUE + "x" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(".")) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado10 = true;
									y = i+4;
									x = j+4;
								}
							}
						}
					}
				}
			}
		}
		
	}

	public static void jugada1(String[][] array) {
		returns();
		ganarHorizontal(array);
		ganarInclinado(array);
		ganarVertical(array);
		defensaInclinado(array);
		defensaHorizontal(array);
		defensavertical(array);
		if (ganar) {
			if (ganarHorizontal) {
				if (jugadaHorizontal) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal5) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (ganarVertical) {

				if (jugadaVertical) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical5) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (ganarInclinado) {
				if (jugadaInclinado) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado5) {
					numeros[0] = x;
					numeros[1] = y;
				}
			}
		} else if (defensa) {
			if (defensaHorizontal) {
				if (jugadaHorizontaldef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontaldef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontaldef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (defensaVertical) {
				if (jugadaVerticaldef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVerticaldef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVerticaldef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (defensaInclinada) {
				if (jugadaInclinadadef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinadadef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinadadef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
			}
		} else {
			numeros[0] = ran.nextInt(15) + 1;
			numeros[1] = ran.nextInt(15) + 1;
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void defensaHorizontal2(String[][] array) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
								jugadaHorizontaldef = true;
								defensaHorizontal = true;
								defensa = true;
								y = i;
								x = j + 3;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(".")) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								jugadaHorizontaldef2 = true;
								defensaHorizontal = true;
								defensa = true;
								y = i;
								x = j;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
							if ((j + 3 < 16) && array[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j + 4 < 16) && array[i][j + 4].equals(BLUE + "x" + WHITE)) {
									jugadaHorizontaldef3 = true;
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
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static void defensavertical2(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
							if ((i + 4 < 16) && array[i + 4][j].equals(".")) {
								jugadaVerticaldef = true;
								defensa = true;
								defensaVertical = true;
								y = i + 4;
								x = j;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(BLUE + "x" + WHITE)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
								jugadaVerticaldef2 = true;
								defensa = true;
								defensaVertical = true;
								y = i;
								x = j;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(BLUE + "x" + WHITE)) {
									jugadaVerticaldef3 = true;
									defensa = true;
									defensaVertical = true;
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

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void defensaInclinado2(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(BLUE + "x" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(".")) {
									defensa = true;
									defensaInclinada = true;
									jugadaInclinadadef = true;
									y = i + 4;
									x = j + 4;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j  < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									defensa = true;
									defensaInclinada = true;
									jugadaInclinadadef2 = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
					if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
						if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
							if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
								if (((i + 5 < 16) && (j + 5 < 16)) && array[i + 5][j + 5].equals(BLUE + "x" + WHITE)) {
									defensa = true;
									defensaInclinada = true;
									jugadaInclinadadef3 = true;
									y = i + 3;
									x = j + 3;
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
	private static void ganarHorizontal2(String[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
					if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
						if ((j + 3 < 16) && array[i][j + 3].equals(YELLOW + "o" + WHITE)) {
							if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
								if ((j + 5 < 16) && array[i][j + 5].equals(".")) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal = true;
									y = i;
									x = j + 5;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j + 1 < 16) && array[i][j + 1].equals(".")) {
					if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
						if ((j + 3 < 16) && array[i][j + 3].equals(YELLOW + "o" + WHITE)) {
							if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
								if ((j + 5 < 16) && array[i][j + 5].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal2 = true;
									y = i;
									x = j + 1;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
					if ((j + 2 < 16) && array[i][j + 2].equals(".")) {
						if ((j + 3 < 16) && array[i][j + 3].equals(YELLOW + "o" + WHITE)) {
							if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
								if ((j + 5 < 16) && array[i][j + 5].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal3 = true;
									y = i;
									x = j + 2;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
					if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
						if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
							if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
								if ((j + 5 < 16) && array[i][j + 5].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal4 = true;
									y = i;
									x = j + 3;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((j < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((j + 1 < 16) && array[i][j + 1].equals(YELLOW + "o" + WHITE)) {
						if ((j + 2 < 16) && array[i][j + 2].equals(YELLOW + "o" + WHITE)) {
							if ((j + 3 < 16) && array[i][j + 3].equals(".")) {
								if ((j + 4 < 16) && array[i][j + 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarHorizontal = true;
									jugadaHorizontal5 = true;
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

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void ganarVertical2(String[][] array) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
							if ((j + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
								if ((i + 5 < 16) && array[i + 5][j].equals(".")) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical = true;
									y = i + 5;
									x = j;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(".")) {
					if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(YELLOW + "o" + WHITE)) {
							if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical2 = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
					if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
						if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
							if ((i + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
								if ((i + 5 < 16) && array[i + 5][j].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical3 = true;
									y = i + 2;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(".")) {
							if ((i + 3 < 16) && array[i + 3][j].equals(YELLOW + "o" + WHITE)) {
								if ((i + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical4 = true;
									y = i + 2;
									x = j;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i < 16) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i + 1 < 16) && array[i + 1][j].equals(YELLOW + "o" + WHITE)) {
						if ((i + 2 < 16) && array[i + 2][j].equals(YELLOW + "o" + WHITE)) {
							if ((j + 3 < 16) && array[i + 3][j].equals(".")) {
								if ((i + 4 < 16) && array[i + 4][j].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarVertical = true;
									jugadaVertical5 = true;
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

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void ganarInclinado2(String[][] array) {
		

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
					if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
						if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
							if (((i + 4 < 16) && (j + 4 < 16)) && array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
								if (((i + 5 < 16) && (j + 5 < 16)) && array[i + 5][j + 5].equals(".")) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado = true;
									y = i + 5;
									x = j + 5;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(".")) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado2 = true;
									y = i + 3;
									x = j + 3;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(".")) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado3 = true;
									y = i + 2;
									x = j + 2;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(YELLOW + "o" + WHITE)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(".")) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado4 = true;
									y = i + 1;
									x = j + 1;

								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (((i < 16) && (j < 16)) && array[i][j].equals(".")) {
					if (((i + 1 < 16) && (j + 1 < 16)) && array[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && array[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && array[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (((i + 4 < 16) && (j + 4 < 16))
										&& array[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado5 = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(".")) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado6 = true;
									y = i;
									x = j;
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(".")) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado7 = true;
									y = i+1;
									x = j+1;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(".")) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado8 = true;
									y = i+2;
									x = j+2;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(".")) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado9 = true;
									y = i+3;
									x = j+3;
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i<16&&j<0)&&array[i][j].equals(YELLOW + "o" + WHITE)) {
					if ((i+1<16&&j-1<0)&&array[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2<0)&&array[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16&&j-3<0)&&array[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4<0)&&array[i + 4][j - 4].equals(".")) {
									ganar = true;
									ganarInclinado = true;
									jugadaInclinado10 = true;
									y = i+4;
									x = j+4;
								}
							}
						}
					}
				}
			}
		}
		
	}

	public static void jugada2(String[][] array) {
		returns();
		ganarHorizontal2(array);
		ganarVertical2(array);
		ganarInclinado2(array);
		defensaHorizontal2(array);
		defensavertical2(array);
		defensaInclinado2(array);

		if (ganar) {


			if (ganarHorizontal) {
				
				if (jugadaHorizontal) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontal5) {
					numeros[0] = x;
					numeros[1] = y;
				}
				
			} else if (ganarVertical) {
				if (jugadaVertical) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVertical5) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (ganarInclinado) {
				if (jugadaInclinado) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado3) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado4) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinado5) {
					numeros[0] = x;
					numeros[1] = y;
				}
			}
		} else if (defensa) {
			if (defensaHorizontal) {
				if (jugadaHorizontaldef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontaldef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaHorizontaldef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (defensaVertical) {
				if (jugadaVerticaldef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVerticaldef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaVerticaldef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
			} else if (defensaInclinada) {
				if (jugadaInclinadadef) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinadadef2) {
					numeros[0] = x;
					numeros[1] = y;
				} else if (jugadaInclinadadef3) {
					numeros[0] = x;
					numeros[1] = y;
				}
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
