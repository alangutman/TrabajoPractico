package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.exception.EmptyListException;
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
	
	public void crear(Comentario comentario) throws InformationRequiredException, EntityNotFoundException  {

		/*
		 * 1. Valida que se haya ingresado un comentario.
		 */
			validar(comentario);
			
		/*
		 * 2. Valida que el autor sea válido.
		 */
			Usuario autor = usuarioService.buscar(comentario.getAutor().getIdUsuario());	
	
		/*
		 * 3. Setea al autor del comentario.
		 */
			comentario.setAutor(autor);
		
		/*
		 * 4. Valida que la publicación sea válida.
		 */
			Publicacion publicacion = publicacionService.buscar(comentario.getPublicacion().getIdPublicacion());
		
		/*
		 * 5. Setea la publicación del comentario.
		 */
			comentario.setPublicacion(publicacion);
		
		/*
		 * 6. Crea el comentario.
		 */
			comentarioRepository.save(comentario);
		
	}
		
	public void actualizar(Comentario comentario) throws InformationRequiredException, EntityNotFoundException {

		/*
		 * 1. Valida que el comentario exista.
		 */
			Comentario comentarioOriginal =	buscar(comentario.getIdComentario());
		
		/*
		 * 2. Valida que se haya ingresado un comentario.
		 */
			validar(comentario);
			
		/*
		 * 3. Carga autor, publicación y fecha de publicación del comentario.
		 */
			comentario.setAutor(comentarioOriginal.getAutor());
			comentario.setPublicacion(comentarioOriginal.getPublicacion());
			comentario.setFechaDePublicacion(comentarioOriginal.getFechaDePublicacion());
			
		/*
		 * 4. Actualiza el comentario.
		 */
			comentarioRepository.save(comentario);

	}
	
	public void borrar(long idComentario) throws InformationRequiredException, EntityNotFoundException {
		
		/*
		 * 1. Valida que el comentario exista.
		 */
		Comentario comentario =	buscar(idComentario);
			
		/*
		 * 2. Borra el comentario.
		 */
		comentarioRepository.delete(comentario);
		
	}
	
	public List<Comentario> obtener() throws EmptyListException {
		
		List<Comentario> comentarios = comentarioRepository.findAll();
		
		if (comentarios.isEmpty())
			throw new EmptyListException("No hay comentarios registrados para mostrar");
		
		return comentarios;
	}

	public void meGusta(long idComentario) {
	
			/*
			 * 1. Valida que el comentario exista.
			 */
				Comentario comentario =	buscar(idComentario);
			
			/*
			 * 2. Aumenta en 1 unidad la cantidad de me gusta.
			 */ 
				comentario.setMeGusta(comentario.getMeGusta() + 1);
	
			/*
			 * 3. Actualiza el comentario.
			 */
				comentarioRepository.save(comentario);

	}
	
	public Comentario buscar(long idComentario) throws InformationRequiredException, EntityNotFoundException {
		
			if (Objects.isNull(idComentario) || idComentario == 0)
				throw new InformationRequiredException("Debe ingresar el ID de Comentario válido"); 
			
			if(comentarioRepository.findByIdComentario(idComentario) == null) 
				throw new EntityNotFoundException("No fue posible retornar el comentario ya que el comentario no fue encontrado.");
	
		return comentarioRepository.findByIdComentario(idComentario);
	}
	
	public void validar(Comentario comentario) throws InformationRequiredException {
	
		if(Objects.isNull(comentario.getComentario()) || Objects.equals("", comentario.getComentario()))
			throw new InformationRequiredException("Debe ingresar un comentario.");

	}
	
}
