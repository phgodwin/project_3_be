package com.lbg.cana.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.domain.Buyer;
import com.lbg.cana.service.BuyerService;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

	private BuyerService service;

	public BuyerController(BuyerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer newBuyer) {
		return this.service.createBuyer(newBuyer);
	}

	@GetMapping("/get")
	public List<Buyer> getBuyer() {
		return this.service.getBuyer();
	}

	@GetMapping("get/{id}")
	public ResponseEntity<Buyer> getBuyer(@PathVariable int id) {
		return this.service.getBuyer(id);
	}

}
