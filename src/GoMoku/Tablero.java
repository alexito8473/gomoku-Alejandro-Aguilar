package GoMoku;

public class Tablero {
	public static final String BLUE = "\u001B[34m";
	public static final String WHITE = "\u001B[37m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	
	public static boolean victoriaderecha;
	public static boolean victoriaderecha2;
	private static boolean victoriaarriba;
	public static boolean victoriaarriba2;
	public static boolean victoriaInclinadaArriba1;
	public static boolean victoriaInclinadaAbajo1;
	public static boolean victoriaInclinadaArriba2;
	public static boolean victoriaInclinadaAbajo2;
	
	private static boolean  win = false;
	public static String españa[][] = {
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

	public static void mostrarTablero() {
		for (int i = 0; i < españa.length; i++) {

			String a;
			for (int j = 0; j < españa.length; j++) {
				a = españa[i][j];
				System.out.print(a + " ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
	}

	public static void inclinacionArriba1() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if (españa[i - 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (españa[i - 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (españa[i - 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (españa[i - 4][j + 4].equals(BLUE + "x" + WHITE)) {
									victoriaInclinadaArriba1 = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void inclinacionAbajo1() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if (españa[i + 1][j - 1].equals(BLUE + "x" + WHITE)) {
						if (españa[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if (españa[i + 3][j - 3].equals(BLUE + "x" + WHITE)) {
								if (españa[i + 4][j - 4].equals(BLUE + "x" + WHITE)) {
									victoriaInclinadaAbajo1 = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void inclinacionArriba2() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(YELLOW + "o" + WHITE)) {
					if (españa[i - 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (españa[i - 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (españa[i - 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (españa[i - 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									victoriaInclinadaArriba2 = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void inclinacionAbajo2() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(YELLOW + "o" + WHITE)) {
					if (españa[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if (españa[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if (españa[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if (españa[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									victoriaInclinadaAbajo2 = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void derecha1() {

		for (int i = 1; i < españa.length; i++) {

			for (int j = 1; j < españa.length; j++) {

				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if (españa[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if (españa[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if (españa[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if (españa[i][j + 4].equals(BLUE + "x" + WHITE)) {
									victoriaderecha = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}

	public static void derecha2() {

		for (int i = 1; i < españa.length; i++) {

			for (int j = 1; j < españa.length; j++) {

				if (españa[i][j].equals(YELLOW + "o" + WHITE)) {

					if (españa[i][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (españa[i][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (españa[i][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (españa[i][j + 4].equals(YELLOW + "o" + WHITE)) {
									victoriaderecha2 = true;
									win=false;
								}

							}
						}
					}
				}
			}
		}
	}

	public static void arriba1() {

		for (int i = 1; i < españa.length; i++) {

			for (int j = 1; j < españa.length; j++) {

				if (españa[i][j].equals(BLUE + "x" + WHITE)) {

					if (españa[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if (españa[i + 2][j].equals(BLUE + "x" + WHITE)) {
							if (españa[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if (españa[i + 4][j].equals(BLUE + "x" + WHITE)) {
									victoriaarriba = true;
									win=false;
								}

							}
						}
					}
				}
			}
		}
	}

	public static void arriba2() {

		for (int i = 1; i < españa.length; i++) {

			for (int j = 1; j < españa.length; j++) {

				if (españa[i][j].equals(YELLOW + "o" + WHITE)) {

					if (españa[i + 1][j].equals(YELLOW + "o" + WHITE)) {
						if (españa[i + 2][j].equals(YELLOW + "o" + WHITE)) {
							if (españa[i + 3][j].equals(YELLOW + "o" + WHITE)) {
								if (españa[i + 4][j].equals(YELLOW + "o" + WHITE)) {
									victoriaarriba2 = true;
									win=false;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean revision(int numero1, int numero2) {
		if((españa[numero1][numero2] == GREEN + "o" + WHITE)||(españa[numero1][numero2] == BLUE + "x" + WHITE)||(españa[numero1][numero2] == GREEN + "x" + WHITE)||(españa[numero1][numero2] == YELLOW + "o" + WHITE)) {
			return true;
		}else {
			return false;
		}
	}
	public static void modificarTablero(int numero1, int numero2, ficha ficha) {

		do {
		if (ficha.equals(GoMoku.ficha.x)) {
			if (victoriaderecha == true || victoriaarriba == true || victoriaInclinadaAbajo1==true|| victoriaInclinadaArriba1==true) {
				españa[numero1][numero2] = GREEN + "x" + WHITE;
				win=true;
			} else {
				españa[numero1][numero2] = BLUE + "x" + WHITE;
				win=true;
				derecha1();
				arriba1();
				inclinacionArriba1();
				inclinacionAbajo1();
			}
		} else if (ficha.equals(GoMoku.ficha.o)) {
			if (victoriaderecha2 == true || victoriaarriba2 == true || victoriaInclinadaAbajo2==true|| victoriaInclinadaArriba2==true) {
				españa[numero1][numero2] = GREEN + "o" + WHITE;
				win=true;
				
			} else {
				españa[numero1][numero2] = YELLOW + "o" + WHITE;
				win=true;
				derecha2();
				arriba2();
				inclinacionArriba2();
				inclinacionAbajo2();
			}

		}
		}while(win==false);
	}

	public static void main(String[] args) {
		modificarTablero(5, 3, ficha.o);
		modificarTablero(4, 4, ficha.o);
		modificarTablero(3, 5, ficha.o);
		modificarTablero(6, 2, ficha.o);
		modificarTablero(2, 6, ficha.o);
		mostrarTablero();
	}
}
