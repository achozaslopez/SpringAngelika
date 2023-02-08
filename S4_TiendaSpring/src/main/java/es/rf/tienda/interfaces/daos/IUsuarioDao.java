package es.rf.tienda.interfaces.daos;

import es.rf.tienda.dominio.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

}
