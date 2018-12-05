package com.neo4j.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "TEST_MED_MASTER")
public class TestMedMaster {

	@Id
	@GeneratedValue
	private Long id;
	private String test_med_id;
	private String test_med_name;
	private String test_med_description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTest_med_id() {
		return test_med_id;
	}

	public void setTest_med_id(String test_med_id) {
		this.test_med_id = test_med_id;
	}

	public String getTest_med_name() {
		return test_med_name;
	}

	public void setTest_med_name(String test_med_name) {
		this.test_med_name = test_med_name;
	}

	public String getTest_med_description() {
		return test_med_description;
	}

	public void setTest_med_description(String test_med_description) {
		this.test_med_description = test_med_description;
	}

	@Override
	public String toString() {
		return "TestMedMaster [id=" + id + ", test_med_id=" + test_med_id + ", test_med_name=" + test_med_name
				+ ", test_med_description=" + test_med_description + "]";
	}
}
