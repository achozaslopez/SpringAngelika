package es.rf.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.rf.tienda.dominio.Producto;
import es.rf.tienda.interfaces.daos.IProductoDao;

public class ServicioProducto implements IServicioProducto{
	
	@Autowired
	private IProductoDao pDao;
	
	public boolean insert(Producto t) {
		if(t.isValidInsert()) {
		pDao.save(t);
		return true;
		}else {
			return false;
		}
	}

}
