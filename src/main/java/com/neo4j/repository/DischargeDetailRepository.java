package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.model.DischargeDetails;
import com.neo4j.model.ResultSummary;

public interface DischargeDetailRepository extends Neo4jRepository<DischargeDetails, Long> {

	@Query("MATCH (a:Discharge_Details) ,(b:SYMPTOM_TEST_MED_MAPPER),(c:TEST_MED_COST_MASTER) WHERE toUpper(a.Complaint) = toUpper(b.SYMPTOM_NAME) and b.TEST_MED_ID=c.TEST_MED_ID RETURN a.medicine_cost as CostOfMedicine,a.Cost_of_test as CostOfTest,c.AVG_HOSPITAL_MED_CHARGE as AvghospitalMedCharge, c.AVG_HOSPITAL_TEST_CHARGE as AvghospitalTestCharge , a.TreatmentFacility as HospitalName")
	Collection<ResultSummary> getAll();

	@Query("MATCH (n:Discharge_Details) RETURN SUM(toInt(n.Cost_of_test)) + SUM(toInt(n.medicine_cost))")
	Collection<Long> getTotalCost();

	@Query("MATCH (a:Discharge_Details),(b:SYMPTOM_TEST_MED_MAPPER),(c:TEST_MED_COST_MASTER) WHERE toUpper(a.Complaint) = toUpper(b.SYMPTOM_NAME) and b.TEST_MED_ID=c.TEST_MED_ID and toLower(a.Complaint) = toLower({0}) "
			+ " RETURN a.medicine_cost as CostOfMedicine,a.Cost_of_test as CostOfTest,c.AVG_HOSPITAL_MED_CHARGE as AvghospitalMedCharge, c.AVG_HOSPITAL_TEST_CHARGE as AvghospitalTestCharge")
	Collection<ResultSummary> getDischWithCost(String symptom);

	@Query("MATCH (a:Discharge_Details),(b:SYMPTOM_TEST_MED_MAPPER),(c:TEST_MED_COST_MASTER) WHERE toUpper(a.Complaint) = toUpper(b.SYMPTOM_NAME) and b.TEST_MED_ID=c.TEST_MED_ID and a.Admission_id = {0} "
			+ " RETURN a.medicine_cost as CostOfMedicine,a.Cost_of_test as CostOfTest,c.AVG_HOSPITAL_MED_CHARGE as AvghospitalMedCharge, c.AVG_HOSPITAL_TEST_CHARGE as AvghospitalTestCharge")
	Collection<ResultSummary> getCostForAdmissionId(String admissionId);
}
