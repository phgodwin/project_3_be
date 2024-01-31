package com.lbg.cana.service;

import org.springframework.stereotype.Service;

import com.lbg.cana.repo.SellerRepo;

@Service

public class SellerService {

	private SellerRepo repo;

	public SellerService(SellerRepo repo) {
		super();
		this.repo = repo;
	}

}
