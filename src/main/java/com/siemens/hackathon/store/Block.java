package com.siemens.hackathon.store;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Block {
	
	
	private int index;
	private String hash;
	private String previousHash;
	private String timestamp;
    private Object data;
	public Block(int index, String previousHash, String timestamp, Object data) {
		super();
		this.index = index;
		this.previousHash = previousHash;
		this.timestamp = timestamp;
		this.data = data;
		this.hash = calculateHash();
	}
    
	String calculateHash(){
		String params=Integer.toString(this.index)+this.previousHash+this.timestamp+this.data.toString();
		return  Hashing.sha256()
				  .hashString(params, StandardCharsets.UTF_8)
				  .toString();
	}
    

}
