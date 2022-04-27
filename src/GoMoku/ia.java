package GoMoku;

import java.util.Scanner;

public class ia extends Jugador{
	 static String resultado;
	public ia(ficha ficha) {
		super(ficha);
		// TODO Auto-generated constructor stub
	}
	  Scanner src = new Scanner(System.in);
	private static String nombres[]= {"Pepe","Jorge","España","Lisbania","Me gustaria","Francia caca"," Copenage","Mordekaiser","ElNen"};
	 static int ganador = (int) (Math.random()*9);
	 
	 private static String nombre() {

		return resultado=nombres[ganador];
		 
	 }
	
	 public static void main(String[] args) {
			System.out.println(nombre());
	 }
}
