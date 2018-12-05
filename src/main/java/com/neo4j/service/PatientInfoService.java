package com.neo4j.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo4j.model.PatientInformation;
import com.neo4j.repository.PatientInfoRepository;

@Service
public class PatientInfoService {

	@Autowired
	private PatientInfoRepository patientInfo;
	
	public Collection<PatientInformation> getAll(){
		return patientInfo.getAll();
	}
	
}
