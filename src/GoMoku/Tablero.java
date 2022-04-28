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
	
	private static boolean  winsalida = false;
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

	public static void inclinacionAbajo1() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if (((i+3<16)&&(j+3<16))&&españa[i + 1][j + 1].equals(BLUE + "x" + WHITE)) {
						if (((i+3<16)&&(j+3<16))&&españa[i + 2][j + 2].equals(BLUE + "x" + WHITE)) {
							if (((i+3<16)&&(j+3<16))&&españa[i + 3][j + 3].equals(BLUE + "x" + WHITE)) {
								if (((i+4<16)&&(j+4<16))&&españa[i + 4][j + 4].equals(BLUE + "x" + WHITE)) {
									victoriaInclinadaArriba1 = true;
									winsalida=false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void inclinacionArriba1() {
		for (int i = 1; i < españa.length; i++) {
			for (int j = 1; j < españa.length; j++) {
				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i+1<16&&j-1<16)&&españa[i + 1][j - 1].equals(BLUE + "x" + WHITE)) {
						if ((i+2<16&&j-2<16)&&españa[i + 2][j - 2].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16&&j-3<16)&&españa[i + 3][j - 3].equals(BLUE + "x" + WHITE)) {
								if ((i+4<16&&j-4<16)&&españa[i + 4][j - 4].equals(BLUE + "x" + WHITE)) {
									victoriaInclinadaAbajo1 = true;
									winsalida=false;
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
					if (((i+1<16)&&(j+1<16))&&españa[i + 1][j + 1].equals(YELLOW + "o" + WHITE)) {
						if (((i+2<16)&&(j+2<16))&&españa[i + 2][j + 2].equals(YELLOW + "o" + WHITE)) {
							if (((i+3<16)&&(j+3<16))&&españa[i + 3][j + 3].equals(YELLOW + "o" + WHITE)) {
								if (((i+4<16)&&(j+4<16))&&españa[i + 4][j + 4].equals(YELLOW + "o" + WHITE)) {
									victoriaInclinadaArriba2 = true;
									winsalida=false;
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
					if ((i+1<16&&j-1>0)&&españa[i + 1][j - 1].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16&&j-2>0)&&españa[i + 2][j - 2].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16&&j-3>0)&&españa[i + 3][j - 3].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16&&j-4>0)&&españa[i + 4][j - 4].equals(YELLOW + "o" + WHITE)) {
									victoriaInclinadaAbajo2 = true;
									winsalida=false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void derecha1() {

		for (int i = 0; i < españa.length; i++) {

			for (int j = 0; j < españa.length; j++) {

				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if ((j+1<16)&&españa[i][j + 1].equals(BLUE + "x" + WHITE)) {
						if ((j+2<16)&&españa[i][j + 2].equals(BLUE + "x" + WHITE)) {
							if ((j+3<16)&&españa[i][j + 3].equals(BLUE + "x" + WHITE)) {
								if ((j+4<16)&&españa[i][j + 4].equals(BLUE + "x" + WHITE)) {
									victoriaderecha = true;
									winsalida=false;
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

					if ((j+1<16)&&españa[i][j + 1].equals(YELLOW + "o" + WHITE)) {
						if ((j+2<16)&&españa[i][j + 2].equals(YELLOW + "o" + WHITE)) {
							if ((j+3<16)&&españa[i][j + 3].equals(YELLOW + "o" + WHITE)) {
								if ((j+4<16)&&españa[i][j + 4].equals(YELLOW + "o" + WHITE)) {
									victoriaderecha2 = true;
									winsalida=false;
								}

							}
						}
					}
				}
			}
		}
	}

	public static void arriba1() {

		for (int i = 0; i < españa.length; i++) {

			for (int j = 0; j < españa.length; j++) {

				if (españa[i][j].equals(BLUE + "x" + WHITE)) {
					if ((i+1<16) && españa[i + 1][j].equals(BLUE + "x" + WHITE)) {
						if ((i+2<16)&&españa[i + 2][j].equals(BLUE + "x" + WHITE)) {
							if ((i+3<16)&&españa[i + 3][j].equals(BLUE + "x" + WHITE)) {
								if ((i+4<16)&&españa[i + 4][j].equals(BLUE + "x" + WHITE)) {
									victoriaarriba = true;
									winsalida=false;
								}

							}
						}
					}
				}else {
					
				}
			}
		}
	}

	public static void arriba2() {

		for (int i = 1; i < españa.length; i++) {

			for (int j = 1; j < españa.length; j++) {

				if (españa[i][j].equals(YELLOW + "o" + WHITE)) {

					if ((i+1<16)&&españa[i + 1][j].equals(YELLOW + "o" + WHITE)) {
						if ((i+2<16)&&españa[i + 2][j].equals(YELLOW + "o" + WHITE)) {
							if ((i+3<16)&&españa[i + 3][j].equals(YELLOW + "o" + WHITE)) {
								if ((i+4<16)&&españa[i + 4][j].equals(YELLOW + "o" + WHITE)) {
									victoriaarriba2 = true;
									winsalida=false;
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
				winsalida=true;
			} else {
				españa[numero1][numero2] = BLUE + "x" + WHITE;
				winsalida=true;
				derecha1();
				arriba1();
				inclinacionArriba1();
				inclinacionAbajo1();
			}
		} else if (ficha.equals(GoMoku.ficha.o)) {
			if (victoriaderecha2 == true || victoriaarriba2 == true || victoriaInclinadaAbajo2==true|| victoriaInclinadaArriba2 == true) {
				españa[numero1][numero2] = GREEN + "o" + WHITE;
				winsalida=true;
				
			} else {
				españa[numero1][numero2] = YELLOW + "o" + WHITE;
				winsalida=true;
				
				derecha2();
				arriba2();
				inclinacionArriba2();
				inclinacionAbajo2();
			}

		}
		}while(winsalida==false);
	}
	public static boolean ganar() {
		if(victoriaderecha2 == true || victoriaarriba2 == true || victoriaInclinadaAbajo2==true|| victoriaInclinadaArriba2==true||victoriaderecha == true || victoriaarriba == true || victoriaInclinadaAbajo1==true|| victoriaInclinadaArriba1==true) {
			return true;
		}else {
			return false;
		}
	}


}
