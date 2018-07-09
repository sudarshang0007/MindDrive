package com.siemens.hackathon.repository;

import com.siemens.hackathon.entity.VehicleDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends CrudRepository<VehicleDataEntity, String> {

}
    