package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MbrSysPaymntPOM {
	private WebDriver driver; 
	
	public MbrSysPaymntPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	
	@FindBy(id="menu2")
	private WebElement mbrAccount;
	
	@FindBy(id="submenu2.5")
	private WebElement mbrSysPaymnt;
	
	@FindBy(id="amount")
	private WebElement payAmount;
	
	@FindBy(id="description")
	private WebElement description; 
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td")
	private WebElement paymntConfirmMsg;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")
	private WebElement confirmSubmitBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[1]/td")
	private WebElement confirmationMsg;
	
	@FindBy(id="submenu2.0")
	private WebElement accntInfo;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[3]")
	private WebElement accntInfoEntry;
	
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
	
	public void clickMbrAccount() {
		this.mbrAccount.click(); 
	}
	
	public void clickMbrSystemPayment() {
		this.mbrSysPaymnt.click(); 
	}
	
	public void sendPayAmount(String amount) {
		this.payAmount.clear(); 
		this.payAmount.sendKeys(amount); 
	}
	
	public void selectTxnType() {
		Select tnxType = new Select(driver.findElement(By.id("type")));
		tnxType.selectByVisibleText("Member to community");
	}
	
	public void sendDescription(String description) {
		this.description.clear(); 
		this.description.sendKeys(description); 
	}
	
	public void clickPaymentSubmit() {
		this.submitButton.click(); 
	}
	
	public void checkPaymntConfirm() {
		String actMsg = this.paymntConfirmMsg.getText();
		String expMsg = "You are about to perform the following payment:";
		Assert.assertEquals(actMsg, expMsg);
		this.confirmSubmitBtn.click();
	}
	
	public void verifyPaymnt() {
		String actMsg = this.confirmationMsg.getText();
		String expMsg = "The payment has been performed";
		Assert.assertEquals(actMsg, expMsg);
	}
	
	public void clickAccountInfo() {
		this.accntInfo.click(); 
	}
	
	public void verifyTxnAdded(String description) {
		String actDesc = this.accntInfoEntry.getText();
		Assert.assertEquals(actDesc, description);
	}
}
