package dev.cleantho.bootcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cleantho.bootcamp.models.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	boolean existsByName(String name);
	
}
