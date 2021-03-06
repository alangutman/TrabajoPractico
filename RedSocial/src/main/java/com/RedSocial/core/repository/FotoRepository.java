package com.RedSocial.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RedSocial.core.entity.Foto;

@Repository("FotoRepository")
public interface FotoRepository extends JpaRepository<Foto, Serializable>{
	public abstract Foto findByIdFoto(long idFoto);
}
