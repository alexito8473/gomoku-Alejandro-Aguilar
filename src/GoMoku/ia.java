package GoMoku;

import java.util.Random;
import java.util.Scanner;

public class ia extends Jugador{
	public static String resultado;
	static Random ran=new Random();
	static int number=ran.nextInt(9);
	static int number2=ran.nextInt(9);
	public ia(ficha ficha) {
		super(ficha);
	}
	  Scanner src = new Scanner(System.in);
	private static  String nombres[]= {"Pepe","Jorge","España","Lisbania","Me gustaria","Francia caca","Copenage","Mordekaiser","ElNen"};
	 
	 public static String nombre(ficha ficha) {
		 if(ficha==ficha.x) {
			 return resultado=nombres[number];
		 }else {
			 return resultado=nombres[number2];
		 }
		 
		
		 
	 }
}
