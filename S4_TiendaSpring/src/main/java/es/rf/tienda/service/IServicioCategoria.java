package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;


public interface IServicioCategoria {

	public boolean insert(Categoria c);
	public boolean update (Categoria c);
	public Categoria leerUno(int id);
	public List<Categoria> listAll();
	public void deleteById(int id);
	
}

