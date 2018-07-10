package com.siemens.hackathon.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siemens.hackathon.entity.BlockChainDataEntity;
import com.siemens.hackathon.model.TransactionVo;
import com.siemens.hackathon.repository.BlockChainRepository;
import com.siemens.hackathon.store.Block;
import com.siemens.hackathon.store.BlockChain;

@Service
public class BlockChainServiceImpl implements BlockChainService{
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired BlockChain blockChain;
	
	@Autowired BlockChainRepository blockChainRepository;

	@Override
	public Block createBlock(TransactionVo data) {
		
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		
		return new Block(0, "", timeStamp, data.toString());	
	} 

	@Override
	public Block addBlockData(Block blockData) {
		Block readyBlockData =blockChain.addBlock(blockData);
		return readyBlockData;
		
	}

	@Override
	public void postOnBlockChain(Block blockData) {
		BlockChainDataEntity blockDataEntity=modelMapper.map(blockData, BlockChainDataEntity.class);
		blockChainRepository.save(blockDataEntity);
	}

}
