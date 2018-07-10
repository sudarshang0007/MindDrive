package com.siemens.hackathon.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.hackathon.model.VehicleDto;
import com.siemens.hackathon.service.VehicleService;

@RestController
@CrossOrigin
@RequestMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(method = RequestMethod.POST, value = "/api/vehicle")
    @ResponseStatus(CREATED)
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {

        vehicleService.postVehicleData(vehicleDto);
        return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.CREATED);
    }
}
