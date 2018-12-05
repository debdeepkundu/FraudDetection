package com.neo4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo4j.repository.TestMedMasterRepository;

@Service
public class TestMedMasterService {

	@Autowired
	TestMedMasterRepository testMedMasterRepo;

}
