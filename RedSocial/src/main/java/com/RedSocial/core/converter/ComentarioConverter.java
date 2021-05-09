package com.RedSocial.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.model.ComentarioModel;

@Component("ComentarioConverter")
public class ComentarioConverter {
	public List<ComentarioModel> convertir(List<Comentario> comentarios){
		
		List<ComentarioModel> comentariosModel = new ArrayList<>();
		
		for(Comentario comentario : comentarios)
			comentariosModel.add(new ComentarioModel(comentario));
		
		return comentariosModel;
	}
}
