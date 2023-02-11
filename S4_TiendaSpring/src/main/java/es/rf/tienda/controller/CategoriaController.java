package es.rf.tienda.controller;

import java.util.List;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.ICategoriaDao;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private ICategoriaDao cDao;
	
	
	@GetMapping("{id}")
	public void leerUno(@PathVariable("id")int id) {
		Categoria c = new Categoria();
		c.setCat_nombre("Alta en web");
		c.setCat_descripcion("Descripcion del alta en web");
		cDao.save(c);
	}
	
	@GetMapping()
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}
	
	@PostMapping
	public String[] alta(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if(c.isValidInsert()) {
			cDao.save(c);
			return new String[] {"200","Registro Salvado"};
		}else {
			return new String[] {"500","Registro No Valido"};
		}
	}
	
	@PutMapping
	public String[] modificacion(@RequestBody Categoria c) {
		if(c.isValidUpdate()) {
			cDao.save(c);
			return new String[] {"200","Registro Modificado"};
		}else {
			return new String[] {"500","Registro No Modificado"};
		}
		
	}
	
	@DeleteMapping("/{id}")
	public String[] eliminar(@PathVariable("id") Integer id) {
		cDao.deleteById(id);
		return new String[] {"200","Registro Eliminado"};
	}
}
