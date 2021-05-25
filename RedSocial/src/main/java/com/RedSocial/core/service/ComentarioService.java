package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.repository.ComentarioRepository;

@Service("ComentarioService")
public class ComentarioService {

	@Autowired
	@Qualifier("ComentarioRepository")
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	@Qualifier("UsuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("PublicacionService")
	private PublicacionService publicacionService;
	
	public boolean crear(Comentario comentario) throws InformationRequiredException, EntityNotFoundException  {

		if(Objects.isNull(comentario.getComentario()) || Objects.equals("", comentario.getComentario()))
			throw new InformationRequiredException("Debe ingresar un comentario.");
		
		Usuario autor = usuarioService.buscar(comentario.getAutor().getIdUsuario());	
		comentario.setAutor(autor);
		
		Publicacion publicacion = publicacionService.buscar(comentario.getPublicacion().getIdPublicacion());
		comentario.setPublicacion(publicacion);
		
		comentarioRepository.save(comentario);
		
		return true;

	}
		
	public boolean actualizar(Comentario comentario) throws InformationRequiredException, EntityNotFoundException {

		if (Objects.isNull(comentario.getIdComentario()))
			throw new InformationRequiredException("Debe ingresar el ID del comentario a actualizar"); 
		
		if(comentarioRepository.findByIdComentario(comentario.getIdComentario()) == null) 
			throw new EntityNotFoundException("No fue posible actualizar el comentario ya que el comentario no fue encontrado.");
		
		if(Objects.isNull(comentario.getComentario()) || Objects.equals(comentario.getComentario(), ""))
			throw new InformationRequiredException("Debe ingresar un comentario");
			
		comentarioRepository.save(comentario);
		
		return true;

	}
	
	public boolean borrar(long idComentario) throws InformationRequiredException, EntityNotFoundException {
		
		if (Objects.isNull(idComentario) || idComentario == 0)
			throw new InformationRequiredException("Debe ingresar el ID del comentario a borrar"); 
		
		if(comentarioRepository.findByIdComentario(idComentario) == null) 
			throw new EntityNotFoundException("No fue posible borrar el comentario ya que el comentario no fue encontrado.");		

		Comentario comentario = comentarioRepository.findByIdComentario(idComentario);
		
		comentarioRepository.delete(comentario);
		
		return true;

	}
	
	public List<Comentario> obtener(){
		return comentarioRepository.findAll();
	}

	public boolean meGusta(long idComentario) {
	
		if (Objects.isNull(idComentario) || idComentario == 0)
			throw new InformationRequiredException("Debe ingresar el ID del comentario sobre la que quiere dar me gusta."); 
		
		if(comentarioRepository.findByIdComentario(idComentario) == null) 
			throw new EntityNotFoundException("No fue posible dar me gusta al comentario ya que el comentario no fue encontrado.");
		
		Comentario comentario = comentarioRepository.findByIdComentario(idComentario);
		comentario.setMeGusta(comentario.getMeGusta() + 1);

		comentarioRepository.save(comentario);
		
		return true;

	}
}
