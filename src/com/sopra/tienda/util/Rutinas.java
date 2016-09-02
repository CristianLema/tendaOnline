package com.sopra.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class Rutinas {
	/**
	 * Recibe una fecha en formato String, comprueba que está correcta y en
	 * formato dd/MM/yyyy y la devuelve como Calendar
	 * 
	 * @param fecha
	 *            String supuestamente con formato dd/MM/yyyy
	 * @return Calendar. Devuelve NULL si está incorrecta la fecha de entrada
	 */
	public static Calendar convierteACalendar(String fecha) {
		Calendar fechaSalida = Calendar.getInstance();
		if (!checkFecha(fecha)) {
			fechaSalida.setTime(null);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				fechaSalida.setTime(sdf.parse(fecha));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return fechaSalida;
	}

	/**
	 * Recibe una fecha en formato Calendar y la devuelve en formato String
	 * dd/MM/yyyy
	 * 
	 * @param fecha
	 *            Calendar
	 * @return fecha String en formato dd/MM/yyyy
	 */
	public static String convierteAString(Calendar fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha.getTime());
	}

	/**
	 * Comprobar que una fecha es correcta
	 * 
	 * @param fechaEntrada
	 * @return boolean con true si la fecha es correcta
	 */
	public static boolean checkFecha(String fechaEntrada) {
		boolean res = true;

		// comrpobar que fechaEntrada está escrita correctamente
		if (fechaEntrada.length() != 10) {
			res = false;
		} else {
			// comprobar uno a uno los caracteres
			for (int i = 0; i < 10; i++) {
				if (i != 2 && i != 5) {
					if (!Character.isDigit(fechaEntrada.charAt(i))) {
						res = false;
					}
				} else {
					if (fechaEntrada.charAt(i) != '/') {
						res = false;
					}
				}
			}
		}

		// comprobar si la fecha es correcta
		if (res) {
			String[] data = fechaEntrada.split("/");
			int anoInt = Integer.parseInt(data[2]);
			int mesInt = Integer.parseInt(data[1]);
			int diaInt = Integer.parseInt(data[0]);
			int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (mesInt > 0 && mesInt <= 12) {
				if (mesInt == 2 && Year.isLeap(anoInt)) {
					meses[1]++;
				}
				if (diaInt > meses[mesInt - 1]) {
					res = false;
				}
			} else {
				res = false;
			}

		}

		return res;
	}

	/**
	 * Se convierte el campo de valor a un String. Si valor ya es un String, se
	 * le añade ' a los lados
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            Integer con el contenido del campo
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return se envía a addSalidaComun para realizar las operaciones
	 *         demandadas
	 */
	public static String addSalida(String salida, String nombreCampo, int valor, String separador) {
		return addSalidaComun(salida, nombreCampo, String.valueOf(valor), separador);
	}

	/**
	 * Se convierte el campo de valor a un String. Si valor ya es un String, se
	 * le añade ' a los lados
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            Long con el contenido del campo
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return se envía a addSalidaComun para realizar las operaciones
	 *         demandadas
	 */
	public static String addSalida(String salida, String nombreCampo, long valor, String separador) {
		return addSalidaComun(salida, nombreCampo, String.valueOf(valor), separador);
	}

	/**
	 * Se convierte el campo de valor a un String. Si valor ya es un String, se
	 * le añade ' a los lados
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            Double con el contenido del campo
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return se envía a addSalidaComun para realizar las operaciones
	 *         demandadas
	 */
	public static String addSalida(String salida, String nombreCampo, double valor, String separador) {
		return addSalidaComun(salida, nombreCampo, String.valueOf(valor), separador);
	}

	/**
	 * Se convierte el campo de valor a un String. Si valor ya es un String, se
	 * le añade ' a los lados
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            String con el contenido del campo
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return se envía a addSalidaComun para realizar las operaciones
	 *         demandadas
	 */
	public static String addSalida(String salida, String nombreCampo, String valor, String separador) {
		return addSalidaComun(salida, nombreCampo, "\'" + valor + "\'", separador);
	}

	/**
	 * Se convierte el campo de valor a un String. Si valor ya es un String, se
	 * le añade ' a los lados
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            Calendar con el contenido del campo
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return se envía a addSalidaComun para realizar las operaciones
	 *         demandadas
	 */
	public static String addSalida(String salida, String nombreCampo, Calendar valor, String separador) {
		return addSalidaComun(salida, nombreCampo, convierteAString(valor), separador);
	}

	/**
	 * Completa SQL Añadiendo el nombre del campo y su valor (si se pasa)
	 * Pensado para INSERT, UPDATES y WHERE
	 * 
	 * @param salida
	 *            String con la parte que se lleva construida
	 * @param nombreCampo
	 *            String con el nombre de un campo
	 * @param valor
	 *            Contenido del campo, puede ser int, double, long, String o
	 *            Calendar
	 * @param separador
	 *            String con el contenido que ha de separar esta entrada de las
	 *            precedentes
	 * @return Deuelve un String con los valores añadidos
	 */
	public static String addSalidaComun(String salida, String nombreCampo, String valor, String separador) {
		// Inicio el String que saldrá del método
		String str = "";
		// Si no está vacío, se añade el separador, con espacios a los dos lados
		if (!salida.isEmpty()) {
			str += " " + separador + " ";
		}
		if (!nombreCampo.isEmpty()) {
			str += nombreCampo + "=";
		}
		str += valor;
		return salida+str;
	}

}
