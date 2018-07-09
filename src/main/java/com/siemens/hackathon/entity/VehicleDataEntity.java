package com.siemens.hackathon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data

@Table(name="Vehicle")
public class VehicleDataEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    String id;

    @Column(name = "rpm")
    private String rpm;
    

    /** The name. */
    @Column(name = "temp")
    private String temp;

}
