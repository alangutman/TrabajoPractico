package com.RedSocial.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="Usuario")
@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario() {
		
	}
	
	public Usuario(long idUsuario, String apodo, String email, String contrasenia, List<Publicacion> publicaciones) {
		super();
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.email = email;
		this.contrasenia = contrasenia;
		this.publicaciones = publicaciones;
	}

	@GeneratedValue
	@Id
	@Column(name="idUsuario")
	private long idUsuario;
	
	@Column(name="apodo")
	private String apodo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contrasenia")
	private String contrasenia;

	@OneToMany(mappedBy = "autor")
	@JsonIgnore
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
