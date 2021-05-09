package com.RedSocial.core.model;

import java.sql.Date;

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.entity.Usuario;

public class ComentarioModel {

	public ComentarioModel() {
		
	}
	
	public ComentarioModel(long idComentario, Date fechaDePublicacion, String comentario, int meGusta, Usuario autor, Publicacion publicacion) {
		super();
		this.idComentario = idComentario;
		this.fechaDePublicacion = fechaDePublicacion;
		this.comentario = comentario;
		this.meGusta = meGusta;
		this.autor = autor;
		this.publicacion = publicacion;
	}
	
	public ComentarioModel(Comentario comentario) {
		super();
		this.idComentario = comentario.getIdComentario();
		this.fechaDePublicacion = comentario.getFechaDePublicacion();
		this.comentario = comentario.getComentario();
		this.meGusta = comentario.getMeGusta();
		this.autor = comentario.getAutor();
		this.publicacion = comentario.getPublicacion();
	}
	
	private long idComentario;
	private Date fechaDePublicacion;
	private String comentario;
	private int meGusta;
	private Usuario autor;
	private Publicacion publicacion;
	
	public long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}
	public Date getFechaDePublicacion() {
		return fechaDePublicacion;
	}
	public void setFechaDePublicacion(Date fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getMeGusta() {
		return meGusta;
	}
	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
}