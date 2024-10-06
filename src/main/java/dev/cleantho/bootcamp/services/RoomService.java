package dev.cleantho.bootcamp.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dev.cleantho.bootcamp.models.Room;
import dev.cleantho.bootcamp.repositories.RoomRepository;

@Service
public class RoomService {
	private RoomRepository repo;

	public RoomService(RoomRepository repo) {
		this.repo = repo;
	}

	public Room create(Room room) {
		if (repo.existsByName(room.getName())) {
			throw new IllegalArgumentException("This room already exists!");
		}
		return repo.save(room);
	}

	public Room findById(Integer id) {
		return repo.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
}
