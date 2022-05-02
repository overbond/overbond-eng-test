package com.overbond.test.kh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overbond.test.kh.service.AmountOutstandingService;

@RestController
@RequestMapping("amountOutstanding")
public class AmountOutStandingController {
	
	@Autowired
	public AmountOutstandingService amountOutstandingService;
	
	@GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAmountOutstanding() {
		return amountOutstandingService.calculate();
	}

}
