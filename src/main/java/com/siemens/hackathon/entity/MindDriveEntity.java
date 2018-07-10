package com.siemens.hackathon.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data

@Table(name="MindDriveEntity")
public class MindDriveEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    String id;
    
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
    String rpm;
    
    
    @Column(name="accZAxis")
    String accZAxis;
    
    
    @Column(name="accYAxis")
    String accYAxis;
    
    
    @Column(name="accXAxis")
    String accXAxis;
    
    @Column(name="engCoolantTmp")
    String engCoolantTmp;
    
    @Column(name="tripDistance")
    String tripDistance;
    
    
    @Column(name="baroPressure")
    String baroPressure;
    
    
    @Column(name="engLoad")
    String engLoad;
    
    
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
