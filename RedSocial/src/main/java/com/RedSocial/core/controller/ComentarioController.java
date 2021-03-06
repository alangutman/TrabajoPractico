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

import com.RedSocial.core.entity.Comentario;
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.service.ComentarioService;

@RestController
@RequestMapping("/RedSocial")
public class ComentarioController {

	@Autowired
	@Qualifier("ComentarioService")
	ComentarioService comentarioService;
	
	@PutMapping("/comentario")
	public ResponseEntity<Object> crear(@RequestBody @Validated Comentario comentario) {
	
		try {			
			comentarioService.crear(comentario);
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
				.body("Comentario creado exitosamente.");
		
	}
	
	@PostMapping("/comentario")
	public ResponseEntity<Object> actualizar(@RequestBody @Validated Comentario comentario) {
		
		try {
			comentarioService.actualizar(comentario);		
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
				.body("Comentario actualizado exitosamente.");
		
	}
	
	@DeleteMapping("/comentario/{idComentario}")
	public ResponseEntity<Object> borrar(@PathVariable("idComentario") long idComentario) {
	
		try {
			comentarioService.borrar(idComentario);	
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
				.body("Comentario borrado exitosamente.");
	}
	
	@GetMapping("/comentario")
	public ResponseEntity<Object> obtener(){

		try {
			List<Comentario> comentarios = comentarioService.obtener();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(comentarios);
		}
		catch(EmptyListException e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(e.getMessage());
		}
		
	}
	
	@PostMapping("/comentario/meGusta/{idComentario}")
	public ResponseEntity<Object> meGusta(@PathVariable("idComentario") long idComentario) {
		
		try {
			comentarioService.meGusta(idComentario);	
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

	@GetMapping("/comentario/{idComentario}")
	public ResponseEntity<Object> buscar(@PathVariable("idComentario") long idComentario) {
		try {
			Comentario comentario = comentarioService.buscar(idComentario);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(comentario);
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
	
}
