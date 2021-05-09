package com.RedSocial.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.repository.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService {
	@Autowired
	@Qualifier("UsuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	public boolean crear(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
	public boolean actualizar(Usuario usuario) {
		try {
			if (usuario.getIdUsuario() == 0 || Objects.isNull(usuario.getIdUsuario()))
				return false; 
			
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(long idUsuario) {
		try {
			Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);
			usuarioRepository.delete(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<Usuario> obtener(){
		return usuarioRepository.findAll();
	}

}
