package com.RedSocial.core.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("JPG")
@Entity
public class FotoJpg extends Foto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Soy una foto JPG");
	}

}
