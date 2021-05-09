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

import com.RedSocial.core.entity.Foto;
import com.RedSocial.core.service.FotoService;

@RestController
@RequestMapping("/RedSocial")
public class FotoController {

	@Autowired
	@Qualifier("FotoService")
	FotoService fotoService;
	
	@PutMapping("/foto")
	public boolean crear(@RequestBody @Validated Foto foto) {
		return fotoService.crear(foto);
	}
	
	@PostMapping("/foto")
	public boolean actualizar(@RequestBody @Validated Foto foto) {
		return fotoService.actualizar(foto);
	}
	
	@DeleteMapping("/foto/{idFoto}")
	public boolean borrar(@PathVariable("idFoto") long idFoto) {
		return fotoService.borrar(idFoto);
	}
	
	@GetMapping("/foto")
	public List<Foto> obtener(){
		return fotoService.obtener();
	}
}
