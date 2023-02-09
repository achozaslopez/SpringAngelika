package es.rf.tienda.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import es.rf.tienda.util.Validator;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Nombre Producto
 * Descripcion Tabla de productos
 * @author Angelika Chozas
 * @version 
 *
 */
@Entity
@Table(schema = "ALUMNO_ACL", name = "PRODUCTOS")
public class Producto implements Serializable, Modelo{
	
	@Id
	@Column(nullable=false)
	private String id_producto;			//Codigo de producto
	
	@Column(nullable=false)
	private String pro_description;		//Descripcion corta
	
	@Column
	private String pro_desLarga;		//Explicacion
	
	@Column(nullable=false)
	private Double pro_precio;			//Precio
	
	@Column
	private int pro_stock;				//Stock
	
	@Column
	private LocalDate pro_fecRepos;		//Fecha prevista reposicion
	
	@Column
	private LocalDate pro_fecActi;		//Fecha activacion
	
	@Column
	private LocalDate pro_fecDesacti;	//Fecha desactivacion
	
	@Column(nullable=false)
	private String pro_uniVenta;		//Unidad de venta
	
	@Column
	private Double pro_cantXUniVenta;	//Cantidad de unidades ultimas
	
	@Column
	private String pro_uniUltNivel;		//Unidad ultima
	
	@Column(nullable=false)
	private int id_pais;				//Pais de origen
	
	@Column
	private String pro_usoRecomendado;	//Uso recomendado
	
	@Column(nullable=false)
	private int id_categoria;			//Categoria
	
	@Column
	private int pro_stkReservado;		//Stock reservado
	
	@Column
	private int pro_nStkAlto;			//Stock para nivel alto
	
	@Column
	private int pro_nStkBajo;			//Stock para nivel bajo
	
	@Column
	private char pro_stat;				//Estado
	
	
	public Producto() {}
	
	/**
	 * Getter Codigo de producto
	 * @return cadena alfanumerica con el id del producto
	 */
	public String getId_producto() {
		return id_producto;
	}

	/**
	 * Setter para codigo de producto
	 * 
	 */
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	/**
	 * Getter Descripcion corta de producto
	 * @return cadena con una breve descripcion del producto
	 */
	public String getPro_description() {
		return pro_description;
	}

	/**
	 * Setter para la descripcion corta del producto
	 *
	 */
	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	/**
	 * Getter Descripcion larga del producto
	 * @return cadena con una descripcion larga del producto
	 */
	public String getPro_desLarga() {
		return pro_desLarga;
	}

	/**
	 * Setter para la descripcion larga del producto
	 * 
	 */
	public void setPro_desLarga(String pro_desLarga) {
		this.pro_desLarga = pro_desLarga;
	}

	/**
	 * Getter del precio del procucto
	 * @return double del precio del producto
	 */
	public Double getPro_precio() {
		return pro_precio;
	}

	/**
	 * Setter para el precio del producto
	 * 
	 */
	public void setPro_precio(Double pro_precio) {
		this.pro_precio = pro_precio;
	}

	/**
	 * Getter del stock del producto
	 * @return Integer con el stock del producto
	 */
	public int getPro_stock() {
		return pro_stock;
	}

	/**
	 * Setter para el stock de producto
	 * 
	 */
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	/**
	 * Getter de la fecha prevista de reposicion
	 * @return LocalDate de la fecha prevista de reposicion
	 */
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	/**
	 * Setter para la fecha prevista de reposicion
	 * 
	 */
	public void setPro_fecRepos(LocalDate pro_fecRepos) {
		this.pro_fecRepos = pro_fecRepos;
	}

	/**
	 * Getter de la fecha de activacion del producto
	 * @return LocalDate de la fecha de activacion de producto
	 */
	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	/**
	 * Setter para la fecha de activacion del producto
	 * @param pro_fecActi
	 */
	public void setPro_fecActi(LocalDate pro_fecActi) {
		this.pro_fecActi = pro_fecActi;
	}

	/**
	 * Getter de la fecha de desactivacion del producto
	 * @return LocalDate de la fecha de desactivacion del producto
	 */
	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	/**
	 * Setter para la fecha de desactivacion del producto
	 * 
	 */
	public void setPro_fecDesacti(LocalDate pro_fecDesacti) {
		this.pro_fecDesacti = pro_fecDesacti;
	}

