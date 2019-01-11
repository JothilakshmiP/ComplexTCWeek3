package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[3]/div/input")
	private WebElement loginButton;
	
	@FindBy(name="member(user).username")
	private WebElement loginName; 
	
	@FindBy(name="member(name)")
	private WebElement fullName;
	
	@FindBy(name="member(email)")
	private WebElement email;
	
	@FindBy(xpath="//*[@type='text' and @fieldname='birthday']")
	private WebElement dateOfBirth;
	
	@FindBy(css="td:nth-child(4) > label")
	private WebElement genderMale;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input[3]")
	private WebElement address;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/input[3]")
	private WebElement postalCode;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/input[3]")
	private WebElement city;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/select/option[2]")
	private WebElement selectArea;
	
	@FindBy(id="custom_field_select_6")
	private WebElement areaText;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[10]/td[2]/input[3]")
	private WebElement phoneNumber;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[11]/td[2]/input[3]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[12]/td[2]/input[3]")
	private WebElement fax;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[13]/td[2]/input[3]")
	private WebElement url;
	
	@FindBy(name="member(user).password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="saveButton")
	private WebElement submitButton;
	
	public void sendLoginName(String loginName) {
		this.loginName.clear();
		this.loginName.sendKeys(loginName);
	}
	
	public void sendfullName(String fullName) {
		this.fullName.clear();
		this.fullName.sendKeys(fullName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendDtOfBirth(String dateOfBirth) {
		this.dateOfBirth.clear();
		this.dateOfBirth.sendKeys(dateOfBirth);
	}
	
	public void sendAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void sendPostalCode(String postalCode) {
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
	}
	
	public void sendCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
	}
	
	public void sendMobileNumber(String mobileNumber) {
		this.mobileNumber.clear();
		this.mobileNumber.sendKeys(mobileNumber);
	}
	
	public void sendFax(String fax) {
		this.fax.clear();
		this.fax.sendKeys(fax);
	}
	
	public void sendUrl(String url) {
		this.url.clear();
		this.url.sendKeys(url);
	}
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickLoginButtton() {
		this.loginButton.click(); 
	}
	
	public void selectRadioButton(){
		this.genderMale.click();
	}
	
	public void selectArea(){
		this.selectArea.click();
	}
	
	public void clickSubmit(){
		this.submitButton.click();
	}
}
