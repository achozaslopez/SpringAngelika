package es.rf.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.interfaces.daos.ICategoriaDao;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.ErrorMessages;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaDao cDao;

	public CategoriaController() {
	}

	public CategoriaController(ICategoriaDao cDao) {
		this.cDao = cDao;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>>borrar(@PathVariable("id") String ids) throws DAOException {
		Map<String, Object> respuesta = new HashMap<>();
		if (ids != null) {
			int id = Integer.parseInt(ids);
			if (cDao.existsById(id)) {
				cDao.deleteById(id);
				respuesta.put(ErrorMessages.STATUS_OK, "Categoria borrada");
				return new ResponseEntity<>(respuesta,HttpStatus.OK);
			}
		}
		respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_007);
		return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);	}

	@PutMapping
	public ResponseEntity<Map<String, Object>>modificar(@RequestBody Categoria c) throws DAOException {
		Map<String, Object> respuesta = new HashMap<>();
		
		if (c == null) {
			respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_007);
			return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			if (c.isValidUpdate()) {
				if (cDao.existsById(c.getId_categoria())) {
					cDao.save(c);
					respuesta.put(ErrorMessages.STATUS_OK, "Categoria modificada");
					respuesta.put("Datos", c);
					return new ResponseEntity<>(respuesta,HttpStatus.OK);
				}
			}
		} catch (NumberFormatException e) {
			throw new DAOException(ErrorMessages.STATUS_ERR + ErrorMessages.PROERR_008);
		}
		respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_007);
		return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> alta(@RequestBody Categoria c) {
		Map<String, Object> respuesta = new HashMap<>();
		if (cDao.existsById(c.getId_categoria())) {
			respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_007);
			return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
		}

		respuesta.put(ErrorMessages.STATUS_OK, "Categoría guardada");
		respuesta.put("Datos", c);
		cDao.save(c);
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

	@GetMapping
	public List<Categoria> listAll() {
		return cDao.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Map<String, Object>> leerUno(@PathVariable("id") int id) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Categoria c = cDao.findById(id).orElse(null);
			if (c == null) {
				respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_007);
				return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
			}
			respuesta.put(ErrorMessages.STATUS_OK, "Categoría leída");
			respuesta.put("Datos", c);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (NumberFormatException e) {
			respuesta.put(ErrorMessages.STATUS_ERR, ErrorMessages.PROERR_008);
			return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

		}
	}
}
