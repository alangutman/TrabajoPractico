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
		
		if(Objects.isNull(publicacion.getTitulo()))
			throw new InformationRequiredException("Debe ingresar un Título.");
		
		if(Objects.isNull(publicacion.getDescripcion()))
			throw new InformationRequiredException("Debe ingresar una Descripción.");
		
		Usuario autor = usuarioService.buscar(publicacion.getAutor().getIdUsuario());	
		publicacion.setAutor(autor);
		
		publicacionRepository.save(publicacion);
		
		return true;

	}
		
	public boolean actualizar(Publicacion publicacion) throws InformationRequiredException, EntityNotFoundException {

		if (Objects.isNull(publicacion.getIdPublicacion()))
			throw new InformationRequiredException("Debe ingresar el ID de la publicación a actualizar"); 
		
		if(publicacionRepository.findByIdPublicacion(publicacion.getIdPublicacion()) == null) 
			throw new EntityNotFoundException("No fue posible actualizar la publicación ya que la publicación no fue encontrada.");
			
		if(Objects.isNull(publicacion.getTitulo()))
			throw new InformationRequiredException("Debe ingresar un Título.");
		
		if(Objects.isNull(publicacion.getDescripcion()))
			throw new InformationRequiredException("Debe ingresar una Descripción.");
		
		publicacionRepository.save(publicacion);

		return true;

	}
	
	public boolean borrar(long idPublicacion) throws InformationRequiredException, EntityNotFoundException {

		if (Objects.isNull(idPublicacion) || idPublicacion == 0)
			throw new InformationRequiredException("Debe ingresar el ID de la publicación a borrar"); 
		
		if(publicacionRepository.findByIdPublicacion(idPublicacion) == null) 
			throw new EntityNotFoundException("No fue posible borrar la publicación ya que la publicación no fue encontrada.");		
		
		Publicacion publicacion = publicacionRepository.findByIdPublicacion(idPublicacion);
		publicacionRepository.delete(publicacion);

		return true;
		
	}
	
	public List<Publicacion> obtener(){
		return publicacionRepository.findAll();
	}
		
	public boolean meGusta(long idPublicacion) throws InformationRequiredException, EntityNotFoundException {
		
		if (Objects.isNull(idPublicacion) || idPublicacion == 0)
			throw new InformationRequiredException("Debe ingresar el ID de la publicación sobre la que quiere dar me gusta."); 
		
		if(publicacionRepository.findByIdPublicacion(idPublicacion) == null) 
			throw new EntityNotFoundException("No fue posible dar me gusta a la publicación ya que la publicación no fue encontrada.");
		
		Publicacion publicacion = publicacionRepository.findByIdPublicacion(idPublicacion);
		publicacion.setMeGusta(publicacion.getMeGusta() + 1);

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
