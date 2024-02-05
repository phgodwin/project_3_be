package com.lbg.cana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cana.domain.Booking;
import com.lbg.cana.dtos.BookingDTO;
import com.lbg.cana.repo.BookingRepo;

@Service
public class BookingService {

	private BookingRepo repo;

	public BookingService(BookingRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Booking> createBooking(Booking newBooking) {
		Booking created = this.repo.save(newBooking);
		return new ResponseEntity<Booking>(created, HttpStatus.CREATED);
	}

	public List<BookingDTO> getBooking() {

		List<Booking> bookings = this.repo.findAll();

		List<BookingDTO> dtos = new ArrayList<BookingDTO>();

		for (Booking booking : bookings) {
			BookingDTO dto = new BookingDTO();

			dto.setId(booking.getId());
			dto.setTime(booking.getTime());
			dto.setDate(booking.getDate());

			dto.setBuyerName(booking.getBuyer().getFirstName() + " " + booking.getBuyer().getLastName());

			dtos.add(dto);
		}

		return dtos;
	}

	public ResponseEntity<Booking> getBooking(int id) {
		Optional<Booking> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		}
		Booking body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteBooking(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}