package com.lbg.cana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cana.domain.Property;
import com.lbg.cana.repo.PropertyRepo;

@Service
public class PropertyService {

	private PropertyRepo repo;

	public PropertyService(PropertyRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Property> createProperty(Property newProperty) {

		Property created = this.repo.save(newProperty);

		return new ResponseEntity<Property>(created, HttpStatus.CREATED);
	}

	public List<Property> getProperty() {

		return this.repo.findAll();
	}

	public ResponseEntity<Property> getProperty(int id) {

		Optional<Property> found = this.repo.findById(id);

		if (found.isEmpty()) {

			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}

		Property body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Property> updateProperty(int id, Property newProperty) {

		Optional<Property> found = this.repo.findById(id);

		if (found.isEmpty()) {

			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}

		Property body = found.get();

		if (newProperty.getSellnme() != null)

			body.setSellnme(newProperty.getSellnme());

		if (newProperty.getPrc() != null)

			body.setPrc(newProperty.getPrc());

		if (newProperty.getLoc() != null)

			body.setLoc(newProperty.getLoc());

		if (newProperty.getPcod() != null)

			body.setPcod(newProperty.getPcod());

		if (newProperty.getBeds() != null)

			body.setBeds(newProperty.getBeds());

		if (newProperty.getBath() != null)

			body.setBath(newProperty.getBath());

		if (newProperty.getGrdn() != null)

			body.setGrdn(newProperty.getGrdn());

		if (newProperty.getStatus() != null)

			body.setStatus(newProperty.getStatus());

		this.repo.save(body);

		return ResponseEntity.ok(body);
	}

}
