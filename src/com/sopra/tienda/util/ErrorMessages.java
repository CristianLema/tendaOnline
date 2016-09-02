package com.sopra.tienda.util;

/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {

	/**
	 * Formato de código de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	/**
	 * Longitud de código de producto
	 */
	public final static String PROERR_002 = "Longitud de codigo erroneo";

	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	/**
	 * Formato alfanumérico
	 */
	public final static String PROERR_004 = "Formato no alfanumérico";
	/**
	 * Dato fuera de rango
	 */
	public final static String PROERR_005 = "Dato fuera de rango";

	/**
	 * Fecha anterior a la actual
	 */
	public final static String PROERR_006 = "Esta fecha no puede ser anterior a la actual";
	/**
	 * Ausencia de fecha de activación de un producto
	 */
	public final static String PROERR_007 = "No hay fecha de activación de producto";

	/**
	 * Nombre de usuario
	 */
	public final static String USERR_001 = "Nombre de usuario no válido\nSolo puede contener entre 5 y 100 "
			+ "caracteres alfanuméricos.";
	/**
	 * Correo electronico
	 */
	public final static String USERR_002 = "Correo electrónico no válido";
	/**
	 * Constraseña
	 */
	public final static String USERR_003 = "Contraseña no válida\nDebe contener entre 8 y 20 caracteres, "
			+ "en los que debe estar presente al menos una mayúscula, una minúscula, un número y un "
			+ "carácter especial (@ # $ %). No se puede incluir el nombre de usuario";
	/**
	 * DNI
	 */
	public final static String USERR_004 = "DNI no válido. Formato correcto 00.000.000-A";
	/**
	 * Fecha de activación, confirmación o desactivación distintos del día de hoy
	 */
	public static final String USERR_005 = "Le fecha debe ser del día de hoy";

	/**
	 * Crear mensaje de error por longitud
	 * 
	 * @param mensaje_error
	 * @param tipo
	 * @param min
	 * @param max
	 * @return
	 */
	public static String errorLongitud(String mensaje_error, String tipo, int min, int max) {
		mensaje_error = mensaje_error.replace("?", tipo);
		mensaje_error = mensaje_error.replaceFirst(tipo, String.valueOf(min));
		return mensaje_error.replaceFirst(tipo, String.valueOf(max));
	}
}
