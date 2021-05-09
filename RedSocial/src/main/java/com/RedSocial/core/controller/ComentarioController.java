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

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.service.ComentarioService;

@RestController
@RequestMapping("/RedSocial")
public class ComentarioController {

	@Autowired
	@Qualifier("ComentarioService")
	ComentarioService comentarioService;
	
	@PutMapping("/comentario")
	public boolean crear(@RequestBody @Validated Comentario comentario) {
		return comentarioService.crear(comentario);
	}
	
	@PostMapping("/comentario")
	public boolean actualizar(@RequestBody @Validated Comentario comentario) {
		return comentarioService.actualizar(comentario);
	}
	
	@DeleteMapping("/comentario/{idComentario}")
	public boolean borrar(@PathVariable("idComentario") long idComentario) {
		return comentarioService.borrar(idComentario);
	}
	
	@GetMapping("/comentario")
	public List<Comentario> obtener(){
		return comentarioService.obtener();
	}
	
	@PostMapping("/comentario/meGusta/{idComentario}")
	public boolean meGusta(@PathVariable("idComentario") long idComentario) {
		return comentarioService.meGusta(idComentario);
	}
}
