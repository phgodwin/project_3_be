package com.lbg.cana.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.service.SellerService;

@RestController
@RequestMapping("/seller")

public class SellerController {

	private SellerService service;

	public SellerController(SellerService service) {
		super();
		this.service = service;

	}

}
