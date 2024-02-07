package com.lbg.cana.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.domain.Seller;
import com.lbg.cana.service.SellerService;

@RestController
@RequestMapping("/sellers")
@CrossOrigin
public class SellerController {

	private SellerService service;

	public SellerController(SellerService service) {
		super();
		this.service = service;

	}

	@PostMapping("/create")
	public ResponseEntity<Seller> createSeller(@RequestBody Seller newSeller) {
		return this.service.createSeller(newSeller);
	}

	@GetMapping("/get")
	public List<Seller> getSeller() {
		return this.service.getSeller();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Seller> getSeller(@PathVariable int id) {
		return this.service.getSeller(id);
	}

	@GetMapping("/get/{firstName}/{lastName}")
	public ResponseEntity<Seller> findByFirstNameAndLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		return this.service.findByFirstNameAndLastName(firstName, lastName);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteSeller(@PathVariable int id) {
		return this.service.deleteSeller(id);
	}
}
