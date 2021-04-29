package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.converter.PublicacionConverter;
import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.model.PublicacionModel;
import com.RedSocial.core.repository.PublicacionRepository;
import com.RedSocial.core.repository.UsuarioRepository;

@Service("PublicacionService")
public class PublicacionService {
	
	@Autowired
	@Qualifier("PublicacionRepository")
	private PublicacionRepository publicacionRepository;
	
	@Autowired
	@Qualifier("PublicacionConverter")
	private PublicacionConverter publicacionConverter;

	@Autowired
	@Qualifier("UsuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	
	public boolean crear(Publicacion publicacion) {
		try {
			publicacionRepository.save(publicacion);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
	public boolean actualizar(Publicacion publicacion) {
		try {
			if (publicacion.getIdPublicacion() == 0 || Objects.isNull(publicacion.getIdPublicacion()))
				return false; 
			
			publicacionRepository.save(publicacion);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(long idPublicacion) {
		try {
			Publicacion publicacion = publicacionRepository.findByIdPublicacion(idPublicacion);
			publicacionRepository.delete(publicacion);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<PublicacionModel> obtener(){
		return publicacionConverter.convertir(publicacionRepository.findAll());
	}
	
	public PublicacionModel obtenerPorTitulo(String titulo){
		return new PublicacionModel(publicacionRepository.findByTitulo(titulo));
	}
}
