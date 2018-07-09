package com.siemens.hackathon.service;

import java.util.List;

import com.siemens.hackathon.model.VehicleDataResource;
import com.siemens.hackathon.model.VehicleDto;
import org.springframework.stereotype.Service;
@Service
public interface VehicleService {
    List<VehicleDataResource> getVehicleData();
    void postVehicleData(VehicleDto VehicleDto);
}
