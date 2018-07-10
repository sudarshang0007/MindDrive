package com.siemens.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siemens.hackathon.entity.MindDriveEntity;
import com.siemens.hackathon.model.MindTripData;
import com.siemens.hackathon.model.VehicleAvgParameters;


    @Repository
    public interface MindDriveRepository extends CrudRepository<MindDriveEntity, String> {


        @Query("Select app from MindDriveEntity app where time=(Select max(app1.time) from MindDriveEntity app1 where app1.pid=:pid ) and app.pid=:pid")
        MindDriveEntity findByPidAndTimeStamp(@Param("pid") String pid);

        @Query("Select new com.siemens.hackathon.model.VehicleAvgParameters(avg(app.rpm),avg(app.engCoolantTmp),avg(app.engLoad),avg(app.speed)) "
                        + " from MindDriveEntity app where app.pid=:pid ")
        VehicleAvgParameters getVehicleDataByPid(@Param("pid") String pid);
        
        
        @Query("Select new com.siemens.hackathon.model.MindTripData(app.session , max(app.tripDistance) ,min(app.tripDistance)  ,max(app.fuleRemaining) ,min(app.fuleRemaining) ) from MindDriveEntity app  where app.pid=:pid  group by app.session")
        List<MindTripData> findByPid(@Param("pid") String pid);
        List<MindDriveEntity> findBySessionOrderByTimeAsc(String sessionId);

    }
        