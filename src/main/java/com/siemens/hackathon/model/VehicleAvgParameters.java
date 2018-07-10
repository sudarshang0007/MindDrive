package com.siemens.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAvgParameters {

	private Double avgEngineRpm;
	private double avgEnginetemp;
	private double avgEngLoad;
	private double avgSpeed;
	
}
