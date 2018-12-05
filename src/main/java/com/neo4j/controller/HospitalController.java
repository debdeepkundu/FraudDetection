package com.neo4j.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.service.HospitalService;

@RestController
@RequestMapping("/rest/neo4j/hospital")
public class HospitalController{


	@Autowired
	HospitalService hospitalService;

	@GetMapping
	public Collection<Double> getAll() {
		return hospitalService.getAll();
	}

}
