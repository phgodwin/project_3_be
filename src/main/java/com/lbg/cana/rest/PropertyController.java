package com.lbg.cana.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cana.service.PropertyService;

@RequestMapping("/property")
@RestController
public class PropertyController {

	private PropertyService service;

	public PropertyController(PropertyService service) {
		super();
		this.service = service;

	}

}
