package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.SymptomTestMedMapper;

public interface SymptomTestMedRepository extends Neo4jRepository<SymptomTestMedMapper, Long> {

	@Query("MATCH(d:SYSTEM_TEST_MED_MAPPER) RETURN d")
	Collection<SymptomTestMedMapper> getAll();
}
