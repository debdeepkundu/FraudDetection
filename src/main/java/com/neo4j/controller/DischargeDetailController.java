package com.neo4j.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.model.CostForSymptomResponse;
import com.neo4j.model.PatientDetailsResponse;
import com.neo4j.service.DischargeDetailService;

@RestController
@RequestMapping("/dischargeDetail")
public class DischargeDetailController {

	@Autowired
	DischargeDetailService dischargeDetailService;

	@GetMapping(path = "/getAll")
	public CostForSymptomResponse getAll() {
		return dischargeDetailService.getAll();
	}

	@GetMapping(path = "/cost")
	public Collection<Long> getTotalCost() {
		return dischargeDetailService.getTotalCost();
	}

	@GetMapping(path = "/id/{admissionId}")
	public CostForSymptomResponse getCostForAdmissionId(@PathVariable String admissionId) {
		return dischargeDetailService.getCostForAdmissionId(admissionId);
	}

	@GetMapping(path = "/details")
	public PatientDetailsResponse getDetails(@RequestHeader Map<String, String> headers) {
		String patientName = headers.get("patient");
		String ssn = headers.get("ssn");
		String hospitalName = headers.get("hospitalname");
		return dischargeDetailService.getDetails(patientName, ssn, hospitalName);
	}
}
