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

import dev.cleantho.bootcamp.models.Room;
import dev.cleantho.bootcamp.services.RoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

	@Autowired
	private RoomService service;

	@PostMapping
	public ResponseEntity<Room> insert(@RequestBody Room room) {
		Room roomCreated = service.create(room);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roomCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).body(roomCreated);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Room> find(@PathVariable Integer id) {
		Room room = service.findById(id);
		return ResponseEntity.ok(room);
	}

}
