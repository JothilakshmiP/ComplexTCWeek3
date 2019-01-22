package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ModifyMemberProfilePOM {
	private WebDriver driver; 
	
	public ModifyMemberProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	
	@FindBy(linkText="My profile")
	private WebElement profileLink;
	
	@FindBy(id="modifyButton")
	private WebElement modifyButton;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span/input[2]")
	private WebElement addressTextBox;
	
	@FindBy(id="saveButton")
	private WebElement saveButton;
	
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
	
	public void clickMyProfile() {
		this.profileLink.click();
	}
	
	public void clickChangeProfile() {
		this.modifyButton.click();
	}

	public void modifyAddress(String addressNew) {
		this.addressTextBox.clear();
		this.addressTextBox.sendKeys(addressNew);
	}
	
	public void clickSaveProfile() {
		this.saveButton.click();
	}
	
	public void profileModAlert() {
		Alert alert = driver.switchTo().alert();
		String alrtMsg = alert.getText();
		alert.accept();
		String exptdMsg = "Profile modified";
		Assert.assertEquals(exptdMsg, alrtMsg);
	}
}
