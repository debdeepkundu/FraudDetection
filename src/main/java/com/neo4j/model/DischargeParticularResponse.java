package com.neo4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DischargeParticularResponse {
private int serialNo;
private String hospitalName;
private String causeOfAdmission;
private String particulars;
private String particularsType;
private Integer hospitalBillAmt;
private String actualCost;
public int getSerialNo() {
	return serialNo;
}
public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
public String getCauseOfAdmission() {
	return causeOfAdmission;
}
public void setCauseOfAdmission(String causeOfAdmission) {
	this.causeOfAdmission = causeOfAdmission;
}
public String getParticulars() {
	return particulars;
}
public void setParticulars(String particulars) {
	this.particulars = particulars;
}
public String getParticularsType() {
	return particularsType;
}
public void setParticularsType(String particularsType) {
	this.particularsType = particularsType;
}
public Integer getHospitalBillAmt() {
	return hospitalBillAmt;
}
public void setHospitalBillAmt(Integer hospitalBillAmt) {
	this.hospitalBillAmt = hospitalBillAmt;
}
public String getActualCost() {
	return actualCost;
}
public void setActualCost(String actualCost) {
	this.actualCost = actualCost;
}


}
