package com.neo4j.model;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class ResultSummary {

	private String costOfMedicine;
	private String costOfTest;
	private Long avgHospitalMedCharge;
	private Long avgHospitalTestCharge;
	private String hospitalName;

	public String getCostOfTest() {
		return costOfTest;
	}

	public void setCostOfTest(String costOfTest) {
		this.costOfTest = costOfTest;
	}

	public Long getAvgHospitalMedCharge() {
		return avgHospitalMedCharge;
	}

	public void setAvgHospitalMedCharge(Long avgHospitalMedCharge) {
		this.avgHospitalMedCharge = avgHospitalMedCharge;
	}

	public Long getAvgHospitalTestCharge() {
		return avgHospitalTestCharge;
	}

	public void setAvgHospitalTestCharge(Long avgHospitalTestCharge) {
		this.avgHospitalTestCharge = avgHospitalTestCharge;
	}

	public String getCostOfMedicine() {
		return costOfMedicine;
	}

	public void setCostOfMedicine(String costOfMedicine) {
		this.costOfMedicine = costOfMedicine;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return "ResultSummary [costOfMedicine=" + costOfMedicine + ", costOfTest=" + costOfTest
				+ ", avgHospitalMedCharge=" + avgHospitalMedCharge + ", avgHospitalTestCharge=" + avgHospitalTestCharge
				+ ", hospitalName=" + hospitalName + "]";
	}

}