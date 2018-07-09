package com.siemens.hackathon.controller;

import com.siemens.hackathon.model.MindDrive;
import com.siemens.hackathon.model.VehicleDataResource;
import com.siemens.hackathon.model.VehicleDto;
import com.siemens.hackathon.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(method = RequestMethod.POST, value = "/api/vehicle")
    @ResponseStatus(CREATED)
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody @Valid VehicleDto vehicleDto) {

        vehicleService.postVehicleData(vehicleDto);
        return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.CREATED);
    }
}