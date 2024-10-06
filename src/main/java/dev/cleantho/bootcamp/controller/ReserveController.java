package dev.cleantho.bootcamp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.cleantho.bootcamp.models.Reserve;
import dev.cleantho.bootcamp.services.ReserveService;

@RestController
@RequestMapping(value = "/reserves")
public class ReserveController {

	@Autowired
	private ReserveService service;

	@PostMapping
	public ResponseEntity<Reserve> insert(@RequestBody Reserve reserve) {
		Reserve reserveCreated = service.create(reserve);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reserveCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).body(reserveCreated);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Reserve> find(@PathVariable Integer id) {
		Reserve reserve = service.findById(id);
		return ResponseEntity.ok(reserve);
	}
	
	@GetMapping
	public ResponseEntity<List<Reserve>> findAll() {
		List<Reserve> reserves = service.findAll();
		return ResponseEntity.ok(reserves);
	}

}
