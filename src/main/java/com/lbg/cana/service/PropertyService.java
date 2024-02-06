package com.lbg.cana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cana.domain.Booking;
import com.lbg.cana.domain.Property;
import com.lbg.cana.dtos.BookingDTO;
import com.lbg.cana.dtos.PropertyDTO;
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

	public List<PropertyDTO> getProperty() {
		List<Property> properties = this.repo.findAll();
		List<PropertyDTO> dtos = new ArrayList<PropertyDTO>();

		for (Property property : properties) {
			PropertyDTO dto = new PropertyDTO();
			dto.setId(property.getId());
			dto.setSellerName(property.getSeller().getFirstName() + " " + property.getSeller().getLastName());
			dto.setBath(property.getBath());
			dto.setBeds(property.getBeds());
			dto.setGrdn(property.getGrdn());
			dto.setLoc(property.getLoc());
			dto.setPcod(property.getPcod());
			dto.setPrc(property.getPrc());
			dto.setStatus(property.getStatus());
			dtos.add(dto);
		}

		return dtos;
	}

	public ResponseEntity<PropertyDTO> getProperty(int id) {

		Optional<Property> found = this.repo.findById(id);

		if (found.isEmpty()) {

			return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
		}

		PropertyDTO dto = new PropertyDTO();
		Property property = found.get();

		dto.setId(property.getId());
		dto.setSellerName(property.getSeller().getFirstName() + " " + property.getSeller().getLastName());
		dto.setBath(property.getBath());
		dto.setBeds(property.getBeds());
		dto.setGrdn(property.getGrdn());
		dto.setLoc(property.getLoc());
		dto.setPcod(property.getPcod());
		dto.setPrc(property.getPrc());
		dto.setStatus(property.getStatus());

		for (Booking booking : property.getBookings()) {
			BookingDTO bookingDto = new BookingDTO();

			bookingDto.setId(booking.getId());
			bookingDto.setTime(booking.getTime());
			bookingDto.setDate(booking.getDate());

			bookingDto.setBuyerName(booking.getBuyer().getFirstName() + " " + booking.getBuyer().getLastName());

			dto.getBookings().add(bookingDto);
		}

		return ResponseEntity.ok(dto);
	}

	public ResponseEntity<Property> updateProperty(int id, Property newProperty) {

		Optional<Property> found = this.repo.findById(id);

		if (found.isEmpty()) {

			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}

		Property body = found.get();

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
