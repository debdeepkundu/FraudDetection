package com.neo4j.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.model.PatientInformation;
import com.neo4j.service.PatientInfoService;

@RestController
@RequestMapping("/rest/neo4j/patientInfo")
public class PatientInfoController {
	@Autowired
	PatientInfoService patientInfoService;

	@GetMapping
	public Collection<PatientInformation> getAll() {
		System.out.println("Inside detail service");
		System.out.println(patientInfoService.getAll().toString() + "results");
		for (PatientInformation p : patientInfoService.getAll()) {
			System.out.println(p.getFirstName());
		}
		return patientInfoService.getAll();
	}

}
