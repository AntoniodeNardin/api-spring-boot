package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	public UserController() {
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody User user) {
		if (repository.existsByEmail(user.getEmail())) {
			// Retorna um erro com uma mensagem personalizada
			return ResponseEntity
					.badRequest()
					.body("Email já está em uso. Por favor, utilize um email diferente.");
		}
		User savedUser = repository.save(user);
		return ResponseEntity.ok(savedUser);
	}

	// READ: Listar todos os usuários
	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	// READ: Encontrar um usuário pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> user = repository.findById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		// Verificar se o email já está em uso por outro usuário
		if (repository.existsByEmailAndIdNot(user.getEmail(), id)) {
			return ResponseEntity
					.badRequest()
					.body("O email já está em uso por outro usuário. Por favor, utilize um email diferente.");
		}

		user.setId(id);
		User updatedUser = repository.save(user);
		return ResponseEntity.ok(updatedUser);
	}



	// DELETE: Excluir um usuário
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
