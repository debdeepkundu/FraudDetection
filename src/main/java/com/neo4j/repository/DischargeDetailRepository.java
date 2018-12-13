package com.neo4j.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.neo4j.model.DischargeDetails;
import com.neo4j.model.PatientDetailsSummary;
import com.neo4j.model.ResultSummary;

public interface DischargeDetailRepository extends Neo4jRepository<DischargeDetails, Long> {

	@Query("MATCH (a:Discharge_Details)-[:HASSAMESYM]->(b:SYMPTOM_TEST_MED_MAPPER)-[:HASMEDID]->(c:TEST_MED_COST_MASTER) "
			+ " RETURN a.medicine_cost as CostOfMedicine,a.Cost_of_test as CostOfTest,sum(toInt(c.AVG_HOSPITAL_MED_CHARGE))"
			+ " as AvghospitalMedCharge, sum(toInt(c.AVG_HOSPITAL_TEST_CHARGE)) as AvghospitalTestCharge , a.TreatmentFacility as HospitalName")
	Collection<ResultSummary> getAll();

	@Query("MATCH (n:Discharge_Details) RETURN SUM(toInt(n.Cost_of_test)) + SUM(toInt(n.medicine_cost))")
	Collection<Long> getTotalCost();

	@Query("MATCH (a:Discharge_Details),(b:SYMPTOM_TEST_MED_MAPPER),(c:TEST_MED_COST_MASTER) WHERE toUpper(a.Complaint) = toUpper(b.SYMPTOM_NAME) and b.TEST_MED_ID=c.TEST_MED_ID and a.Admission_id = {0} "
			+ " RETURN a.medicine_cost as CostOfMedicine,a.Cost_of_test as CostOfTest,c.AVG_HOSPITAL_MED_CHARGE as AvghospitalMedCharge, c.AVG_HOSPITAL_TEST_CHARGE as AvghospitalTestCharge")
	Collection<ResultSummary> getCostForAdmissionId(String admissionId);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and d.SSN = {ssn} and a.TreatmentFacility={hospitalName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetail")
	Collection<PatientDetailsSummary> getPatientDetails(@Param("patientFirstName") String fname,
			@Param("ssn") String ssn, @Param("hospitalName") String hospitalName);

	/*
	 * 
	 * SCREEN 2 : With patient, ssn and hospital
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and d.SSN = {ssn} and a.TreatmentFacility={hospitalName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getPatientMedDetails(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName, @Param("ssn") String ssn,
			@Param("hospitalName") String hospitalName);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and d.SSN = {ssn} and a.TreatmentFacility={hospitalName} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getPatientTestDetails(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName, @Param("ssn") String ssn,
			@Param("hospitalName") String hospitalName);

	/*
	 * 
	 * SCREEN 2 : With patient, ssn
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and d.SSN = {ssn} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromNameAndSSN(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName, @Param("ssn") String ssn);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and d.SSN = {ssn} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromNameAndSSN(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName, @Param("ssn") String ssn);

	/*
	 * 
	 * SCREEN 2 : With ssn and hospital
	 */

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.SSN = {ssn} and a.TreatmentFacility={hospitalName} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromSSNAndHospital(@Param("ssn") String ssn,
			@Param("hospitalName") String hospitalName);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.SSN = {ssn} and a.TreatmentFacility={hospitalName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromSSNAndHospital(@Param("ssn") String ssn,
			@Param("hospitalName") String hospitalName);

	/*
	 * 
	 * SCREEN 2 : With patient and hospital
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and a.TreatmentFacility={hospitalName} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromNameAndHospital(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName,
			@Param("hospitalName") String hospitalName);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} and a.TreatmentFacility={hospitalName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromNameAndHospital(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName,
			@Param("hospitalName") String hospitalName);

	/*
	 * 
	 * SCREEN 2 : With patient
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromName(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.FirstName={patientFirstName} and d.MiddleName = {patientMiddleName} and d.LastName = {patientLastName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromName(@Param("patientFirstName") String fname,
			@Param("patientMiddleName") String mName, @Param("patientLastName") String lName);

	/*
	 * 
	 * SCREEN 2 : With ssn
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.SSN = {ssn} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromSSN(@Param("ssn") String ssn);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where d.SSN = {ssn} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromSSN(@Param("ssn") String ssn);

	/*
	 * 
	 * SCREEN 2 : With hospital
	 */
	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMETEST]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where a.TreatmentFacility={hospitalName} RETURN '0' as CostOfMedicine,a.Cost_of_test as CostOfTest,0 as AvghospitalMedCharge, toInteger(c.AVG_HOSPITAL_TEST_CHARGE) as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getTestFromHospital(String hospitalName);

	@Query("MATCH (d:Patient_Information)-[:SAMESSN]->(a:Discharge_Details)-[:SMEMEDICINE]->(b:TEST_MED_MASTER)-[:SAMEMEDID]->(c:TEST_MED_COST_MASTER) where a.TreatmentFacility={hospitalName} RETURN a.medicine_cost as CostOfMedicine,'0' as CostOfTest,toInt(c.AVG_HOSPITAL_MED_CHARGE) as AvghospitalMedCharge, 0 as AvghospitalTestCharge ,a as dischargeDetails")
	Collection<PatientDetailsSummary> getMedFromHospital(String hospitalName);
}
