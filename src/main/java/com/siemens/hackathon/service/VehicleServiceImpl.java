package com.siemens.hackathon.service;

import java.util.List;

import com.siemens.hackathon.entity.VehicleDataEntity;
import com.siemens.hackathon.model.VehicleDataResource;
import com.siemens.hackathon.model.VehicleDto;
import com.siemens.hackathon.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    VehicleRepository vehicleRepository;

    public List<VehicleDataResource> getVehicleData(){

        return null;
    }
    
    public void postVehicleData(VehicleDto VehicleDto){
        VehicleDataEntity vehicleDataEntity=modelMapper.map(VehicleDto, VehicleDataEntity.class);
        vehicleRepository.save(vehicleDataEntity);
    }
}
