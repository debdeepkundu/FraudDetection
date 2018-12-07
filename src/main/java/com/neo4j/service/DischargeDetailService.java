package com.neo4j.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.neo4j.model.CostForSymptomResponse;
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

	public CostForSymptomResponse getCostForSymptom(String symptom) {
		Collection<ResultSummary> result = dischargeDetail.getDischWithCost(symptom);
		return populateCostData(result);
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
			if ((Integer.valueOf(resultSummary.getCostOfMedicine()) + Integer.valueOf(
					resultSummary.getCostOfTest())) > (resultSummary.getAvgHospitalTestCharge()
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
}
