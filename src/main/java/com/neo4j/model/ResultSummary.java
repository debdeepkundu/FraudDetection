package com.neo4j.model;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class ResultSummary {

	private String costOfMedicine;
	private String costOfTest;
	private String avgHospitalMedCharge;
	private String avgHospitalTestCharge;
	private String hospitalName;

	public String getCostOfTest() {
		return costOfTest;
	}

	public void setCostOfTest(String costOfTest) {
		this.costOfTest = costOfTest;
	}

	public String getAvgHospitalMedCharge() {
		return avgHospitalMedCharge;
	}

	public void setAvgHospitalMedCharge(String avgHospitalMedCharge) {
		this.avgHospitalMedCharge = avgHospitalMedCharge;
	}

	public String getAvgHospitalTestCharge() {
		return avgHospitalTestCharge;
	}

	public void setAvgHospitalTestCharge(String avgHospitalTestCharge) {
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