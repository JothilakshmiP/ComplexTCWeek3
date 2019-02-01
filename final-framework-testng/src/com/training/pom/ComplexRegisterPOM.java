package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ComplexRegisterPOM {
	private WebDriver driver; 
	
	public ComplexRegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	
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
	
	@FindBy(xpath="//td[2]/table/tbody/tr/td[3]/input")
	private WebElement genderMale;
	
	@FindBy(xpath="//td[2]/table/tbody/tr/td/input")
	private WebElement genderFemale;
	
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
	private WebElement newPassword;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="saveButton")
	private WebElement submitButton;
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement prmngrpSubmitBtn;
	
	@FindBy(name="comments")
	private WebElement comments;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/input")
	private WebElement mbrGroupBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul/li[16]/span[2]")
	private WebElement logoutBtn;
	
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
	
	public void newSendNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickLoginButtton() {
		this.loginButton.click(); 
	}
	
	public void selectRadioButton(String gender){
		if((gender == "male") || (gender == "Male") || (gender == "MALE")) {
			this.genderMale.click();
		}
		else if ((gender == "female") || (gender == "Female") || (gender == "FEMALE")) {
			this.genderFemale.click();
		}
	}
	
	public void selectArea(){
		this.selectArea.click();
	}
	
	public void clickSubmit(){
		this.submitButton.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendMemberLogin(String memberLogin) throws InterruptedException{
		this.memberLogin.clear();
		this.memberLogin.sendKeys(memberLogin);
		
	}
	
	public void prmngrpSubmitBtn() {
		this.prmngrpSubmitBtn.click(); 
	}
	
	public void selectNewGroupId(){
		Select newGroupId = new Select(driver.findElement(By.name("newGroupId")));
		newGroupId.selectByValue("5");
		//	newGroupId.selectByVisibleText("Full members");
	}
	
	public void sendComments(String comments){
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	
	public void clickMbrGroupBtn(){
		this.mbrGroupBtn.click();
	}
	
	public void acceptChangeGroup(){
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		String expected = "The member's group was changed";
		Assert.assertEquals(expected, alertMessage);
	}
	
	public void clickLogout(){
		this.logoutBtn.click();
		Alert alert1 = driver.switchTo().alert();
		String alertMessage = alert1.getText();
		alert1.accept();
		
		
	}
}
