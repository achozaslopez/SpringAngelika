package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.interfaces.daos.ICategoriaDao;
import es.rf.tienda.dominio.Categoria;


@Service
public class ServicioCategoria implements IServicioCategoria {

	@Autowired
	private ICategoriaDao cDao;
	
	public ServicioCategoria(ICategoriaDao cDao) {
		this.cDao=cDao;
	}
	
	

	public ServicioCategoria() {
		
	}



	public ICategoriaDao getcDao() {
		return cDao;
	}



	public void setcDao(ICategoriaDao cDao) {
		this.cDao = cDao;
	}



	@Override
	public boolean insert(Categoria c) {
		if (c.isValidInsert()) {
			cDao.save(c);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(Categoria c) {
		if (c.isValidUpdate()) {
			cDao.save(c);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Categoria leerUno(int id) {
		try {
			Categoria c = cDao.findById(id).get();
			return c;
		} catch (NoSuchElementException e) {
			return new Categoria();
		}
	}

	@Override
	public List<Categoria> listAll() {
		return cDao.findAll();
	}

	@Override
	public void deleteById(int id) {
		cDao.deleteById(id);

	}

}
