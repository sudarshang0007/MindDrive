package com.siemens.hackathon;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.MindDrive;

@CrossOrigin
@RestController
public class HelloController {
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/getMindDrive")
	public MindDrive sayHello() {
		
	MindDrive md = new MindDrive();
	md.setSpeed("80");
	md.setTime("10");
		return md;
	}
}
