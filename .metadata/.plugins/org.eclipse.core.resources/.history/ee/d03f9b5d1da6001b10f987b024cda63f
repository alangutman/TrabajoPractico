package com.RedSocial.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.RedSocial.core.entity.Foto;
import com.RedSocial.core.model.FotoModel;

@Component("FotoConverter")
public class FotoConverter {
	public List<FotoModel> convertir(List<Foto> fotos){
		
		List<FotoModel> fotosModel = new ArrayList<>();
		
		for(Foto foto : fotos)
			fotosModel.add(new FotoModel(foto));
		
		return fotosModel;
	}
}
