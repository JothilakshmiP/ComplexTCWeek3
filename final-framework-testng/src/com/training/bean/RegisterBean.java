package com.training.bean;

import org.testng.annotations.Test;

public class RegisterBean {
	private String loginName;
	private String fullName;
	private String email;
	private String DOB;
	private String gender;
	private String address;
	private String postalCode;
	private String city;
	private String phNumber;
	private String mbNumber;
	private String fax;
	private String url;
	private String newPassword;
	private String confPassword;
  
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPhNumber() {
	return phNumber;
}
public void setPhNumber(String phNumber) {
	this.phNumber = phNumber;
}
public String getMbNumber() {
	return mbNumber;
}
public void setMbNumber(String mbNumber) {
	this.mbNumber = mbNumber;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getNewPassword() {
	return newPassword;
}
public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}
public String getConfPassword() {
	return confPassword;
}
public void setConfPassword(String confPassword) {
	this.confPassword = confPassword;
}

@Test
public RegisterBean() {
}
public RegisterBean(String loginName, String fullName, String email,String DOB, String gender, String address, String postalCode, String city, String phNumber, String mbNumber, String fax, String url, String newPassword, String confPassword) {
	this.loginName=loginName;
	this.fullName=fullName;
	this.email=email;
	this.DOB=DOB;
	this.gender=gender;
	this.address=address;
	this.postalCode=postalCode;
	this.city=city;
	this.phNumber=phNumber;
	this.mbNumber=mbNumber;
	this.fax=fax;
	this.url=url;
	this.newPassword=newPassword;
	this.confPassword=confPassword;
}
}
