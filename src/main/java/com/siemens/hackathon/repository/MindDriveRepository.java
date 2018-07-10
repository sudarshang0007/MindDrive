package com.siemens.hackathon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siemens.hackathon.entity.MindDriveEntity;


    @Repository
    public interface MindDriveRepository extends CrudRepository<MindDriveEntity, String> {

        MindDriveEntity findByPid(String pid);

        @Query("Select app from MindDriveEntity app where time=(Select max(app1.time) from MindDriveEntity app1 where app1.pid=:pid ) and app.pid=:pid")
        MindDriveEntity findByPidAndTimeStamp(@Param("pid") String pid);

    }
        