	/**
	 * Getter de la unidad de venta de producto
	 * @return cadena alfanumerica con la unidad de venta de producto
	 */
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	/**
	 * Setter para la unidad de venta de producto
	 * 
	 */
	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}

	/**
	 * Getter de la cantidad de unidades ultimas de producto
	 * @return double con la cantidad de unidades ultimas de producto
	 */
	public Double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	/**
	 * Setter para la cantidad de unidades ultimas de producto
	 * 
	 */
	public void setPro_cantXUniVenta(Double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	/**
	 * Getter de unidad ultima
	 * @return cadena con la unidad ultima
	 */
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	/**
	 * Setter para la unidad ultima
	 * 
	 */
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	/**
	 * Getter de pais de origen de producto
	 * @return Integer de pais de origen
	 */
	public int getId_pais() {
		return id_pais;
	}

	/**
	 * Setter para pais de origen de producto
	 * 
	 */
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	/**
	 * Getter uso recomendado de producto
	 * @return cadena con el uso recomendado de producto
	 */
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	/**
	 * Setter para el uso recomendado de producto
	 * 
	 */
	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	/**
	 * Getter para identificador de categoria
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
	 * Getter del stock reservado
	 * @return Integer de stock reservado de producto
	 */
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	/**
	 * Setter para el stock reservado de producto
	 * 
	 */
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	/**
	 * Getter del stock para nivel alto
	 * @return Integer de stock para nivel alto de producto
	 */
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	/**
	 * Setter para el stock para nivel alto de producto
	 * 
	 */
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	/**
	 * Getter del stock para nivel bajo
	 * @return Integer de stock para nivel bajo de producto
	 */
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	/**
	 * Setter para el stock para nivel bajo de producto
	 * 
	 */
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	/**
	 * Getter del estado del producto
	 * @return Caracter con el estado del producto
	 */
	public char getPro_stat() {
		return pro_stat;
	}

	/**
	 * Setter para el estado de producto
	 * 
	 */
	public void setPro_stat(char pro_stat) {
		this.pro_stat = pro_stat;
	}
	
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", pro_description=" + pro_description + ", pro_desLarga="
				+ pro_desLarga + ", pro_precio=" + pro_precio + ", pro_stock=" + pro_stock + ", pro_fecRepos="
				+ pro_fecRepos + ", pro_fecActi=" + pro_fecActi + ", pro_fecDesacti=" + pro_fecDesacti
				+ ", pro_uniVenta=" + pro_uniVenta + ", pro_cantXUniVenta=" + pro_cantXUniVenta + ", pro_uniUltNivel="
				+ pro_uniUltNivel + ", id_pais=" + id_pais + ", pro_usoRecomendado=" + pro_usoRecomendado
				+ ", id_categoria=" + id_categoria + ", pro_stkReservado=" + pro_stkReservado + ", pro_nStkAlto="
				+ pro_nStkAlto + ", pro_nStkBajo=" + pro_nStkBajo + ", pro_stat=" + pro_stat + "]";
	}
	
	@Transient
	public boolean isValidLongIdProducto() {
		return Validator.cumpleLongitud(id_producto, 5, 5)&& Validator.isAlfanumeric(id_producto) ;
	}
	
	@Transient
	public boolean isValidLongDescripcion() {
		return Validator.cumpleLongitud(pro_description, 5, 100);
	}
	
	@Transient
	public boolean isValidLongDesLArga() {
		return Validator.cumpleLongitud(pro_desLarga, 5, 2000);
	}
	
	@Transient
	public boolean isValidRangoPrecio() {
		return Validator.cumpleRango(pro_precio, 0, 100);
	}
	
	@Transient
	public boolean isValidFechaRepos() {
		return Validator.valDateMin(pro_fecRepos, LocalDate.now());
	}
	
	@Transient
	public boolean isValidFechaActi() {
		return Validator.valDateMin(pro_fecActi, LocalDate.now());
	}
	
	@Transient
	public boolean isValidFechaDesacti() {
		return Validator.valDateMin(pro_fecDesacti, LocalDate.now());
	}
	
	@Transient
	public boolean isValidUniVenta() {
		return Validator.isAlfanumeric(pro_uniVenta);
	}
	
	@Transient
	public boolean isValidUsoRecomendado() {
		return Validator.isAlfanumeric(pro_usoRecomendado)&& Validator.cumpleLongitud(pro_usoRecomendado, 0, 2000);
	}

	@Transient
	public boolean isValidInsert() {
		boolean result = !Validator.isVacio(pro_description);
		return result;
	}

	@Transient
	public boolean isValidUpdate() {
		Integer id_prod = Integer.valueOf(id_producto);
		boolean result = !Validator.isVacio(pro_description) && id_prod > 0;
		return result;
	}
	

	

}
