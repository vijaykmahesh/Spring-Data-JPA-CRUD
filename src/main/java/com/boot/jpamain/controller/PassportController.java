package com.boot.jpamain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpamain.dto.PassportDTO;
import com.boot.jpamain.service.PassportService;

@RestController
@RequestMapping("/passport")
public class PassportController {
	
	private final PassportService passportService;
	
	
	public PassportController(PassportService passportService) {
		super();
		this.passportService = passportService;
	}



	@GetMapping("/{countryCode}/{passportNumber}")
	public ResponseEntity<PassportDTO> getPassportById(@PathVariable String countryCode,
            @PathVariable String passportNumber) {

		// PassportDTO passport = passportService.getPassportById(countryCode,countryCode);
		
		passportService.test(countryCode, passportNumber);
		
		 return ResponseEntity.ok(null);

	}

}
