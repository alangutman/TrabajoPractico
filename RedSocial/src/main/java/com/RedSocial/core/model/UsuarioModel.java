package com.RedSocial.core.model;

import com.RedSocial.core.entity.Usuario;

public class UsuarioModel {

	public UsuarioModel(){
		
	}

	public UsuarioModel(Usuario usuario){
		this.idUsuario = usuario.getIdUsuario();
		this.apodo = usuario.getApodo();
		this.email = usuario.getEmail();
		this.contrasenia = usuario.getContrasenia();
	}
	
	public UsuarioModel(long idUsuario, String apodo, String email, String contrasenia) {
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	private long idUsuario;
	private String apodo;
	private String email;
	private String contrasenia;
	
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
		
}
