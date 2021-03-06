package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityAlreadyExistsException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.repository.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService {
	
	@Autowired
	@Qualifier("UsuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	public boolean crear(Usuario usuario) throws EntityAlreadyExistsException {

		/*
		 * 1. Valida que el usuario no exista.
		 */ 
			if(usuarioRepository.findByApodo(usuario.getApodo()) != null) 
				throw new EntityAlreadyExistsException("No fue posible crear el usuario ya que el alias de usuario ya está en uso.");
			
		/*
		 * 2. Valida que se hayan completado los datos.
		 */
			validar(usuario);
		
		/*
		 * 3. Crea el usuario.
		 */ 
			usuarioRepository.save(usuario);
			
		return true;
	}
		
	public boolean actualizar(Usuario usuario) throws InformationRequiredException, EntityNotFoundException {
			
			/*
			 * 1. Valida que el usuario exista.
			 */ 
				buscar(usuario.getIdUsuario());

			/*
			 * 2. Actualiza el usuario.
			 */ 
			usuarioRepository.save(usuario);
			
		return true;
	}
	
	public boolean borrar(long idUsuario) throws InformationRequiredException, EntityNotFoundException {

		/*
		 * 1. Valida que el usuario exista.
		 */  
			Usuario usuario = buscar(idUsuario);
			
		/*
		 * 2. Borra el usuario.
		 */ 
			usuarioRepository.delete(usuario);
	
		return true;
	}
	
	public Usuario buscar(long idUsuario) throws InformationRequiredException, EntityNotFoundException {
		
		/*
		 * 1. Valida que se haya ingresado un ID para buscar al usuario.
		 */  
			if (Objects.isNull(idUsuario) || idUsuario == 0)
				throw new InformationRequiredException("Debe ingresar un ID de usuario válido"); 
		
		/*
		 * 2. Valida que el usuario exista.
		 */  
			if(usuarioRepository.findByIdUsuario(idUsuario) == null) 
				throw new EntityNotFoundException("No fue posible retornar el usuario ya que el usuario no fue encontrado.");

		return usuarioRepository.findByIdUsuario(idUsuario);
	}
	
	public List<Usuario> obtener() throws EmptyListException {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		if (usuarios.isEmpty())
			throw new EmptyListException("No hay usuarios registrados para mostrar");
		
		return usuarios;
	}
	
	public void validar(Usuario usuario) throws InformationRequiredException {

		/*
		 * 1. Valida que se haya ingresado un apodo.
		 */ 
			if(Objects.isNull(usuario.getApodo()))
				throw new InformationRequiredException("Debe ingresar un Apodo.");

		/*
		 * 2. Valida que se haya ingresado un email.
		 */ 
			if(Objects.isNull(usuario.getEmail()))
				throw new InformationRequiredException("Debe ingresar un Email.");
			
		/*
		 * 3. Valida que se haya ingresado una contraseña.
		 */ 
			if(Objects.isNull(usuario.getContrasenia()))
				throw new InformationRequiredException("Debe ingresar una Contraseña.");
		
	}

}
