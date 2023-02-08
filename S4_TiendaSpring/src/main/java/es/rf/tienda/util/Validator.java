package es.rf.tienda.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicacion.
 * 
 *  @version	30/01/2023 
 *  @author 	Miguel Garcia
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";
	
	private static final String NUMERIC_PATTERN = "^[0-9]+$";
	
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patron para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * caracteres alfanumericos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patron XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un telefono, el cual debe contener de 10 a 20 digitos
	 * y donde los espacios estan permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobara la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicacion.
	 */
	private final static int LONGITUD_DNI = 12;

	/* ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCION: *//**
	 * 		Permite verificar que el texto pasado solo contiene caracteres alfanumericos
	 * 
	 * @param texto String a verificar que solo tenga caracteres alfanumericos
	 * 
	 * @return  true, si cumple solo contiene caracteres alfanumericos.
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		return texto.matches(ALFANUMERIC_PATTERN);
	}

	public static boolean isVacio(String prueba){
		return true;
	}
	
	/* ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		El phone number debe tener un total de entre 10 y 20, contando digitos y espacios.
	 * 		Minimo aceptable son 10 digitos.
	 * 
	 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 digitos. 
	 * 		Puede tener espacios, pero siempre con 10 digitos como minimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		boolean esCorrecto = false;
		String phone = phoneNumber.replace(" ", "");
		if (phone.length() >= 10 && phoneNumber.matches(PHONE_PATTERN)) {
			esCorrecto = true;
		}
		return esCorrecto;
	}

	/* ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Comprueba si el email tiene un formato que pueda ser valido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea valido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		return email.matches(EMAIL_PATTERN);
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCION: *//**
	 * 			Esta funcion verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		// Inicializo variable boolean a false para que devuelva false si no cumple las validaciones
		Boolean seCumple = false;
		
		if (dni.length() == LONGITUD_DNI && dni.matches(DNI_PATTERN)) {
			String[] partsDNI = dni.split("-");  // ["12.121.212","P"];
			int numerosDNI = Integer.parseInt(partsDNI[0].replace(".", "")); // 12121212;
			char letraDNI = dni.charAt(11); // 'M'
			char[] letrasArray = LETRA_DNI.toCharArray(); // Convertir a char[] el String LETRA_DNI
			int resto = numerosDNI % 23; // El resto será un número entre 0 y 22 que será el index 
										 // con el cual identificaremos en letrasArray la letra
										 // que corresponde al dni introducido
			
			boolean contains = false; 			// Validación previa para saber si la letra del dni introducido
			for (char letra : letrasArray) {	// es una de las letras permitidas y se encuentra en letrasArray
				if (letra == letraDNI) {		// Si es así seteo la variable contains a true
			       contains = true;
			       break;
			    }
			}
			
			if (contains && letrasArray[resto] == dni.charAt(11)) { // Si se contiene en el array y además
				seCumple = true;									// la letra introducida se corresponde
			}														// seteo la variable seCumple a true
		}
		
		return seCumple;
	}
	

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprueba que un Numero se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) Numero a comprobar
	 * @param valorMinimo (int) Numero valor aceptable
	 * @param valorMaximo (int) MaxNumero valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Angelika Chozas 
	 * 
	 * **************************************************************************************/

	public static boolean cumpleRango(double valor, int valorMinimo,int valorMaximo){
		Boolean seCumple = false;
		
		if (valorMinimo < valor && valor < valorMaximo) {
			seCumple = true;
		}
		
		return seCumple;
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCION: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como parametro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud minima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima){
		Boolean seCumple = false;
		
		if (texto.length() >= longitudMinima) {
			seCumple = true;
		}
		
		return seCumple;
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCION: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como parametro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud maxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud mixima.
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima){
		Boolean seCumple = false;
		
		if (texto.length() <= longitudMaxima) {
			seCumple = true;
		}
		
		return seCumple;
	}


	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCION: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores maximos y minimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) Minima longitud del texto
	 * @param longitudMaxima (int) Maxima longitud valida para el texto
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima){
		Boolean seCumple = false;
		
		if (longitudMinima <= texto.length() && texto.length() <= longitudMaxima) {
			seCumple = true;
		}

		return seCumple;
	}
	/**
	 * Valida una fecha calendar con minimo min
	 * @param fecha
	 * @param min
	 * @return
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		Boolean esFechaSuperior = false;
		
		if (fecha.isAfter(min)) {
			esFechaSuperior = true;
		}
		
		return esFechaSuperior;
	}
	
	/**
	 * Valida una fecha calendar con maximo max
	 * @param fecha
	 * @param max
	 * @return
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean valDateMax(LocalDate fecha, LocalDate max) {
		Boolean esFechaInferior = false;
		
		if (fecha.isBefore(max)) {
			esFechaInferior = true;
		}
		
		return esFechaInferior;		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean esFechaValida(String fecha) {
		Boolean esValida = false;
		String fechaPattern = "^([0-2]\\d|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
		
		if (fecha.matches(fechaPattern)) {
			esValida = true;
		}
		
		return esValida;
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con las normas de contrasenia
	 * Debe tener una mayuscula, una minuscula, un numero y un caracter especial
	 * @param password string con la contrasenia introducida
	 * @return true si cumple con las especificaciones
	 * FECHA: Enero 2023 
	 * AUTOR: Angelika Chozas
	 * 
	 * **************************************************************************************/
	public static boolean esPasswordValida(String password) {
		Boolean esValida = false;
		
		if (password.matches(PASSWORD_PATTERN)) {
			esValida = true;
		}
		
		return esValida;
	}

}