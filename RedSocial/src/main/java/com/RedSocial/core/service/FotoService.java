package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.converter.FotoConverter;
import com.RedSocial.core.entity.Foto;
import com.RedSocial.core.model.FotoModel;
import com.RedSocial.core.repository.FotoRepository;

@Service("FotoService")
public class FotoService {
	@Autowired
	@Qualifier("FotoRepository")
	private FotoRepository fotoRepository;
	
	@Autowired
	@Qualifier("FotoConverter")
	private FotoConverter fotoConverter;
	
	public boolean crear(Foto foto) {
		try {
			fotoRepository.save(foto);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
	public boolean actualizar(Foto foto) {
		try {
			if (foto.getIdFoto() == 0 || Objects.isNull(foto.getIdFoto()))
				return false; 
			
			fotoRepository.save(foto);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(long idFoto) {
		try {
			Foto foto = fotoRepository.findByIdFoto(idFoto);
			fotoRepository.delete(foto);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<FotoModel> obtener(){
		return fotoConverter.convertir(fotoRepository.findAll());
	}

	public FotoModel obtenerPorNombre(String nombre){
		return new FotoModel(fotoRepository.findByNombre(nombre));
	}
}