package GoMoku;

public class Jugador {
	protected String nombre;
	protected static  ficha ficha;

	public Jugador(ficha ficha) {
		Jugador.ficha = ficha;
	}

	public static ficha getFicha() {
		return ficha;
	}

}
