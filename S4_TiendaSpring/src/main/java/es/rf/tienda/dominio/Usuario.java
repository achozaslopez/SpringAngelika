package es.rf.tienda.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre Usuario
 * 
 * @author Angelika Chozas
 * @version Febrero 2023
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(schema = "ALUMNO_ACL", name = "USUARIOS")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id; 

	@Column
	private String user_nombre; 

	@Column
	private String user_email; 

	@Column
	private String user_pass; 

	@Column
	private int user_tipo; 

	@Column(nullable = false, length= 12)
	private String user_dni; 

	@Column(nullable = false)
	private LocalDate user_fecAlta; 

	@Column(nullable = false)
	private LocalDate user_fecConfirmacion; 
	
	

	public Usuario() {}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, 5, 100)) {
			this.user_nombre = user_nombre;
		} else {
			throw new DomainException(ErrorMessages.PROERR_003);
		}
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email)throws DomainException {
		if (Validator.isEmailValido(user_email)) {
			this.user_email = user_email;
		} else {
			throw new DomainException(ErrorMessages.PROERR_004);
		}
	}
		

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public int getUser_tipo() {
		return user_tipo;
	}

	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) {
		this.user_dni = user_dni;
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public void setUser_fecAlta(LocalDate user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}

}
