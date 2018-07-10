package com.siemens.hackathon.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.hackathon.entity.BlockChainDataEntity;
import com.siemens.hackathon.repository.BlockChainRepository;

@Component
public class BlockChain {

	public BlockChain() {}
	
	@Autowired BlockChainRepository blockChainRepository;

	public Block createGenesisBlock() {
		return new Block(0,"0","10/07/2018","Genesis Block");
		
	}
	
	BlockChainDataEntity getLatestBlock(){
		return blockChainRepository.getLatestBlock();
	}
	
	public Block addBlock(Block newBlock) {
		newBlock.setPreviousHash(this.getLatestBlock().getHash());
		newBlock.setHash(newBlock.calculateHash());
		newBlock.setIndex(this.getLatestBlock().getIndex()+1);
		return newBlock;
	}
}
