package com.dang.covidalertservice.controller.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dang.covidalertservice.dto.AlertStatus;
import com.dang.covidalertservice.dto.StateData;
import com.dang.covidalertservice.dto.SummaryData;

@Service
public class AlertService {
	
	@Autowired
	private Covid19DataProvider covid19DataProvider;

	public AlertStatus getAlertAboutState(String state) {
		AlertStatus alertStatus = new AlertStatus();
		
		StateData stateData = covid19DataProvider.getStateData(state);
		
		alertStatus.setSummaryData(stateData);
		
		if(stateData.getTotalConfirmed() < 1000) {
			alertStatus.setAlertLevel("GREEN");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("Every isNormal !!"));
		}else if(stateData.getTotalConfirmed() > 1000 
				&& stateData.getTotalConfirmed() < 10000) {
			alertStatus.setAlertLevel("ORANGE");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("Only Essential services are allowed", 
					"List of services that come under essential service"));
		}else {
			alertStatus.setAlertLevel("RED");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("Absolute lock-down", 
					"Only Medical and food services are allowed to open"));
		}
		
		return alertStatus;
	}

	public SummaryData getOverAllSummary() {
		return covid19DataProvider.getSummaryData();
	}
}
