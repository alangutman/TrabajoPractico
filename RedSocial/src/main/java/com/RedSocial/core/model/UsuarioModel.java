package com.RedSocial.core.model;

import java.util.List;

import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.entity.Usuario;

public class UsuarioModel {

	public UsuarioModel(){
		
	}

	public UsuarioModel(Usuario usuario){
		this.idUsuario = usuario.getIdUsuario();
		this.apodo = usuario.getApodo();
		this.email = usuario.getEmail();
		this.contrasenia = usuario.getContrasenia();
		this.publicaciones = usuario.getPublicaciones();
	}
	
	public UsuarioModel(long idUsuario, String apodo, String email, String contrasenia, List<Publicacion> publicaciones) {
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.email = email;
		this.contrasenia = contrasenia;
		this.publicaciones = publicaciones;
	}
	
	private long idUsuario;
	private String apodo;
	private String email;
	private String contrasenia;
	private List<Publicacion> publicaciones;
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
}
