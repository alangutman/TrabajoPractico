package com.RedSocial.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.service.PublicacionService;

@RestController
@RequestMapping("/RedSocial")
public class PublicacionController {

	@Autowired
	@Qualifier("PublicacionService")
	PublicacionService publicacionService;
	
	@PutMapping("/publicacion")
	public ResponseEntity<Object> crear(@RequestBody @Validated Publicacion publicacion) {

		try {			
			publicacionService.crear(publicacion);
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Publicación creada exitosamente."); 
	}
	
	@PostMapping("/publicacion")
	public ResponseEntity<Object> actualizar(@RequestBody @Validated Publicacion publicacion) {
	
		try {
			publicacionService.actualizar(publicacion);			
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Publicación actualizada exitosamente.");
		
	}
	
	@DeleteMapping("/publicacion/{idPublicacion}")
	public ResponseEntity<Object> borrar(@PathVariable("idPublicacion") long idPublicacion) {
		
		try {
			publicacionService.borrar(idPublicacion);			
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Publicación borrada exitosamente.");
	}
	
	@GetMapping("/publicacion/{idPublicacion}")
	public ResponseEntity<Object> buscar(@PathVariable("idPublicacion") long idPublicacion) {
		try {
			Publicacion publicacion = publicacionService.buscar(idPublicacion);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(publicacion);
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}

	}
	
	@GetMapping("/publicacion")
	public ResponseEntity<Object> obtener(){

		try {
			List<Publicacion> publicaciones = publicacionService.obtener();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(publicaciones);
		}
		catch(EmptyListException e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(e.getMessage());
		}
		
	}
	
	@PostMapping("/publicacion/meGusta/{idPublicacion}")
	public ResponseEntity<Object> meGusta(@PathVariable("idPublicacion") long idPublicacion) {
		
		try {
			publicacionService.meGusta(idPublicacion);			
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(EntityNotFoundException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Me gusta dato exitosamente.");
	}
}
