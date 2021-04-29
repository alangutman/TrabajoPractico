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

import com.RedSocial.core.entity.Publicacion;
import com.RedSocial.core.model.PublicacionModel;
import com.RedSocial.core.service.PublicacionService;

@RestController
@RequestMapping("/RedSocial")
public class PublicacionController {

	@Autowired
	@Qualifier("PublicacionService")
	PublicacionService publicacionService;
	
	@PutMapping("/publicacion")
	public boolean crear(@RequestBody @Validated Publicacion publicacion) {
		return publicacionService.crear(publicacion);
	}
	
	@PostMapping("/publicacion")
	public boolean actualizar(@RequestBody @Validated Publicacion publicacion) {
		return publicacionService.actualizar(publicacion);
	}
	
	@DeleteMapping("/publicacion/{idPublicacion}")
	public boolean borrar(@PathVariable("idPublicacion") long idPublicacion) {
		return publicacionService.borrar(idPublicacion);
	}
	
	@GetMapping("/publicacion")
	public List<PublicacionModel> obtener(){
		return publicacionService.obtener();
	}
}
