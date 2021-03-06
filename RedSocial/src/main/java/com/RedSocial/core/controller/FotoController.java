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

import com.RedSocial.core.entity.Foto;
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityAlreadyExistsException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.service.FotoService;

@RestController
@RequestMapping("/RedSocial")
public class FotoController {

	@Autowired
	@Qualifier("FotoService")
	FotoService fotoService;
	
	@PutMapping("/foto")
	public ResponseEntity<Object> crear(@RequestBody @Validated Foto foto) {
		
		try {			
			fotoService.crear(foto);
		}
		catch(EntityAlreadyExistsException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		catch(InformationRequiredException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Foto creada exitosamente.");
	}
	
	@PostMapping("/foto")
	public ResponseEntity<Object> actualizar(@RequestBody @Validated Foto foto) {

		try {
			fotoService.actualizar(foto);			
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
				.body("Foto actualizada exitosamente.");
	}
	
	@DeleteMapping("/foto/{idFoto}")
	public ResponseEntity<Object> borrar(@PathVariable("idFoto") long idFoto) {
	
		try {
			fotoService.borrar(idFoto);			
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
				.body("Foto borrada exitosamente.");
	}
	
	@GetMapping("/foto/{idFoto}")
	public ResponseEntity<Object> buscar(@PathVariable("idFoto") long idFoto) {
		try {
			Foto foto = fotoService.buscar(idFoto);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(foto);
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
	
	@GetMapping("/foto")
	public ResponseEntity<Object> obtener(){
	
		try {
			List<Foto> fotos = fotoService.obtener();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(fotos);
		}
		catch(EmptyListException e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(e.getMessage());
		}

	}
}
