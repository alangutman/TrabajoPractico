package com.RedSocial.core.converter;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.model.UsuarioModel;

@Component("UsuarioConverter")
public class UsuarioConverter {
	public List<UsuarioModel> convertir(List<Usuario> usuarios){
		
		List<UsuarioModel> usuariosModel = new ArrayList<>();
		
		for(Usuario usuario : usuarios)
			usuariosModel.add(new UsuarioModel(usuario));
		
		return usuariosModel;
	}
}
