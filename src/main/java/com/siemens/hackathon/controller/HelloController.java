package com.siemens.hackathon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.hackathon.entity.MindDriveEntity;
import com.siemens.hackathon.entity.VehicleDetailsEntity;
import com.siemens.hackathon.model.GpsLocation;
import com.siemens.hackathon.model.MindDrive;
import com.siemens.hackathon.model.MindTripData;
import com.siemens.hackathon.model.VehicleAvgParameters;
import com.siemens.hackathon.repository.MindDriveRepository;
import com.siemens.hackathon.repository.VehicleDetailsRepository;
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
        mindDriveEntity.setSession(mindData.get("session"));

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
        @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/trips/session/{sessionId}")
    public List<GpsLocation> getSessionGps(@PathVariable String sessionId) {

	    //Add orderBy to fetch them in order of timestamp
        List<MindDriveEntity> mindDriveEntityList = mindDriveRepository.findBySessionOrderByTimeAsc(sessionId);

        List<GpsLocation> gpsLocationList = new ArrayList<GpsLocation>();
        for(MindDriveEntity mindDriveEntity: mindDriveEntityList)
        {
            GpsLocation gpsLocation = new GpsLocation();
            if(mindDriveEntity.getGpsLatitude()!=null)
            gpsLocation.setLatitude(Double.parseDouble(mindDriveEntity.getGpsLatitude()));

            if(mindDriveEntity.getGpsLongitude()!=null)
            gpsLocation.setLongitude(Double.parseDouble(mindDriveEntity.getGpsLongitude()));

            gpsLocationList.add(gpsLocation);
        }

        return  gpsLocationList;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/avgData/{pid}")
    public VehicleAvgParameters getVehicleAvgDataByPid(@PathVariable String pid) {
        return mindDriveRepository.getVehicleDataByPid(pid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/trips/{pid}")
    public ResponseEntity<List<MindTripData>> getTripByPid(@PathVariable String pid) {
        HashMap<String, ArrayList<MindDriveEntity>> sessionEntries = new HashMap<String, ArrayList<MindDriveEntity>>();
        List<MindTripData> mindDriveEntities = mindDriveRepository.findByPid(pid);
        return new ResponseEntity(mindDriveEntities, HttpStatus.OK);
        
        
     
    }
    
    @Autowired
    VehicleDetailsRepository vehicleDetailsRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive/details/{registrationId}")
    public VehicleDetailsEntity getVehicleHealthDataById( @PathVariable String registrationId) {
            return   vehicleDetailsRepository.findByRegistrationId(registrationId);
    } 

}
