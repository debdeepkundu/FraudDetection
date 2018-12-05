package com.neo4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo4j.repository.SymptomTestMedRepository;

@Service
public class SymptomTestMapperService {

	@Autowired
	SymptomTestMedRepository symptomTestRepo;

}
