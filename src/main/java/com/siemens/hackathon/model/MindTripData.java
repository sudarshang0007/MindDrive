package com.siemens.hackathon.model;

import javax.persistence.ColumnResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MindTripData {

    String session;
    String tripDistanceMax;

    String tripDistanceMin;

    String fuelMaX;

String fuelMin;

}
