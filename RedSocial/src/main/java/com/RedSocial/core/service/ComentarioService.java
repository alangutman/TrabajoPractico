package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.converter.ComentarioConverter;
import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.model.ComentarioModel;
import com.RedSocial.core.repository.ComentarioRepository;

@Service("ComentarioService")
public class ComentarioService {
	@Autowired
	@Qualifier("ComentarioRepository")
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	@Qualifier("ComentarioConverter")
	private ComentarioConverter comentarioConverter;
	
	public boolean crear(Comentario comentario) {
		try {
			comentarioRepository.save(comentario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
	public boolean actualizar(Comentario comentario) {
		try {
			if (comentario.getIdComentario() == 0 || Objects.isNull(comentario.getIdComentario()))
				return false; 
			
			comentarioRepository.save(comentario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(long idComentario) {
		try {
			Comentario comentario = comentarioRepository.findByIdComentario(idComentario);
			comentarioRepository.delete(comentario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<ComentarioModel> obtener(){
		return comentarioConverter.convertir(comentarioRepository.findAll());
	}

}
