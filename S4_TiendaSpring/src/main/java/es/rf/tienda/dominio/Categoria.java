package es.rf.tienda.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre Categoria 
 * 
 * @author Angelika Chozas
 * @version ene. de 2023
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(schema = "ALUMNO_ACL", name = "CATEGORIAS")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_categoria; // identificador categoria

	@Column(nullable = false, length = 50)
	private String cat_nombre; // nombre de la categoria

	@Column(nullable = true, length = 200)
	private String cat_descripcion; // descripcion de la categoria

	public Categoria(int id_categoria, String cat_nombre, String cat_descripcion) {
		this.id_categoria = id_categoria;
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
	}

	public Categoria() {
	}

	@Transient
	@JsonIgnore
	public boolean isValid() {
		return !Validator.isVacio(cat_nombre) && id_categoria > 0;
	}

	/**
	 * Getter para identificador de categoria
	 * 
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter para el nombre de categoria
	 * 
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;

	}

	/**
	 * Setter para el nombre de categoria
	 * 
	 */ 
	public void setCat_nombre(String cat_nombre) throws DomainException {
		if (Validator.cumpleLongitud(cat_nombre, 5, 50)) {
			this.cat_nombre = cat_nombre;
		} else {
			throw new DomainException(ErrorMessages.PROERR_003_1);
		}
	}

	/**
	 * Getter para la descripcion de categoria
	 * 
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}

	/**
	 * setter para la descripcion de categoria
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion == null ? null : StringUtils.truncate(cat_descripcion, 200);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}

	@Transient
	@JsonIgnore
	public boolean isValidInsert() {
		boolean result = !Validator.isVacio(cat_nombre);
		System.out.println(Validator.isVacio(cat_nombre));

		return result;
	}

	@Transient
	@JsonIgnore
	public boolean isValidUpdate() {
		boolean result = !Validator.isVacio(cat_nombre) && id_categoria > 0;
		System.out.println(Validator.isVacio(cat_nombre));
		System.out.println(id_categoria > 0);
		return result;

	}

}
