package com.RedSocial.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RedSocial.core.entity.Comentario;

@Repository("ComentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Serializable>{
	public abstract Comentario findByIdComentario(long idComentario);
}
