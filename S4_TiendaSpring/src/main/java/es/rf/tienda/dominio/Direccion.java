package es.rf.tienda.dominio;

import es.rf.tienda.util.Validator;

public class Direccion {
	
	private String dir_nombre;
	
	private String dir_direccion;
	
	private String dir_poblacion;
	
	private String dir_cPostal;
	
	private String dir_provincia;
	
	private String dir_pais;
	
	private String dir_correoE;
	
	
	public Direccion(){}
	
	public boolean isValidNombre() {
		return Validator.isAlfanumeric(dir_nombre);
	}
	
	public boolean isValidDirreccion() {
		return Validator.isAlfanumeric(dir_direccion);
	}
	
	public boolean isValidPoblacion() {
		return Validator.isAlfanumeric(dir_poblacion);
	}
	
	public boolean isValidCPostal() {
		return Validator.isAlfanumeric(dir_cPostal);
	}
	
	public boolean isValidProvincia() {
		return Validator.isAlfanumeric(dir_provincia);
	}
	
	public boolean isValidPais() {
		return Validator.isAlfanumeric(dir_pais);
	}
	
	public boolean isValidCorreoE() {
		return Validator.isAlfanumeric(dir_correoE);
	}
	
	
	/**
	 * Getter para el nombre de direccion
	 * @return cadena con el nombre de la direccion
	 */
	public String getDir_nombre() {
		return dir_nombre;
	}
	
	/**
	 * Setter para el nombre de direccion
	 * @param dir_nombre
	 */
	public void setDir_nombre(String dir_nombre) {
		this.dir_nombre = dir_nombre;
	}
	
	/**
	 * Getter para direccion
	 * @return cadena con la direccion
	 */
	public String getDir_direccion() {
		return dir_direccion;
	}

	/**
	 * Setter para direccion
	 * @param dir_direccion
	 */
	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
	}

	/**
	 * Getter para poblacion
	 * @return cadena con la poblacion
	 */
	public String getDir_poblacion() {
		return dir_poblacion;
	}

	/**
	 * Setter para poblacion
	 * @param dir_poblacion
	 */
	public void setDir_poblacion(String dir_poblacion) {
		this.dir_poblacion = dir_poblacion;
	}

	/**
	 * Getter para el codigo postal
	 * @return cadena con el codigo postal
	 */
	public String getDir_cPostal() {
		return dir_cPostal;
	}

	/**
	 * Setter del codigo postal
	 * @param dir_cPostal
	 */
	public void setDir_cPostal(String dir_cPostal) {
		this.dir_cPostal = dir_cPostal;
	}

	/**
	 * Getter para provincia
	 * @return cadena con la provincia
	 */
	public String getDir_provincia() {
		return dir_provincia;
	}

	/**
	 * Setter de provincia
	 * @param dir_provincia
	 */
	public void setDir_provincia(String dir_provincia) {
		this.dir_provincia = dir_provincia;
	}

	/**
	 * Getter para pais
	 * @return cadena con el pais
	 */
	public String getDir_pais() {
		return dir_pais;
	}

	/**
	 * Setter de pais
	 * @param dir_pais
	 */
	public void setDir_pais(String dir_pais) {
		this.dir_pais = dir_pais;
	}

	/**
	 * Getter de correo electronico
	 * @return cadena con el correo electronico
	 */
	public String getDir_correoE() {
		return dir_correoE;
	}

	/**
	 * Setter de correo electronico
	 * @param dir_correoE
	 */
	public void setDir_correoE(String dir_correoE) {
		this.dir_correoE = dir_correoE;
	}


	@Override
	public String toString() {
		return "Direccion [dir_nombre=" + dir_nombre + ", dir_direccion=" + dir_direccion + ", dir_poblacion="
				+ dir_poblacion + ", dir_cPostal=" + dir_cPostal + ", dir_provincia=" + dir_provincia + ", dir_pais="
				+ dir_pais + ", dir_correoE=" + dir_correoE + "]";
	}	
	
}
