package dev.cleantho.bootcamp.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cleantho.bootcamp.models.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Integer>{
	
	ArrayList<Reserve> findAllByDate(LocalDate date);

}
