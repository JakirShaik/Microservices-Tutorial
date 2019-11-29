package org.jackson.microservices.geographicalinfo.controller;

import org.jackson.microservices.geographicalinfo.command.GeographicalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geographical")
public class GeographicalInfoController {
	@Autowired
	Environment environment;
	
	@GetMapping("/info")
	public GeographicalInfo getGeographicalInfo() {
		System.out.println("***********************************************************************************************************");
		System.out.println("Author:"+environment.getProperty("author"));
		System.out.println("***********************************************************************************************************");
		return new GeographicalInfo(environment.getProperty("city"), environment.getProperty("district"), environment.getProperty("state"), environment.getProperty("country"), Integer.valueOf(environment.getProperty("pincode")));
	}
}
