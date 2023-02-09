package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

public interface IServicioCategoria {
	
	public boolean insert(Categoria t);
	public boolean update(Categoria t);
	public boolean deleteById(int s);
	public List<Categoria> listAll();
	public Categoria leerUno(int s);

}
