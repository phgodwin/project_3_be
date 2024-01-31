package com.lbg.cana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.cana.domain.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
