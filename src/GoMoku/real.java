package GoMoku;

public class real extends Jugador {
	@SuppressWarnings("unused")
	
	
	public real(String nombre,ficha ficha) {
		super(ficha);
		this.nombre=nombre;
	}
	static String nombre;
	

	public String getNombre() {
		return nombre;
	}
}
