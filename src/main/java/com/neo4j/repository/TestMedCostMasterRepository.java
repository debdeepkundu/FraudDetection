package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.TestMedCostMaster;

public interface TestMedCostMasterRepository extends Neo4jRepository<TestMedCostMaster, Long> {

	@Query("MATCH(d:TEST_MED_COST_MASTER) RETURN d")
	Collection<TestMedCostMaster> getAll();
}
