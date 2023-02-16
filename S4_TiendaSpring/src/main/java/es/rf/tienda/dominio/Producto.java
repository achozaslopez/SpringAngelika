package es.rf.tienda.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Nombre Producto
 * Descripcion Tabla de productos
 * @author Angelika Chozas
 * @version 
 *
 */
@SuppressWarnings("serial")
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

	public void setId_producto(String id_producto) throws DomainException {
		if (Validator.cumpleLongitud(id_producto.toUpperCase(), 5, 5)) {
			this.id_producto = id_producto;
		} else {
			throw new DomainException(ErrorMessages.PROERR_001);
		}
	}

	public String getPro_descripcion() {
		return pro_description;
	}

	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if (Validator.cumpleLongitud(pro_descripcion, 5, 100)) {
			this.pro_description = pro_descripcion;
		} else {
			throw new DomainException(ErrorMessages.PROERR_003);
		}
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if (Validator.cumpleLongitud(pro_desLarga, 5, 2000)) {
			this.pro_desLarga = pro_desLarga;
		} else {
			throw new DomainException(ErrorMessages.PROERR_003);
		}
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public static void setPro_precio(double pro_precio) throws DomainException {
		if (Validator.cumpleRango(pro_precio, 0, 100)) {
			System.out.println(pro_precio);
		} else {
			throw new DomainException(ErrorMessages.PROERR_003);
		}
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if (Validator.valDateMin(pro_fecActi, LocalDate.now())
				|| (Validator.valDateMax(pro_fecRepos, LocalDate.now()))) {
			this.pro_fecActi = pro_fecActi;
		} else {
			throw new DomainException(ErrorMessages.PROERR_001);
		}
	}

	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if (Validator.valDateMin(pro_fecActi, LocalDate.now())
				|| (Validator.valDateMax(pro_fecRepos, LocalDate.now()))) {
			this.pro_fecActi = pro_fecActi;
		} else {
			throw new DomainException(ErrorMessages.PROERR_004);
		}
	}

	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		if (pro_fecActi == null && Validator.valDateMin(pro_fecDesacti, LocalDate.now())) {
			this.pro_fecDesacti = pro_fecDesacti;
		} else if (pro_fecActi != null) {
			pro_fecDesacti.isAfter(pro_fecActi);
			this.pro_fecDesacti = pro_fecDesacti;
		} else {
			throw new DomainException(ErrorMessages.PROERR_004);
		}
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta)  {
			this.pro_uniVenta = pro_uniVenta;
		
	
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado)  {
			this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(char pro_stat) throws DomainException {
		if (Validator.cumpleRango(Character.getNumericValue(pro_stat), Character.getNumericValue('A'),
				Character.getNumericValue('B'))) {
			this.pro_stat = pro_stat;
		} else {
			throw new DomainException(ErrorMessages.PROERR_001);
		}

	}

	@Override
	public boolean isValidInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidUpdate() {
		// TODO Auto-generated method stub
		return false;
	}
}
