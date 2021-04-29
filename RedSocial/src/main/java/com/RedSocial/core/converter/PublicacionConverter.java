package com.RedSocial.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.model.PublicacionModel;

@Component("PublicacionConverter")
public class PublicacionConverter {
	public List<PublicacionModel> convertir(List<Publicacion> publicaciones){
			
			List<PublicacionModel> publicacionesModel = new ArrayList<>();
			
			for(Publicacion publicacion : publicaciones)
				publicacionesModel.add(new PublicacionModel(publicacion));
			
			return publicacionesModel;
		}
}
