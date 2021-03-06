package com.RedSocial.core.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.PROPERTY,
        property="tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value=Sugerencia.class, name= "sugerencia"),
        @JsonSubTypes.Type(value=Reaccion.class, name= "reaccion"),
        @JsonSubTypes.Type(value=Reclamo.class, name= "reclamo")
})
@Entity
@Table(name="Comentario")
public abstract class Comentario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Comentario() {
		super();
	}

	public Comentario(long idComentario, Date fechaDePublicacion, Date fechaDeUltimaActualizacion, 
			String comentario, int meGusta, Usuario autor, Publicacion publicacion) {
		super();
		this.idComentario = idComentario;
		this.fechaDePublicacion = fechaDePublicacion;
		this.fechaDeUltimaActualizacion = fechaDeUltimaActualizacion; 
		this.comentario = comentario;
		this.meGusta = meGusta;
		this.autor = autor;
		this.publicacion = publicacion;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idComentario")
	private long idComentario;
	
	@CreationTimestamp
	@Column(name="fechaDePublicacion")
	private Date fechaDePublicacion;
	
    @UpdateTimestamp
    @Column(name="fechaDeUltimaActualizacion")
	private Date fechaDeUltimaActualizacion;
		
	@Column(name="comentario")
	private String comentario;

	@Column(name="meGusta")
	private int meGusta;

	@ManyToOne()
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_publicacion", nullable = false)
	@JsonIgnoreProperties("comentarios")
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
	
	
	public Date getFechaDeUltimaActualizacion() {
		return fechaDeUltimaActualizacion;
	}

	
	public void setFechaDeUltimaActualizacion(Date fechaDeUltimaActualizacion) {
		this.fechaDeUltimaActualizacion = fechaDeUltimaActualizacion;
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

	public abstract void mostrar();
}