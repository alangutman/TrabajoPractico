package com.RedSocial.core.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RedSocial.core.entity.Usuario;

@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	public abstract Usuario findByApodo(String apodo);
	public abstract Usuario findByIdUsuario(long idUsuario);
}