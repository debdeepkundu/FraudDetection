package com.neo4j.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo4j.repository.HospitalRepository;


@Service
public class HospitalService {
	@Autowired
	HospitalRepository hospitalRepository;

	public Collection<Double> getAll() {
		return hospitalRepository.getAll();
	}
}
