package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.TestMedMaster;

public interface TestMedMasterRepository extends Neo4jRepository<TestMedMaster, Long> {

	@Query("MATCH(d:TEST_MED_MASTER) RETURN d")
	Collection<TestMedMaster> getAll();
}
