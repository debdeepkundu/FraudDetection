package com.neo4j.model;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class PatientDetailsSummary {

	private String costOfMedicine;
	private String costOfTest;
	private Long avgHospitalMedCharge;
	private Long avgHospitalTestCharge;
	private DischargeDetails dischargeDetails;

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

	public DischargeDetails getDischargeDetails() {
		return dischargeDetails;
	}

	public void setDischargeDetails(DischargeDetails dischargeDetails) {
		this.dischargeDetails = dischargeDetails;
	}

	@Override
	public String toString() {
		return "PatientDetailsSummary [costOfMedicine=" + costOfMedicine + ", costOfTest=" + costOfTest
				+ ", avgHospitalMedCharge=" + avgHospitalMedCharge + ", avgHospitalTestCharge=" + avgHospitalTestCharge
				+ ", dischargeDetails=" + dischargeDetails + "]";
	}

}