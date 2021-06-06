package com.dang.covidalertservice.dto;

import java.time.ZonedDateTime;

public class CovidApiData {
	private boolean success;
	
	private CountryData data;
	
	private ZonedDateTime lastRefershed;
	
	private ZonedDateTime lastOriginalUpdate;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CountryData getData() {
		return data;
	}

	public void setData(CountryData data) {
		this.data = data;
	}

	public ZonedDateTime getLastRefershed() {
		return lastRefershed;
	}

	public void setLastRefershed(ZonedDateTime lastRefershed) {
		this.lastRefershed = lastRefershed;
	}

	public ZonedDateTime getLastOriginalUpdate() {
		return lastOriginalUpdate;
	}

	public void setLastOriginalUpdate(ZonedDateTime lastOriginalUpdate) {
		this.lastOriginalUpdate = lastOriginalUpdate;
	}
	
	
}
