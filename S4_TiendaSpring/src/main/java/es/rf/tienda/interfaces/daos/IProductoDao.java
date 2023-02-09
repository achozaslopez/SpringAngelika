package es.rf.tienda.interfaces.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Producto;

public interface IProductoDao extends JpaRepository<Producto,Integer> {

}
