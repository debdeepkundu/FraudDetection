package com.neo4j.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.neo4j.model.CostForSymptomResponse;
import com.neo4j.model.DischargeParticularResponse;
import com.neo4j.model.PatientDetailsResponse;
import com.neo4j.model.PatientDetailsSummary;
import com.neo4j.model.ResultSummary;
import com.neo4j.repository.DischargeDetailRepository;

@Service
public class DischargeDetailService {

	@Autowired
	DischargeDetailRepository dischargeDetail;

	public CostForSymptomResponse getAll() {
		Collection<ResultSummary> result = dischargeDetail.getAll();
		return populateCostData(result);
	}

	public Collection<Long> getTotalCost() {
		return dischargeDetail.getTotalCost();
	}

	public CostForSymptomResponse getCostForAdmissionId(String admissionId) {
		Collection<ResultSummary> result = dischargeDetail.getCostForAdmissionId(admissionId);
		CostForSymptomResponse response = populateCostData(result);
		if (response.getFraudCount() > 0) {
			response.setMessage("Fraud Detected!!");
		}
		return response;
	}

	private CostForSymptomResponse populateCostData(Collection<ResultSummary> result) {
		CostForSymptomResponse response = new CostForSymptomResponse();
		Long totalCostOfMed = 0L, totalCostOfTest = 0L, totalHospitalTestCost = 0L, totalHospitalMedCost = 0L,
				fraudCount = 0L, hospitalCount = 0L;
		Set<String> hospitalList = new HashSet<>();
		for (ResultSummary resultSummary : result) {
			totalCostOfMed = totalCostOfMed + Integer.valueOf(resultSummary.getCostOfMedicine());
			totalCostOfTest = totalCostOfTest + Integer.valueOf(resultSummary.getCostOfTest());
			totalHospitalTestCost = totalHospitalTestCost + resultSummary.getAvgHospitalTestCharge();
			totalHospitalMedCost = totalHospitalMedCost + resultSummary.getAvgHospitalMedCharge();
			if ((Integer.valueOf(resultSummary.getCostOfMedicine())
					+ Integer.valueOf(resultSummary.getCostOfTest())) > (resultSummary.getAvgHospitalTestCharge()
							+ resultSummary.getAvgHospitalMedCharge())) {
				fraudCount++;
			}
			if (StringUtils.hasText(resultSummary.getHospitalName())
					&& !hospitalList.contains(resultSummary.getHospitalName().toString())) {
				hospitalList.add(resultSummary.getHospitalName());
				hospitalCount++;
			}
		}
		response.setFraudCount(fraudCount);
		response.setTotalCostOfMed(totalCostOfMed);
		response.setTotalCostOfTest(totalCostOfTest);
		response.setTotalHospitalMedCost(totalHospitalMedCost);
		response.setTotalHospitalTestCost(totalHospitalTestCost);
		response.setTotalRecordCount(new Long(result.size()));
		response.setTotalHospitalCount(hospitalCount);
		return response;
	}

