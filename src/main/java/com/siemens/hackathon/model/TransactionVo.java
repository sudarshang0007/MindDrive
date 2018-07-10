package com.siemens.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransactionVo {

	@JsonProperty(required = true)
	String carId;
	@JsonProperty(required = true)
	String details;
	@JsonProperty(required = true)
	String owner;
	@JsonProperty(required = true)
	String previousOwner;
	@JsonProperty(required = true)
	String accidentHistory;
	@JsonProperty(required = true)
	String policeHistory;
	@JsonProperty(required = true)
	String serviceCondition;
	@Override
	public String toString() {
		return "[carId=" + carId + ", details=" + details + ", owner=" + owner + ", previousOwner="
				+ previousOwner + ", accidentHistory=" + accidentHistory + ", policeHistory=" + policeHistory
				+ ", serviceCondition=" + serviceCondition +"]";
	}
	
	
}
