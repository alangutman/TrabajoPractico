package com.RedSocial.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.model.UsuarioModel;
import com.RedSocial.core.service.UsuarioService;

@RestController
@RequestMapping("/RedSocial")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioService")
	UsuarioService usuarioService;
	
	@PutMapping("/usuario")
	public boolean crear(@RequestBody @Validated Usuario usuario) {
		return usuarioService.crear(usuario);
	}
	
	@PostMapping("/usuario")
	public boolean actualizar(@RequestBody @Validated Usuario usuario) {
		return usuarioService.actualizar(usuario);
	}
	
	@DeleteMapping("/usuario/{idUsuario}")
	public boolean borrar(@PathVariable("idUsuario") long idUsuario) {
		return usuarioService.borrar(idUsuario);
	}
	
	@GetMapping("/usuario")
	public List<UsuarioModel> obtener(){
		return usuarioService.obtener();
	}
}