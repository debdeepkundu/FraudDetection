package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.HospitalDemographics;

public interface HospitalRepository extends Neo4jRepository<HospitalDemographics, Double> {

	@Query("MATCH (n:Hospital_Demographics) RETURN sum(toInteger(n.Provider_Number))")
	Collection<Double> getAll();

}
