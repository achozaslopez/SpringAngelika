package es.rf.tienda.interfaces.daos;

import es.rf.tienda.dominio.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDao extends JpaRepository<Categoria,Integer>{

}
