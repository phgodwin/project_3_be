package com.lbg.cana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cana.domain.Buyer;
import com.lbg.cana.repo.BuyerRepo;

@Service
public class BuyerService {

	private BuyerRepo repo;

	public BuyerService(BuyerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Buyer> createBuyer(Buyer newBuyer) {
		Buyer created = this.repo.save(newBuyer);
		return new ResponseEntity<Buyer>(created, HttpStatus.CREATED);
	}

	public List<Buyer> getBuyer() {
		return this.repo.findAll();
	}

	public ResponseEntity<Buyer> getBuyer(int id) {
		Optional<Buyer> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
		}
		Buyer body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteBuyer(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
