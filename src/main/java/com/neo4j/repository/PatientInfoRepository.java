package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.PatientInformation;

public interface PatientInfoRepository extends Neo4jRepository<PatientInformation, Long> {
	@Query("MATCH(d:Patient_Information) RETURN d")
	Collection<PatientInformation> getAll();
}
