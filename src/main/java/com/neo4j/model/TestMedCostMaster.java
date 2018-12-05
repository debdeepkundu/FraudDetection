package com.neo4j.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "TEST_MED_COST_MASTER")
public class TestMedCostMaster {

	@Id
	@GeneratedValue
	private Long id;
	private String cost_master_id;
	private String test_med_id;
	private String bare_cost;
	private String avg_hospital_cost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCost_master_id() {
		return cost_master_id;
	}

	public void setCost_master_id(String cost_master_id) {
		this.cost_master_id = cost_master_id;
	}

	public String getTest_med_id() {
		return test_med_id;
	}

	public void setTest_med_id(String test_med_id) {
		this.test_med_id = test_med_id;
	}

	public String getBare_cost() {
		return bare_cost;
	}

	public void setBare_cost(String bare_cost) {
		this.bare_cost = bare_cost;
	}

	public String getAvg_hospital_cost() {
		return avg_hospital_cost;
	}

	public void setAvg_hospital_cost(String avg_hospital_cost) {
		this.avg_hospital_cost = avg_hospital_cost;
	}

	@Override
	public String toString() {
		return "TestMedCostMaster [id=" + id + ", cost_master_id=" + cost_master_id + ", test_med_id=" + test_med_id
				+ ", bare_cost=" + bare_cost + ", avg_hospital_cost=" + avg_hospital_cost + "]";
	}
}
