package com.siemens.hackathon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.siemens.hackathon.entity.BlockChainDataEntity;

public interface BlockChainRepository extends CrudRepository<BlockChainDataEntity, String>{

	@Query("Select bda from BlockChainDataEntity bda where index=(Select max(index) from BlockChainDataEntity)")
	BlockChainDataEntity getLatestBlock();
}
