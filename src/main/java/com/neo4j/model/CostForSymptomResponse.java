package com.neo4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostForSymptomResponse {
	private Long totalCostOfMed;
	private Long totalCostOfTest;
	private Long totalHospitalTestCost;
	private Long totalHospitalMedCost;
	private Long fraudCount;
	private Long totalRecordCount;
	private String message;
	private Long totalHospitalCount;

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

	public Long getFraudCount() {
		return fraudCount;
	}

	public void setFraudCount(Long fraudCount) {
		this.fraudCount = fraudCount;
	}

	public Long getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(Long totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTotalHospitalCount() {
		return totalHospitalCount;
	}

	public void setTotalHospitalCount(Long totalHospitalCount) {
		this.totalHospitalCount = totalHospitalCount;
	}

	@Override
	public String toString() {
		return "CostForSymptomResponse [totalCostOfMed=" + totalCostOfMed + ", totalCostOfTest=" + totalCostOfTest
				+ ", totalHospitalTestCost=" + totalHospitalTestCost + ", totalHospitalMedCost=" + totalHospitalMedCost
				+ ", fraudCount=" + fraudCount + ", totalRecordCount=" + totalRecordCount + ", message=" + message
				+ ", totalHospitalCount=" + totalHospitalCount + "]";
	}

}