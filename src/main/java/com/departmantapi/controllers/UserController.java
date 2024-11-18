package com.departmantapi.controllers;

import com.departmantapi.entities.User;
import com.departmantapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	// Método simples de autenticação
	private boolean isAuthenticated(String token) {
		// Verifica se o token é igual a um valor fixo (você pode personalizar)
		return "mySecretToken123".equals(token);
	}

	public UserController() {
	}

	// CREATE: Inserir um novo usuário
	@PostMapping
	public ResponseEntity<?> insert(
			@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody User user) {
		if (token == null || !isAuthenticated(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado.");
		}
		if (repository.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Email já está em uso. Por favor, utilize um email diferente.");
		}
		User savedUser = repository.save(user);
		return ResponseEntity.ok(savedUser);
	}

	// READ: Listar todos os usuários
	@GetMapping
	public ResponseEntity<?> findAll(@RequestHeader(value = "Authorization", required = false) String token) {
		if (token == null || !isAuthenticated(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado.");
		}
		List<User> users = repository.findAll();
		return ResponseEntity.ok(users);
	}

	// READ: Encontrar um usuário pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(
			@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable Long id) {
		if (token == null || !isAuthenticated(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado.");
		}
		Optional<User> user = repository.findById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// UPDATE: Atualizar um usuário existente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(
			@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable Long id,
			@RequestBody User user) {
		if (token == null || !isAuthenticated(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado.");
		}
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
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
	public ResponseEntity<Void> delete(
			@RequestHeader(value = "Authorization", required = false) String token,
			@PathVariable Long id) {
		if (token == null || !isAuthenticated(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
