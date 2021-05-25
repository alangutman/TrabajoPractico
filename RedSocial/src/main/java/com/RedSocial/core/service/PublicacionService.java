package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.repository.PublicacionRepository;

@Service("PublicacionService")
public class PublicacionService {
	
	@Autowired
	@Qualifier("PublicacionRepository")
	private PublicacionRepository publicacionRepository;
	
	@Autowired
	@Qualifier("UsuarioService")
	private UsuarioService usuarioService;
	
	public boolean crear(Publicacion publicacion) throws InformationRequiredException, EntityNotFoundException {
	
		/*
		 * 1. Valida que se haya ingresado un título.
		 */  
			if(Objects.isNull(publicacion.getTitulo()) || Objects.equals("", publicacion.getTitulo()))
				throw new InformationRequiredException("Debe ingresar un Título.");
		
		/*
		 * 2. Valida que se haya ingresado una descripción.
		 */  
			if(Objects.isNull(publicacion.getDescripcion()) || Objects.equals("", publicacion.getDescripcion()))
				throw new InformationRequiredException("Debe ingresar una Descripción.");
		
		/*
		 * 3. Valida que el usuario exista.
		 */  
			Usuario autor = usuarioService.buscar(publicacion.getAutor().getIdUsuario());	
		
		/*
		 * 4. Setea el autor de la publicación.
		 */  
			publicacion.setAutor(autor);
		
		/*
		 * 5. Crea la publicación.
		 */  
			publicacionRepository.save(publicacion);
		
		return true;

	}
		
	public boolean actualizar(Publicacion publicacion) throws InformationRequiredException, EntityNotFoundException {

		/*
		 * 1. Valida que la publicación exista.
		 */ 
			Publicacion publicacionOriginal = buscar(publicacion.getIdPublicacion());
			
		/*
		 * 2. Valida que se haya ingresado un título.
		 */  
			if(Objects.isNull(publicacion.getTitulo()) || Objects.equals("", publicacion.getTitulo()))
				throw new InformationRequiredException("Debe ingresar un Título.");
		
		/*
		 * 3. Carga autor y la fecha de la publicación.
		 */
			publicacion.setAutor(publicacionOriginal.getAutor());
			publicacion.setFechaDePublicacion(publicacionOriginal.getFechaDePublicacion());
			
		/*
		 * 4. Valida que se haya ingresado una descripción.
		 */  
			if(Objects.isNull(publicacion.getDescripcion()) || Objects.equals("", publicacion.getDescripcion()))
				throw new InformationRequiredException("Debe ingresar una Descripción.");

		/*
		 * 5. Actualiza la publicación.
		 */ 
			publicacionRepository.save(publicacion);

		return true;
		
	}
	
	public boolean borrar(long idPublicacion) throws InformationRequiredException, EntityNotFoundException {

		/*
		 * 1. Valida que la publicación exista.
		 */ 
			Publicacion publicacion = buscar(idPublicacion);
		
		/*
		 * 2. Borra la publicación.
		 */ 		
			publicacionRepository.delete(publicacion);

		return true;
		
	}
	
	public List<Publicacion> obtener(){
		return publicacionRepository.findAll();
	}
		
	public boolean meGusta(long idPublicacion) throws InformationRequiredException, EntityNotFoundException {
		
		/*
		 * 1. Valida que la publicación exista.
		 */ 
			Publicacion publicacion = buscar(idPublicacion);
		
		/*
		 * 2. Aumenta en 1 unidad la cantidad de me gusta.
		 */ 
			publicacion.setMeGusta(publicacion.getMeGusta() + 1);

		/*
		 * 3. Actualiza la publicación.
		 */ 			
			publicacionRepository.save(publicacion);
		
		return true;
	}
	
	public Publicacion buscar(long idPublicacion) throws InformationRequiredException, EntityNotFoundException {
		
		if (Objects.isNull(idPublicacion) || idPublicacion == 0)
			throw new InformationRequiredException("Debe ingresar el ID de Publicación válido"); 
		
		if(publicacionRepository.findByIdPublicacion(idPublicacion) == null) 
			throw new EntityNotFoundException("No fue posible retornar la publicación ya que la publicación no fue encontrada.");

			return publicacionRepository.findByIdPublicacion(idPublicacion);
	}
}
