package GoMoku;

public class real extends Jugador {
	@SuppressWarnings("unused")
	private String nombre;
	
	
	public real(String nombre,ficha ficha) {
		super(ficha);
		this.nombre=nombre;
	}
	public static int transformar(String posicion) {
		if(posicion=="a"||posicion=="A"){
			return 1;
		}else if(posicion=="b"||posicion=="B") {
			return 2;
		}else if(posicion=="c"||posicion=="C") {
			return 3;
		}else if(posicion=="d"||posicion=="D") {
			return 4;
		}else if(posicion=="e"||posicion=="E") {
			return 5;
		}else if(posicion=="f"||posicion=="F") {
			return 6;
		}else if(posicion=="g"||posicion=="G") {
			return 7;
		}else if(posicion=="h"||posicion=="H") {
			return 8;
		}else if(posicion=="i"||posicion=="I") {
			return 9;
		}else if(posicion=="j"||posicion=="J") {
			return 10;
		}else if(posicion=="k"||posicion=="K") {
			return 11;
		}else if(posicion=="l"||posicion=="L") {
			return 12;
		}else if(posicion=="m"||posicion=="M") {
			return 13;
		}else if(posicion=="n"||posicion=="N") {
			return 14;
		}else if(posicion=="o"||posicion=="O") {
			return 15;
		}else {
			return 0;
		}	
	}
	
}
