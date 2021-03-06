package com.RedSocial.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.PROPERTY,
        property="formato"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value=FotoJpg.class, name= "JPG")
})
@Entity
@Table(name="Foto")
public abstract class Foto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Foto() {
		super();
	}

	public Foto(long idFoto, String nombre, String ubicacion) {
		super();
		this.idFoto = idFoto;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idFoto")
	private long idFoto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ubicacion")
	private String ubicacion;
		
	public long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
		
	public abstract void mostrar();
}
