package com.siemens.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siemens.hackathon.entity.MindDriveEntity;
import com.siemens.hackathon.entity.VehicleDetailsEntity;
import com.siemens.hackathon.model.VehicleAvgParameters;


    @Repository
    public interface VehicleDetailsRepository extends CrudRepository<VehicleDetailsEntity, String> {

    	VehicleDetailsEntity findByRegistrationId(String registrationId);
    	    	   	
    	@Query("Select vde.registrationId from VehicleDetailsEntity vde")
    	List<String> findAllByregistrationId();

    }
        