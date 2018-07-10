package com.siemens.hackathon.controller;

import com.siemens.hackathon.model.MindDrive;
import com.siemens.hackathon.model.TransactionVo;
import com.siemens.hackathon.model.VehicleDataResource;
import com.siemens.hackathon.model.VehicleDto;
import com.siemens.hackathon.service.BlockChainService;
import com.siemens.hackathon.service.VehicleService;
import com.siemens.hackathon.store.Block;
import com.siemens.hackathon.store.BlockChain;
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
@RequestMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    BlockChainService blockChainService;

    @Autowired
    BlockChain blockChain;

    ModelMapper modelMapper = new ModelMapper();

    @RequestMapping(method = RequestMethod.POST, value = "/api/vehicle")
    @ResponseStatus(CREATED)
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {

        vehicleService.postVehicleData(vehicleDto);
        return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.POST, value="/api/blockData",produces="application/json")
    public void putBlockChainData(@RequestBody TransactionVo data) {
        Block blockData=blockChainService.createBlock(data);
        Block blockChainData=blockChainService.addBlockData(blockData);
        blockChainService.postOnBlockChain(blockChainData);
    }

    @RequestMapping(method= RequestMethod.POST, value="/api/blockData/genesis",produces="application/json")
    public void putGenesisBlock() {
        Block blockData=blockChain.createGenesisBlock();
        blockChainService.postOnBlockChain(blockData);

    }
}
