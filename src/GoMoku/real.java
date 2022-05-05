package GoMoku;

public class real extends Jugador {

	public real(String nombre, ficha ficha) {
		super(ficha);
		this.nombre = nombre;
	}

	 String nombre;

	public String getNombre() {
		return nombre;
	}
}
