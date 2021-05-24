package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.Exception.EntityAlreadyExistsException;
import com.RedSocial.core.Exception.EntityNotFoundException;
import com.RedSocial.core.Exception.InformationRequiredException;
import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.repository.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService {
	
	@Autowired
	@Qualifier("UsuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	public boolean crear(Usuario usuario) throws EntityAlreadyExistsException {

			if(usuarioRepository.findByApodo(usuario.getApodo()) != null) 
				throw new EntityAlreadyExistsException("No fue posible crear el usuario ya que el alias de usuario ya está en uso.");
			
			if(Objects.isNull(usuario.getApodo()))
				throw new InformationRequiredException("Debe ingresar un Apodo.");
	
			if(Objects.isNull(usuario.getEmail()))
				throw new InformationRequiredException("Debe ingresar un Email.");
			
			if(Objects.isNull(usuario.getContrasenia()))
				throw new InformationRequiredException("Debe ingresar una Contraseña.");
			
			usuarioRepository.save(usuario);
			
			return true;
	}
		
	public boolean actualizar(Usuario usuario) throws InformationRequiredException, EntityNotFoundException {
			
			if (Objects.isNull(usuario.getIdUsuario()))
				throw new InformationRequiredException("Debe ingresar el ID de usuario a actualizar"); 
			
			if(usuarioRepository.findByIdUsuario(usuario.getIdUsuario()) == null) 
				throw new EntityNotFoundException("No fue posible actualizar el usuario ya que el usuario no fue encontrado.");
			
			usuarioRepository.save(usuario);
			
			return true;
	}
	
	public boolean borrar(long idUsuario) throws InformationRequiredException, EntityNotFoundException {

		if (Objects.isNull(idUsuario) || idUsuario == 0)
			throw new InformationRequiredException("Debe ingresar el ID de usuario a eliminar"); 
		
		if(usuarioRepository.findByIdUsuario(idUsuario) == null) 
			throw new EntityNotFoundException("No fue posible eliminar el usuario ya que el usuario no fue encontrado.");

			Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);
			usuarioRepository.delete(usuario);
	
			return true;
	}
	
	public Usuario buscar(long idUsuario) throws InformationRequiredException, EntityNotFoundException {
		
		if (Objects.isNull(idUsuario) || idUsuario == 0)
			throw new InformationRequiredException("Debe ingresar el ID de usuario válido"); 
		
		if(usuarioRepository.findByIdUsuario(idUsuario) == null) 
			throw new EntityNotFoundException("No fue posible retornar el usuario ya que el usuario no fue encontrado.");

			return usuarioRepository.findByIdUsuario(idUsuario);
	}
	
	public List<Usuario> obtener(){
		return usuarioRepository.findAll();
	}

}
