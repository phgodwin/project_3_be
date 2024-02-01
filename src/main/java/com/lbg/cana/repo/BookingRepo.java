package com.lbg.cana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cana.domain.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
