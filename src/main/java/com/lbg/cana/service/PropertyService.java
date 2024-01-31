package com.lbg.cana.service;

import org.springframework.stereotype.Service;

import com.lbg.cana.repo.PropertyRepo;

@Service
public class PropertyService {

	private PropertyRepo repo;

	public PropertyService(PropertyRepo repo) {
		super();
		this.repo = repo;
	}

}
