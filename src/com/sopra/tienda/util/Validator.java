package com.sopra.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicaci�n.
 * 
 * @version 30/01/2016
 * @author Miguel Garcia
 * 
 ******************************************************************************************/
public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z ]+$";

	private static final String PROD_CODE_PATTERN = "^[A-Z]{2}[0-9]{3}+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga car�cteres alfanum�ricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patr�n 00.000.000-A
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos y
	 * donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters
		 * alfanum�ricos
		 * 
		 * @param texto
		 *            String a verificar que solo tenga car�cteres alfanum�ricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanum�ricos. <br>
		 *         false en caso contrario FECHA: Enero 2016
		 * 
		 *         AUTOR: Miguel Garcia - Barcelona
		 * 
		 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {
		Pattern pattern = Pattern.compile(ALFANUMERIC_PATTERN);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

	public static boolean isVacio(String prueba) {
		return (prueba == null || prueba.equals(""));
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando
		 * d�gitos y espacios. M�nimo aceptable son 10 d�gitos.
		 * 
		 * @param phoneNumber
		 *            String con el n�mero de telefono de entre 10 y 20 d�gitos.
		 *            Puede tener espacios, pero siempre con 10 d�gitos como
		 *            m�nimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 *
		 *         FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		boolean res = false;
		if (phoneNumber.length() >= 10 && phoneNumber.length() <= 20) {
			// Contamos cuántos dígitos hay
			int contadorNumeros = 0;
			for (int i = 0; i < phoneNumber.length(); i++) {
				if (Character.isDigit(phoneNumber.charAt(i))) {
					contadorNumeros++;
					if (contadorNumeros >= 10) {
						// Para evitar que dé 'true' cuando el carácter que no
						// es ni dígito ni espacio esté después del dígito
						// número 10
						res = true;
					}
				} else {
					if (phoneNumber.charAt(i) != ' ') {
						res = false;
						break;
					}
				}
			}
			// Si se pusiera aquí el if(contadorNumeros >=10), en el caso de
			// phoneNumer="215 245 685 258 6r2" daría 'true' porque una vez
			// salido del bucle porque ha encontrado "r" res cambiaría a 'true'
			// porque contadorNumeros>=10

		}
		return res;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser v�lido.
		 * 
		 * @param email
		 *            String a comprobar
		 * 
		 * @return true, en caso que el formato sea v�lido FECHA: Enero 2016
		 * 
		 *         AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean isEmailValido(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Esta funci�n verifica que el DNI cumple el siguiente formato:
		 * xx.xxx.xxx-L <br>
		 * El DNI ha de tener longitud 12
		 * 
		 * @param dni
		 *            String con DNI a ser validado
		 * 
		 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero
		 *         2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {
		boolean res = true;
		// comprobar que tenga 12 caracteres
		if (dni.length() == LONGITUD_DNI) {
			// comprobar que cumple con el formato xx.xxx.xxx-L
			for (int i = 0; i < LONGITUD_DNI; i++) {
				// comprobar que en las posiciones 2 y 6 haya un '.'
				if (i == 2 || i == 6) {
					if (dni.charAt(i) != '.') {
						res = false;
					}
				} else {
					// comprobar que en la posición 10 haya un '-'
					if (i == 10) {
						if (dni.charAt(i) != '-') {
							res = false;
						}
					} else {
						// comprobar que en la posición 11 haya una letra
						if (i == 11) {
							if (!Character.isLetter(dni.charAt(i))) {
								res = false;
							}
						} else {
							// comprobar que el resto de los caracteres son
							// números
							if (!Character.isDigit(dni.charAt(i))) {
								res = false;
							}
						}
					}
				}
			}
		} else {
			res = false;
		}

		// comprobar que la letra sea correcta sólo si está bien escrita
		if (res) {
			dni = dni.replace(".", "");
			// obtener el número del dni en un int
			int numero = Integer.parseInt(dni.substring(0, 8));
			// obtenemos su módulo
			numero %= 23;
			// comprobar que el módulo esté en el rango
			if (numero >= 0 && numero <= 22) {
				// obtenemos la letra que le corresponde
				if (LETRA_DNI.charAt(numero) != dni.charAt(dni.length() - 1)) {
					res = false;
				}
			} else {
				res = false;
			}

		}

		return res;
	}

	/**
	 * *************************************************************************
	 * ************** NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor
	 *            (int)/(double) N�mero a comprobar
	 * @param valorMinimo
	 *            (int) N�mero valor aceptable
	 * @param valorMaximo
	 *            (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo FECHA: Enero 2016
	 *         AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		return valorMinimo <= valor && valor <= valorMaximo;
	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {
		return valorMinimo <= valor && valor <= valorMaximo;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto
		 *            String texto a comprobar
		 * @param longitudMinima
		 *            int que indique longitud m�nima.
		 * 
		 * @return cierto, si la longitud del texto es mayor o igual que
		 *         longitudMinima FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {
		return texto.length() >= longitudMinima;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto
		 *            String con el texto a comprobar
		 * @param longitudMaxima
		 *            int con la longitud m�xima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud m�xima.
		 *         FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return texto.length() <= longitudMaxima;
	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores
	 * m�ximos y m�nimos
	 * 
	 * @param texto
	 *            String con el texto que a validar
	 * @param longitudMinima
	 *            (int) M�nima longitud del texto
	 * @param longitudMaxima
	 *            (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima FECHA: Enero 2016 AUTOR: Miguel
	 *         Garcia - Barcelona
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		return longitudMinima <= texto.length() && texto.length() <= longitudMaxima;
	}

	/**
	 * Valida una fecha calendar con m�nimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 */

	public static boolean valDateMin(Calendar fecha, Calendar min) {
		return !fecha.before(min);
	}

	/**
	 * Valida una fecha calendar con m�ximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(Calendar fecha, Calendar max) {
		return !fecha.after(max);
	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba
	 * el formato
	 * 
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha) {
		boolean res = true;

		// comrpobar que fecha está escrita correctamente
		if (fecha.length() != 10) {
			res = false;
		} else {
			// comprobar uno a uno que los caracteres están en su posición
			// correcta
			for (int i = 0; i < 10; i++) {
				if (i != 2 && i != 5) {
					// comprobar que excepto en las posiciones 2 y 5, haya solo
					// dígitos
					if (!Character.isDigit(fecha.charAt(i))) {
						res = false;
					}
				} else {
					// comprobar que en las opsiciones 2 y 5 haya '/'
					if (fecha.charAt(i) != '/') {
						res = false;
					}
				}
			}
		}

		// comprobar que la fecha es lógica siempre y cuando esté bien escrita
		if (res) {
			// meter la fecha en un String[]
			String[] data = fecha.split("/");
			// obtener año mes y día
			int anoInt = Integer.parseInt(data[2]);
			int mesInt = Integer.parseInt(data[1]);
			int diaInt = Integer.parseInt(data[0]);
			// array con la cantidad de días que hay en cada mes
			int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (mesInt > 0 && mesInt <= 12) {
				// si es año bisiesto, se le añade un día a febrero
				if (mesInt == 2 && Year.isLeap(anoInt)) {
					meses[1]++;
				}
				// comprobar que el número de días no sobrepase el máximo del
				// mes
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
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida
	 * cumpla con lasnormas de contrase�a
	 * 
	 * @param password
	 *            string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/**
	 * Comprobar que el código de producto es válido, empezando por dos
	 * mayúsculas y seguido de tres dígitos
	 * 
	 * @param codigo
	 * @return
	 */
	public static boolean esCodigoProductoValida(String codigo) {
		Pattern pattern = Pattern.compile(PROD_CODE_PATTERN);
		Matcher matcher = pattern.matcher(codigo);
		return matcher.matches();
	}

}
