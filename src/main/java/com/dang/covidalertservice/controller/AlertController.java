package com.dang.covidalertservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dang.covidalertservice.controller.service.AlertService;
import com.dang.covidalertservice.dto.AlertStatus;
import com.dang.covidalertservice.dto.SummaryData;

@RestController
@RequestMapping("/india")
public class AlertController {
	
	@Autowired
	private AlertService alertService;
	
	@GetMapping("/{state}")
	AlertStatus getAlertAboutState(@PathVariable String state) {
		return alertService.getAlertAboutState(state);
	}
	
	@GetMapping("/summary")
	SummaryData getOverAllSummary() {
		return alertService.getOverAllSummary();
	}
}
