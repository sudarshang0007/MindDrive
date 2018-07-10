package com.siemens.hackathon.service;

import com.siemens.hackathon.model.TransactionVo;
import com.siemens.hackathon.store.Block;

public interface BlockChainService {

	Block createBlock(TransactionVo data);

	void postOnBlockChain(Block blockData);

	Block addBlockData(Block blockData);

}
