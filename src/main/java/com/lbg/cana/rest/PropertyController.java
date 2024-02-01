package com.lbg.cana.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.domain.Property;
import com.lbg.cana.service.PropertyService;

@RequestMapping("/properties")
@CrossOrigin
@RestController
public class PropertyController {

	private PropertyService service;

	public PropertyController(PropertyService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Property> createProperty(@RequestBody Property newProperty) {

		return this.service.createProperty(newProperty);

	}

	@GetMapping("/get")
	public List<Property> getProperty() {

		return this.service.getProperty();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Property> getProperty(@PathVariable int id) {

		return this.service.getProperty(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody Property newProperty) {

		return this.service.updateProperty(id, newProperty);

	}

}
