package com.sopra.tienda.util;

public class MainRutinas {

	public static void main(String[] args) {
		String salida="";
		salida = Rutinas.addSalida(salida, "campo1", 245, "AND");
		System.out.println(salida);
		salida = Rutinas.addSalida(salida, "campo2", 245l, "AND");
		System.out.println(salida);
		salida = Rutinas.addSalida(salida, "", 245d, "AND");
		System.out.println(salida);
		salida = Rutinas.addSalida(salida, "campo4", "Campanario", ",");
		System.out.println(salida);
		
	}

}
