package es.rf.tienda.dominio;

public class Pais {
	
	private int id_pais;
	private String nombre_pais;
	
	public Pais() {}
	
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombre_pais() {
		return nombre_pais;
	}
	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}
	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", nombre_pais=" + nombre_pais + "]";
	}
	
	

}
