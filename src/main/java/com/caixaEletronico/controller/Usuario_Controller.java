package com.caixaEletronico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caixaEletronico.model.Usuario;
import com.caixaEletronico.repository.Usuario_Repository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class Usuario_Controller {
	
	@Autowired
	private Usuario_Repository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomeCompleto}")
	public ResponseEntity<List<Usuario>> GetByName(@PathVariable String nomeCompleto){
		return ResponseEntity.ok(repository.findByNomeCompletoContainingIgnoreCase(nomeCompleto));
	}
	
	@PostMapping(value="/cadastrar")
	public ResponseEntity<Usuario> Post (@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
}
