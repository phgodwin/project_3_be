package com.lbg.cana.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cana.domain.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

	Optional<Seller> findByFirstNameAndLastName(String firstName, String lastName);

}
