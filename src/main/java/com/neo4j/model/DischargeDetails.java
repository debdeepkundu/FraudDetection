package com.neo4j.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Discharge_Details")
public class DischargeDetails {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String SSN;
	private String TreatmentFacility;
	private String AdmissionDate;
	private String DischargeDate;
	private String provider_id;
	private String Complaint;
	private String Diagnosis;
	private String Med_test;
	private String Test_result;
	private String Medi_test_no;
	private String Cost_of_test;
	private String medicine_name;
	private String medicine_cost;
	private String Admission_id;

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getTreatmentFacility() {
		return TreatmentFacility;
	}

	public void setTreatmentFacility(String treatmentFacility) {
		TreatmentFacility = treatmentFacility;
	}

	public String getAdmissionDate() {
		return AdmissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		AdmissionDate = admissionDate;
	}

	public String getDischargeDate() {
		return DischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		DischargeDate = dischargeDate;
	}

	public String getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String complaint) {
		Complaint = complaint;
	}

	public String getDiagnosis() {
		return Diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}

	public String getMed_test() {
		return Med_test;
	}

	public void setMed_test(String med_test) {
		Med_test = med_test;
	}

	public String getTest_result() {
		return Test_result;
	}

	public void setTest_result(String test_result) {
		Test_result = test_result;
	}

	public String getMedi_test_no() {
		return Medi_test_no;
	}

	public void setMedi_test_no(String medi_test_no) {
		Medi_test_no = medi_test_no;
	}

	public String getCost_of_test() {
		return Cost_of_test;
	}

	public void setCost_of_test(String cost_of_test) {
		Cost_of_test = cost_of_test;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public String getMedicine_cost() {
		return medicine_cost;
	}

	public void setMedicine_cost(String medicine_cost) {
		this.medicine_cost = medicine_cost;
	}

	public String getAdmission_id() {
		return Admission_id;
	}

	public void setAdmission_id(String admission_id) {
		Admission_id = admission_id;
	}

}
