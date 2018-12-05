package com.neo4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostForSymptomResponse {
	private Integer totalCostOfMed;
	private Integer totalCostOfTest;
	private Integer totalHospitalTestCost;
	private Integer totalHospitalMedCost;
	private Integer fraudCount;
	private Integer totalRecordCount;
	private String message;
	private Integer totalHospitalCount;

	public Integer getTotalCostOfMed() {
		return totalCostOfMed;
	}

	public void setTotalCostOfMed(Integer totalCostOfMed) {
		this.totalCostOfMed = totalCostOfMed;
	}

	public Integer getTotalCostOfTest() {
		return totalCostOfTest;
	}

	public void setTotalCostOfTest(Integer totalCostOfTest) {
		this.totalCostOfTest = totalCostOfTest;
	}

	public Integer getTotalHospitalTestCost() {
		return totalHospitalTestCost;
	}

	public void setTotalHospitalTestCost(Integer totalHospitalTestCost) {
		this.totalHospitalTestCost = totalHospitalTestCost;
	}

	public Integer getTotalHospitalMedCost() {
		return totalHospitalMedCost;
	}

	public void setTotalHospitalMedCost(Integer totalHospitalMedCost) {
		this.totalHospitalMedCost = totalHospitalMedCost;
	}

	public Integer getFraudCount() {
		return fraudCount;
	}

	public void setFraudCount(Integer fraudCount) {
		this.fraudCount = fraudCount;
	}

	public Integer getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(Integer totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getTotalHospitalCount() {
		return totalHospitalCount;
	}

	public void setTotalHospitalCount(Integer totalHospitalCount) {
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
