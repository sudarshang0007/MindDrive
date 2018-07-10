package com.siemens.hackathon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="BlockChain")
public class BlockChainDataEntity {
	
    @Id
    @Column(name="index")
    int index;

    @Column(name = "Hash")
    private String hash;
    
    @Column(name = "TimeStamp")
    private String timeStamp;
    
    @Column(name = "Data")
    private String data;

}
