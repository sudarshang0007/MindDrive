package com.siemens.hackathon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data

@Table(name="VehicleDetailsEntity")
public class VehicleDetailsEntity {
	@Id
	@Column(name="pid")
    String pid;
	
	@Column(name="ownerName")
	String owner;
	
	@Column(name="contactNo")
	String contactNo;
	
	@Column(name="model")
	String model;
	
	@Column(name="make")
	String make;
	
	@Column(name="year")
	String year;
	
	@Column(name="noOfOwner")
	String noOfOwner;
	
	@Column(name="fuelType")
	String fuelType;
	
	@Column(name="isAccidental")
	String isAccidental;
	
	@Column(name="isFloodAffected")
	String isFloodAffected;
	
	@Column(name="registrationId")
	String registrationId;
	
	
	
	
}
