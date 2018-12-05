package com.neo4j.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "SYMPTOM_TEST_MED_MAPPER")
public class SymptomTestMedMapper {

	@Id
	@GeneratedValue
	private Long id;
	private String symptom_id;
	private String test_med_id;
	private String symptom_name;
	private String symptom_description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymptom_id() {
		return symptom_id;
	}

	public void setSymptom_id(String symptom_id) {
		this.symptom_id = symptom_id;
	}

	public String getTest_med_id() {
		return test_med_id;
	}

	public void setTest_med_id(String test_med_id) {
		this.test_med_id = test_med_id;
	}

	public String getSymptom_name() {
		return symptom_name;
	}

	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
	}

	public String getSymptom_description() {
		return symptom_description;
	}

	public void setSymptom_description(String symptom_description) {
		this.symptom_description = symptom_description;
	}

	@Override
	public String toString() {
		return "SymptomTestMedMapper [id=" + id + ", symptom_id=" + symptom_id + ", test_med_id=" + test_med_id
				+ ", symptom_name=" + symptom_name + ", symptom_description=" + symptom_description + "]";
	}
}
