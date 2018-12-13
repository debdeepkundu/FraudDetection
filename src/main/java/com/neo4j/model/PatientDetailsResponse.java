package com.neo4j.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDetailsResponse {
	private String patientName;
	private String ssn;
	private String hospitalName;
	private Long totalCostOfMed;
	private Long totalCostOfTest;
	private Long totalHospitalTestCost;
	private Long totalHospitalMedCost;
	private List<DischargeParticularResponse> dischargeDetails;

	public Long getTotalCostOfMed() {
		return totalCostOfMed;
	}

	public void setTotalCostOfMed(Long totalCostOfMed) {
		this.totalCostOfMed = totalCostOfMed;
	}

	public Long getTotalCostOfTest() {
		return totalCostOfTest;
	}

	public void setTotalCostOfTest(Long totalCostOfTest) {
		this.totalCostOfTest = totalCostOfTest;
	}

	public Long getTotalHospitalTestCost() {
		return totalHospitalTestCost;
	}

	public void setTotalHospitalTestCost(Long totalHospitalTestCost) {
		this.totalHospitalTestCost = totalHospitalTestCost;
	}

	public Long getTotalHospitalMedCost() {
		return totalHospitalMedCost;
	}

	public void setTotalHospitalMedCost(Long totalHospitalMedCost) {
		this.totalHospitalMedCost = totalHospitalMedCost;
	}

	public List<DischargeParticularResponse> getDischargeDetails() {
		return dischargeDetails;
	}

	public void setDischargeDetails(List<DischargeParticularResponse> dischargeDetails) {
		this.dischargeDetails = dischargeDetails;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return "PatientDetailsResponse [patientName=" + patientName + ", ssn=" + ssn + ", hospitalName=" + hospitalName
				+ ", totalCostOfMed=" + totalCostOfMed + ", totalCostOfTest=" + totalCostOfTest
				+ ", totalHospitalTestCost=" + totalHospitalTestCost + ", totalHospitalMedCost=" + totalHospitalMedCost
				+ ", dischargeDetails=" + dischargeDetails + "]";
	}

}