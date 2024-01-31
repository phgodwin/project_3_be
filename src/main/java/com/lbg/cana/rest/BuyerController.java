package com.lbg.cana.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.service.BuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

	private BuyerService service;

	public BuyerController(BuyerService service) {
		super();
		this.service = service;
	}

}
