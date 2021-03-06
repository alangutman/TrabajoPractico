package com.RedSocial.core.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Publicacion")
@JsonIgnoreProperties()
public class Publicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Publicacion() {
		
	}
	
	public Publicacion(long idPublicacion, String titulo, Date fechaDePublicacion, Date fechaDeUltimaActualizacion,
			String descripcion, int meGusta, Usuario autor, List<Foto> fotos, List<Comentario> comentarios) {
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.fechaDePublicacion = fechaDePublicacion;
		this.fechaDeUltimaActualizacion = fechaDeUltimaActualizacion;  
		this.descripcion = descripcion;
		this.meGusta = meGusta;
		this.autor = autor;
		this.fotos = fotos;
		this.comentarios = comentarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPublicacion")
	private long idPublicacion;
	
	@Column(name="titulo")
	private String titulo;
	
    @CreationTimestamp
    @Column(name="fechaDePublicacion")
	private Date fechaDePublicacion;
    
    @UpdateTimestamp
    @Column(name="fechaDeUltimaActualizacion")
	private Date fechaDeUltimaActualizacion;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="meGusta")
	private int meGusta;

	@ManyToOne()
	private Usuario autor; 

	@OneToMany(cascade = CascadeType.ALL, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "id_publicacion", referencedColumnName = "idPublicacion")
	private List<Foto> fotos = new ArrayList<>(); 
	
	@OneToMany(cascade = CascadeType.ALL, 
			   fetch = FetchType.EAGER, 
			   mappedBy = "publicacion")
	@OrderColumn(name = "idComentario")
	@JsonIgnoreProperties("publicacion")
	private List<Comentario> comentarios = new ArrayList<>(); 
	
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
	
	public Date getFechaDeUltimaActualizacion() {
		return fechaDeUltimaActualizacion;
	}

	public void setFechaDeUltimaActualizacion(Date fechaDeUltimaActualizacion) {
		this.fechaDeUltimaActualizacion = fechaDeUltimaActualizacion;
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

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}