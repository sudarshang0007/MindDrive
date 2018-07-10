package com.siemens.hackathon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.hackathon.entity.MindDriveEntity;
import com.siemens.hackathon.model.MindDrive;
import com.siemens.hackathon.model.VehicleAvgParameters;
import com.siemens.hackathon.repository.MindDriveRepository;
import com.siemens.hackathon.service.MindDriveService;

@CrossOrigin
@RestController
public class HelloController {
    @Autowired
    MindDriveRepository mindDriveRepository;

    @Autowired
    MindDriveService mindDriveService;

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive")
    public MindDrive sayHello() {

        MindDrive md = new MindDrive();
        md.setSpeed("80");
        md.setTime("10");
        return md;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/data")
    public void sayHelloPostData(@RequestParam Map<String, String> mindData) {
        MindDriveEntity mindDriveEntity = new MindDriveEntity();
        mindDriveEntity.setEml(mindData.get("eml"));
        mindDriveEntity.setPid(mindData.get("id"));
        mindDriveEntity.setTime(mindData.get("time"));
        mindDriveEntity.setGpsLongitude(mindData.get("kff1005"));
        mindDriveEntity.setGpsLatitude(mindData.get("kff1006"));

        mindDriveEntity.setSpeed(mindData.get("kff1001"));
        mindDriveEntity.setGpsBearing(mindData.get("kff1007"));
        mindDriveEntity.setAirFuelRatio(mindData.get("kff124d"));
        mindDriveEntity.setRpm(Double.parseDouble(mindData.get("kc")));
        mindDriveEntity.setEngLoad(Double.parseDouble(mindData.get("k4")));

        mindDriveEntity.setMSensor(mindData.get("kff1223"));
        mindDriveEntity.setAccZAxis(mindData.get("kff1222"));
        mindDriveEntity.setAccYAxis(mindData.get("kff1221"));
        mindDriveEntity.setAccXAxis(mindData.get("kff1220"));
        mindDriveEntity.setEngCoolantTmp(Double.parseDouble(mindData.get("k5")));
        mindDriveEntity.setTripDistance(mindData.get("kff1204"));
        mindDriveEntity.setBaroPressure(mindData.get("k33"));
        mindDriveEntity.setSysVapPressure(mindData.get("k32"));
        mindDriveEntity.setFuelFlowratePerMinute(mindData.get("kff125a"));
        mindDriveEntity.setFuleRemaining(mindData.get("kff126b"));
        mindDriveEntity.setProfileFuelCost(mindData.get("profileFuelCost"));
        mindDriveEntity.setProfileFuelName(mindData.get("profileFuelName"));

        mindDriveEntity.setProfileVe(mindData.get("profileVe"));
        mindDriveEntity.setProfileWeight(mindData.get("profileWeight"));

        mindDriveRepository.save(mindDriveEntity);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/data/{pid}")
    public MindDriveEntity sayHelloGetData(@PathVariable String pid) {

        MindDriveEntity mindDriveEntity = mindDriveRepository.findByPidAndTimeStamp(pid);

        int pattern = mindDriveService.evaluateCurrentPattern(mindDriveEntity);
        mindDriveEntity.setCurrentPattern(pattern);
        return mindDriveEntity;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/avgData/{pid}")
    public VehicleAvgParameters getVehicleAvgDataByPid(@PathVariable String pid) {
        return mindDriveRepository.getVehicleDataByPid(pid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/trips/{pid}")
    public VehicleAvgParameters getTripByPid(@PathVariable String pid) {
        HashMap<String, ArrayList<MindDriveEntity>> sessionEntries = new HashMap<String, ArrayList<MindDriveEntity>>();
        List<MindDriveEntity> mindDriveEntities = mindDriveRepository.findByPid(pid);
        System.out.println(mindDriveEntities);
        ArrayList<MindDriveEntity> min = new ArrayList();
        for (MindDriveEntity mindDriveEntity : mindDriveEntities) {
            if (sessionEntries.containsKey(mindDriveEntity.getSession())) {

                min = sessionEntries.get(mindDriveEntity.getSession());
                min.add(mindDriveEntity);
                sessionEntries.put(mindDriveEntity.getSession(), min);

            } else {
                // new entry
                min = new ArrayList();
                min.add(mindDriveEntity);
                sessionEntries.put(mindDriveEntity.getSession(), min);
            }
        }
        
        return mindDriveRepository.getVehicleDataByPid(pid);
    }

}
