package com.RedSocial.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RedSocial.core.entity.Publicacion;

@Repository("PublicacionRepository")
public interface PublicacionRepository extends JpaRepository<Publicacion, Serializable>{
	public abstract Publicacion findByTitulo(String titulo);
	public abstract Publicacion findByIdPublicacion(long idPublicacion);
}
