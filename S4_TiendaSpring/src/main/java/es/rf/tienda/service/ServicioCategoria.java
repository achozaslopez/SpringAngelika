package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.ICategoriaDao;

@Service
public class ServicioCategoria implements IServicioCategoria {
	
	@Autowired
	private ICategoriaDao cDao;
	
	public boolean insert(Categoria t) {
		if(t.isValidInsert()) {
		cDao.save(t);
		return true;
		}else {
			return false;
		}
	}
	
	public boolean update(Categoria t) {
		if(t.isValidUpdate()) {
			cDao.save(t);
			return true;
			}else {
				return false;
			}
	}
	
	public boolean deleteById(int s) {
		cDao.deleteById(s);
		return true;
	}
	
	public List<Categoria> listAll(){
		return cDao.findAll();
	}
	
	public Categoria leerUno(int s) {
		try {
			Categoria c = cDao.findById(s).get();
			return c;
		}catch(NoSuchElementException e) {
			return new Categoria();
		}
	}

}
