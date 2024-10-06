package dev.cleantho.bootcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cleantho.bootcamp.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

}
