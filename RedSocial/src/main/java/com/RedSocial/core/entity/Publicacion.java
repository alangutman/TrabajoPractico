package com.RedSocial.core.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Publicacion")
@Entity
public class Publicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Publicacion() {
		
	}
	
	public Publicacion(long idPublicacion, String titulo, Date fechaDePublicacion, String descripcion, int meGusta, Usuario autor) {
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.fechaDePublicacion = fechaDePublicacion;
		this.descripcion = descripcion;
		this.meGusta = meGusta;
		this.autor = autor;
	}

	@GeneratedValue
	@Id
	@Column(name="idPublicacion")
	private long idPublicacion;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fechaDePublicacion")
	private Date fechaDePublicacion;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="meGusta")
	private int meGusta;

	@ManyToOne
	private Usuario autor; 
	
	public long getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(long idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaDePublicacion() {
		return fechaDePublicacion;
	}

	public void setFechaDePublicacion(Date fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
}
