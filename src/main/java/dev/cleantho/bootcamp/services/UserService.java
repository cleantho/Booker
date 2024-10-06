package dev.cleantho.bootcamp.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dev.cleantho.bootcamp.models.User;
import dev.cleantho.bootcamp.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public User create(User user) {
		if (repo.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("This user already exists!");
		}
		return repo.save(user);
	}

	public User findById(Integer id) {
		return repo.findById(id).orElseThrow(NoSuchElementException::new);
	}
}
