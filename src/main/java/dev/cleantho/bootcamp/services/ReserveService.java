package dev.cleantho.bootcamp.services;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dev.cleantho.bootcamp.models.Reserve;
import dev.cleantho.bootcamp.repositories.ReserveRepository;

@Service
public class ReserveService {
	private ReserveRepository repo;
	
	public ReserveService(ReserveRepository repo) {
		this.repo = repo;
	}

	public Reserve create(Reserve reserve) {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("America/Sao_Paulo"));
		reserve.setDate(dtf.format(reserve.getStartTime()));
		
		List<Reserve> reserves = repo.findAllByDate(reserve.getDate());
		for (Reserve element : reserves) {
			if(element.equals(reserve)) {
				throw new IllegalArgumentException("This reserve already exists!");				
			}
		}		
		return repo.save(reserve);
	}
	
	public Reserve findById(Integer id) {
		return repo.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public List<Reserve> findAll() {		
		return repo.findAll();
	}
}
