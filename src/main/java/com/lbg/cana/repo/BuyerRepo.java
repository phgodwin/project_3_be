package com.lbg.cana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cana.domain.Buyer;

public interface BuyerRepo extends JpaRepository<Buyer, Integer> {

}
