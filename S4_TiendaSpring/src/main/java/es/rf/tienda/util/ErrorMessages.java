package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Febrero 2023
 *  
 *  @author 	Angelika Chozas
 *  
 *  *****************************************************/
public class ErrorMessages {

	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";

	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	public final static String PROERR_003_1 = "La longitud de nombre ha de estar entre 5 y 10";
	/**
	 * Fecha erronea
	 */
	public final static String PROERR_004 = "Fecha errónea";
	/**
	 * Email erroneo
	 */
	public final static String PROERR_005 = "Email erróneo";
	/**
	 * Dni erroneo
	 */
	public final static String PROERR_006 = "DNI erróneo";
	
	/**
	 * Status ok
	 */
	public final static String STATUS_OK = "Status: 1";

	/**
	 * Status ERR
	 */
	public final static String STATUS_ERR = "Status: 0";
	
	/**
	 * Categoria vacía
	 */
	public final static String PROERR_007= "Error: la Categoría seleccionada no existe";
	
	/**
	 * Id incorrecto
	 */
	public final static String PROERR_008= "Error: Id incorrecto";
	
	
	
}
