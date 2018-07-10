package com.siemens.hackathon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="MindDriveEntity")
public class MindDriveEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;

    @Column(name="session")
    String session;
        
    @Column(name="eml")
    String eml;
    
    @Column(name="pid")
    String pid;
    
    @Column(name="time")
    String time;
    
    @Column(name="gpsLongitude")
    String gpsLongitude;
    
    @Column(name="gpsLatitude")
    String gpsLatitude;
    
    @Column(name="speed")
    String speed;
    
    @Column(name="airFuelRatio")
    String airFuelRatio;
    
    @Column(name="rpm")
    Double rpm;
    
    
    @Column(name="accZAxis")
    String accZAxis;
    
    
    @Column(name="accYAxis")
    String accYAxis;
    
    
    @Column(name="accXAxis")
    String accXAxis;
    
    @Column(name="engCoolantTmp")
    Double engCoolantTmp;
    
    @Column(name="tripDistance")
    String tripDistance;
    
    
    @Column(name="baroPressure")
    String baroPressure;
    
    
    @Column(name="engLoad")
    Double engLoad;
    
    
    @Column(name="sysVapPressure")
    String sysVapPressure;
    
    @Column(name="fuelFlowratePerMinute")
    String fuelFlowratePerMinute;
    
    @Column(name="fuleRemaining")
    String fuleRemaining;
   
    @Column(name="gpsBearing")
    String gpsBearing;
    
    @Column(name="mSensor")
    String mSensor;
    
    
    @Column(name="profileFuelName")
    String profileFuelName;
    
    
    @Column(name="profileFuelType")
    String profileFuelType;
    
    
    @Column(name="profileFuelCost")
    String profileFuelCost;
    
    
    @Column(name="profileVe")
    String profileVe;
    

    @Column(name="profileWeight")
    String profileWeight;

    @Transient
    int currentPattern;
   
}
