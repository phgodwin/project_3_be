package com.lbg.cana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cana.domain.Seller;
import com.lbg.cana.repo.SellerRepo;

@Service

public class SellerService {

	private SellerRepo repo;

	public SellerService(SellerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Seller> createSeller(Seller newSeller) {
		Seller created = this.repo.save(newSeller);
		return new ResponseEntity<Seller>(created, HttpStatus.CREATED);
	}

	public List<Seller> getSeller() {
		return this.repo.findAll();
	}

	public ResponseEntity<Seller> getSeller(int id) {
		Optional<Seller> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
		}

		Seller body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Seller> findByFirstNameAndLastName(String firstName, String lastName) {
		Optional<Seller> found = this.repo.findByFirstNameAndLastName(firstName, lastName);
		if (found.isEmpty()) {
			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
		}
		Seller body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteSeller(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