	public PatientDetailsResponse getDetails(String patientName, String ssn, String hospitalName) {
		PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
		String[] str = null;
		if (StringUtils.hasText(patientName)) {
			str = patientName.split("\\s+");
		}
		Collection<PatientDetailsSummary> patientMedResult = new ArrayList<>();
		Collection<PatientDetailsSummary> patientTestResult = new ArrayList<>();

		if (StringUtils.hasText(patientName) && StringUtils.hasText(ssn) && StringUtils.hasText(hospitalName)) {
			if (str.length == 3) {
				patientTestResult = dischargeDetail.getPatientTestDetails(str[0].trim(), str[1].trim(), str[2].trim(),
						ssn, hospitalName);
				patientMedResult = dischargeDetail.getPatientMedDetails(str[0].trim(), str[1].trim(), str[2].trim(),
						ssn, hospitalName);
			}
		} else if (StringUtils.hasText(patientName) && StringUtils.hasText(ssn) && !StringUtils.hasText(hospitalName)) {
			if (str.length == 3) {
				patientTestResult = dischargeDetail.getTestFromNameAndSSN(str[0].trim(), str[1].trim(), str[2].trim(),
						ssn);
				patientMedResult = dischargeDetail.getMedFromNameAndSSN(str[0].trim(), str[1].trim(), str[2].trim(),
						ssn);
			}
		} else if (StringUtils.hasText(ssn) && StringUtils.hasText(hospitalName) && !StringUtils.hasText(patientName)) {
			patientTestResult = dischargeDetail.getTestFromSSNAndHospital(ssn, hospitalName);
			patientMedResult = dischargeDetail.getMedFromSSNAndHospital(ssn, hospitalName);
		} else if (StringUtils.hasText(patientName) && StringUtils.hasText(hospitalName) && !StringUtils.hasText(ssn)) {
			if (str.length == 3) {
				patientTestResult = dischargeDetail.getTestFromNameAndHospital(str[0].trim(), str[1].trim(),
						str[2].trim(), hospitalName);
				patientMedResult = dischargeDetail.getMedFromNameAndHospital(str[0], str[1], str[2], hospitalName);
			}
		} else if (StringUtils.hasText(patientName)) {
			if (str.length == 3) {
				patientTestResult = dischargeDetail.getTestFromName(str[0].trim(), str[1].trim(), str[2].trim());
				patientMedResult = dischargeDetail.getMedFromName(str[0].trim(), str[1].trim(), str[2].trim());
			}
		} else if (StringUtils.hasText(ssn)) {
			patientTestResult = dischargeDetail.getTestFromSSN(ssn);
			patientMedResult = dischargeDetail.getMedFromSSN(ssn);
		} else if (StringUtils.hasText(hospitalName)) {
			patientTestResult = dischargeDetail.getTestFromHospital(hospitalName);
			patientMedResult = dischargeDetail.getMedFromHospital(hospitalName);
		}
		Long totalCostOfMed = 0L, totalCostOfTest = 0L, totalHospitalTestCost = 0L, totalHospitalMedCost = 0L;
		List<DischargeParticularResponse> dischargParticularList = new ArrayList<>();
		int dischPosition = 1;
		for (PatientDetailsSummary testSummary : patientTestResult) {
			DischargeParticularResponse discParticualarResponse = new DischargeParticularResponse();
			discParticualarResponse.setSerialNo(dischPosition);
			discParticualarResponse.setHospitalName(testSummary.getDischargeDetails().getTreatmentFacility());
			totalCostOfMed = totalCostOfMed + Integer.valueOf(testSummary.getCostOfMedicine());
			totalCostOfTest = totalCostOfTest + Integer.valueOf(testSummary.getCostOfTest());
			totalHospitalTestCost = totalHospitalTestCost + testSummary.getAvgHospitalTestCharge();
			totalHospitalMedCost = totalHospitalMedCost + testSummary.getAvgHospitalMedCharge();
			discParticualarResponse.setParticulars(testSummary.getDischargeDetails().getMed_test());
			discParticualarResponse.setParticularsType("Test");
			discParticualarResponse.setActualCost(String.valueOf(testSummary.getAvgHospitalTestCharge()));
			dischargParticularList.add(discParticualarResponse);
			dischPosition++;
		}
		for (PatientDetailsSummary medSummary : patientMedResult) {
			DischargeParticularResponse discParticualarResponse = new DischargeParticularResponse();
			discParticualarResponse.setSerialNo(dischPosition);
			discParticualarResponse.setHospitalName(medSummary.getDischargeDetails().getTreatmentFacility());
			totalCostOfMed = totalCostOfMed + Integer.valueOf(medSummary.getCostOfMedicine());
			totalCostOfTest = totalCostOfTest + Integer.valueOf(medSummary.getCostOfTest());
			totalHospitalTestCost = totalHospitalTestCost + medSummary.getAvgHospitalTestCharge();
			totalHospitalMedCost = totalHospitalMedCost + medSummary.getAvgHospitalMedCharge();
			discParticualarResponse.setParticulars(medSummary.getDischargeDetails().getMedicine_name());
			discParticualarResponse.setParticularsType("Medicine");
			discParticualarResponse.setActualCost(String.valueOf(medSummary.getAvgHospitalMedCharge()));
			dischargParticularList.add(discParticualarResponse);
			dischPosition++;
		}
		patientDetailsResponse.setPatientName(patientName);
		patientDetailsResponse.setSsn(ssn);
		patientDetailsResponse.setHospitalName(hospitalName);
		patientDetailsResponse.setTotalCostOfMed(totalCostOfMed);
		patientDetailsResponse.setTotalCostOfTest(totalCostOfTest);
		patientDetailsResponse.setTotalHospitalMedCost(totalHospitalMedCost);
		patientDetailsResponse.setTotalHospitalTestCost(totalHospitalTestCost);
		patientDetailsResponse.setDischargeDetails(dischargParticularList);
		return patientDetailsResponse;
	}
}
