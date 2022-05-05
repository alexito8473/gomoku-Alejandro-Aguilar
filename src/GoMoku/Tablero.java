package GoMoku;

public class Tablero {
	private static final String BLUE = "\u001B[34m";
	private static final String WHITE = "\u001B[37m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";

	private static boolean victoria;

	private static String españa[][] = {
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

	private static String españa2[][] = {
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
	public static String[][] gettablero() {
		return españa;
	}

	public static void mostrarTablero() {
		String a;
		for (int i = 0; i < españa.length; i++) {
			
			for (int j = 0; j < españa.length; j++) {
				a = españa[i][j];
				System.out.print(a + " ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
	}

	private static void inclinacion1(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			 letra = BLUE + "x" + WHITE;
		} else  {
			 letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if (((i + 1 < 16) && (j + 1 < 16)) && españa[i + 1][j + 1].equals(letra)) {
						if (((i + 2 < 16) && (j + 2 < 16)) && españa[i + 2][j + 2].equals(letra)) {
							if (((i + 3 < 16) && (j + 3 < 16)) && españa[i + 3][j + 3].equals(letra)) {
								if (((i + 4 < 16) && (j + 4 < 16)) && españa[i + 4][j + 4].equals(letra)) {
									victoria=true;
								}
							}
						}
					}
				}
			}
		}
	}

	private static void inclinacion2(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			 letra = BLUE + "x" + WHITE;
		} else  {
			 letra = YELLOW + "o" + WHITE;
		}
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if ((i + 1 < 16 && j - 1 < 16) && españa[i + 1][j - 1].equals(letra)) {
						if ((i + 2 < 16 && j - 2 < 16) && españa[i + 2][j - 2].equals(letra)) {
							if ((i + 3 < 16 && j - 3 < 16) && españa[i + 3][j - 3].equals(letra)) {
								if ((i + 4 < 16 && j - 4 < 16) && españa[i + 4][j - 4].equals(letra)) {
									victoria=true;
								
								}
							}
						}
					}
				}
			}
		}
	}

	private static void derecha(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			 letra = BLUE + "x" + WHITE;
		} else  {
			 letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < españa.length; i++) {
			for (int j = 0; j < españa.length; j++) {
				if (españa[i][j].equals(letra)) {
					if ((j + 1 < 16) && españa[i][j + 1].equals(letra)) {
						if ((j + 2 < 16) && españa[i][j + 2].equals(letra)) {
							if ((j + 3 < 16) && españa[i][j + 3].equals(letra)) {
								if ((j + 4 < 16) && españa[i][j + 4].equals(letra)) {
									victoria=true;
						
								}
							}
						}
					}
				}
			}
		}
	}

	private static void arriba(ficha ficha) {
		String letra;
		if (ficha.equals(GoMoku.ficha.x)) {
			 letra = BLUE + "x" + WHITE;
		} else  {
			 letra = YELLOW + "o" + WHITE;
		}
		for (int i = 0; i < españa.length; i++) {

			for (int j = 0; j < españa.length; j++) {

				if (españa[i][j].equals(letra)) {
					if ((i + 1 < 16) && españa[i + 1][j].equals(letra)) {
						if ((i + 2 < 16) && españa[i + 2][j].equals(letra)) {
							if ((i + 3 < 16) && españa[i + 3][j].equals(letra)) {
								if ((i + 4 < 16) && españa[i + 4][j].equals(letra)) {
									victoria=true;				
								}
							}
						}
					}
				}
			}
		}
	}

	public static boolean revision(int numero1, int numero2) {
		if ((españa[numero1][numero2] == GREEN + "o" + WHITE) || (españa[numero1][numero2] == BLUE + "x" + WHITE)
				|| (españa[numero1][numero2] == GREEN + "x" + WHITE)
				|| (españa[numero1][numero2] == YELLOW + "o" + WHITE)) {
			return true;
		} else {
			return false;
		}
	}

	public static void modificarTablero(int numero1, int numero2, ficha ficha) {
		if (ficha.equals(GoMoku.ficha.x)) {
			españa[numero1][numero2] = GREEN + "x" + WHITE;
		} else if (ficha.equals(GoMoku.ficha.o)) {
			españa[numero1][numero2] = GREEN + "o" + WHITE;
		}
	}

	public static void modificarficha(int numero1, int numero2, ficha ficha) {
		if (ficha.equals(GoMoku.ficha.x)) {
			españa[numero1][numero2] = BLUE + "x" + WHITE;
		} else if (ficha.equals(GoMoku.ficha.o)) {
			españa[numero1][numero2] = YELLOW + "o" + WHITE;
		}
	}

	public static boolean ganar(ficha ficha) {
		derecha(ficha);
		arriba(ficha);
		inclinacion1(ficha);
		inclinacion2(ficha);
		if (victoria) {
			return true;
		} else {
			return false;
		}
	}

	public static void volver() {
		españa=españa2;
		
	}

}
