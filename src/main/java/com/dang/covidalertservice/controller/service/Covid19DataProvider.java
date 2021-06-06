package com.dang.covidalertservice.controller.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dang.covidalertservice.dto.CovidApiData;
import com.dang.covidalertservice.dto.StateData;
import com.dang.covidalertservice.dto.SummaryData;

@Service
public class Covid19DataProvider {
	
	final String url = "https://api.rootnet.in/covid19-in/stats/latest";
	
	@Autowired
	RestTemplate restTemplate;
	
	StateData getStateData(String state) {
		CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);
		
		return Arrays.stream(covidApiData.getData().getRegional())
				.filter(e -> e.getLoc().equalsIgnoreCase(state))
				.findAny()
				.orElse(new StateData());
	}

	public SummaryData getSummaryData() {
		
		CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);
		
		SummaryData summaryData = covidApiData.getData().getSummary();
		
		summaryData.setUpdateTime(covidApiData.getLastRefershed());
		
		return summaryData;
	}
}
