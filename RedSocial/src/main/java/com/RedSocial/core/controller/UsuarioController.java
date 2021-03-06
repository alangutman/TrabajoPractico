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

import com.RedSocial.core.entity.Usuario;
import com.RedSocial.core.exception.EmptyListException;
import com.RedSocial.core.exception.EntityAlreadyExistsException;
import com.RedSocial.core.exception.EntityNotFoundException;
import com.RedSocial.core.exception.InformationRequiredException;
import com.RedSocial.core.service.UsuarioService;

@RestController
@RequestMapping("/RedSocial")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioService")
	UsuarioService usuarioService;
	
	@PutMapping("/usuario")
	public ResponseEntity<Object> crear(@RequestBody @Validated Usuario usuario) {
	
		try {			
			usuarioService.crear(usuario);
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
				.body("Usuario creado exitosamente.");
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Object> actualizar(@RequestBody @Validated Usuario usuario) {
		try {
			usuarioService.actualizar(usuario);			
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
				.body("Usuario actualizado exitosamente.");
	}
	
	@DeleteMapping("/usuario/{idUsuario}")
	public ResponseEntity<Object> borrar(@PathVariable("idUsuario") long idUsuario) {
		try {
			usuarioService.borrar(idUsuario);			
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
				.body("Usuario borrado exitosamente.");
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<Object> buscar(@PathVariable("idUsuario") long idUsuario) {
		try {
			Usuario usuario = usuarioService.buscar(idUsuario);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(usuario);
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
	
	
	@GetMapping("/usuario")
	public ResponseEntity<Object> obtener(){

		try {
			List<Usuario> usuarios = usuarioService.obtener();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(usuarios);
		}
		catch(EmptyListException e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(e.getMessage());
		}
		
	}
}
