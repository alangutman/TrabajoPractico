package com.RedSocial.core.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("reaccion")
@Entity
public class Reaccion extends Comentario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Soy una reacción");
	}

}
