package dev.cleantho.bootcamp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.cleantho.bootcamp.models.User;
import dev.cleantho.bootcamp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User userCreated = service.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).body(userCreated);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> find(@PathVariable Integer id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);
	}

}
