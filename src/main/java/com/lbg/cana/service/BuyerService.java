package com.lbg.cana.service;

import org.springframework.stereotype.Service;

import com.lbg.cana.repo.BuyerRepo;

@Service
public class BuyerService {

	private BuyerRepo repo;

	public BuyerService(BuyerRepo repo) {
		super();
		this.repo = repo;
	}

}
