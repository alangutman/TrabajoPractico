package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Foto;
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.repository.FotoRepository;

@Service("FotoService")
public class FotoService {
	@Autowired
	@Qualifier("FotoRepository")
	private FotoRepository fotoRepository;
	
	public void crear(Foto foto) throws InformationRequiredException{
		
		/*
		 * 1. Valida la foto.
		 */
			validar(foto);
			
		/*
		 * 2. Crea la foto.
		 */ 
			fotoRepository.save(foto);
			
	}
		
	public void actualizar(Foto foto) throws InformationRequiredException, EntityNotFoundException {
		
			/*
			 * 1. Valida que la foto exista.
			 */ 
				buscar(foto.getIdFoto());
	
			/*
			 * 2. Valida la foto.
			 */
				validar(foto);
					
			/*
			 * 3. Actualiza la foto.
			 */ 
			fotoRepository.save(foto);
			
	}
	
	public void borrar(long idFoto) throws InformationRequiredException, EntityNotFoundException {
		
		/*
		 * 1. Valida que la foto exista.
		 */ 
			Foto foto = buscar(idFoto);

		/*
		 * 2. Actualiza la foto.
		 */ 
		fotoRepository.delete(foto);

	}
	
	public Foto buscar(long idFoto) throws InformationRequiredException, EntityNotFoundException {
		
		/*
		 * 1. Valida que se haya ingresado un ID para buscar la foto.
		 */  
			if (Objects.isNull(idFoto) || idFoto == 0)
				throw new InformationRequiredException("Debe ingresar un ID de foto válido"); 
		
		/*
		 * 2. Valida que la foto exista.
		 */  
			if(fotoRepository.findByIdFoto(idFoto) == null) 
				throw new EntityNotFoundException("No fue posible retornar la foto ya que la foto no fue encontrada.");

		return fotoRepository.findByIdFoto(idFoto);
	}
	
	public List<Foto> obtener() throws EmptyListException {

			List<Foto> fotos = fotoRepository.findAll();
			
			if (fotos.isEmpty())
				throw new EmptyListException("No hay fotos registrados para mostrar");
			
		return fotos;
		
	}
	
	public void validar(Foto foto) throws InformationRequiredException {
	
		/*
		 * 1. Valida que se haya ingresado un nombre.
		 */ 
			if(Objects.isNull(foto.getNombre()))
				throw new InformationRequiredException("Debe ingresar un Nombre para la foto.");

		/*
		 * 2. Valida que se haya ingresado una ubicación.
		 */ 
			if(Objects.isNull(foto.getUbicacion()))
				throw new InformationRequiredException("Debe ingresar una Ubicación.");
			
	}
	
}
