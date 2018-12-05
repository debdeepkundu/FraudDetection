package com.neo4j.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="Hospital_demographics")
public class HospitalDemographics {

	private String provider_Number;
	private String hospital_Reg_Number;
	private String hospital_Name;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String zIPCode;
	private String county;
	private String phone_Number;
	private String hospital_Type;
	private String hospital_Ownership;
	private String emergency_Services;
	public String getProvider_Number() {
		return provider_Number;
	}
	public void setProvider_Number(String provider_Number) {
		this.provider_Number = provider_Number;
	}
	public String getHospital_Reg_Number() {
		return hospital_Reg_Number;
	}
	public void setHospital_Reg_Number(String hospital_Reg_Number) {
		this.hospital_Reg_Number = hospital_Reg_Number;
	}
	public String getHospital_Name() {
		return hospital_Name;
	}
	public void setHospital_Name(String hospital_Name) {
		this.hospital_Name = hospital_Name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getzIPCode() {
		return zIPCode;
	}
	public void setzIPCode(String zIPCode) {
		this.zIPCode = zIPCode;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPhone_Number() {
		return phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}
	public String getHospital_Type() {
		return hospital_Type;
	}
	public void setHospital_Type(String hospital_Type) {
		this.hospital_Type = hospital_Type;
	}
	public String getHospital_Ownership() {
		return hospital_Ownership;
	}
	public void setHospital_Ownership(String hospital_Ownership) {
		this.hospital_Ownership = hospital_Ownership;
	}
	public String getEmergency_Services() {
		return emergency_Services;
	}
	public void setEmergency_Services(String emergency_Services) {
		this.emergency_Services = emergency_Services;
	}
}
